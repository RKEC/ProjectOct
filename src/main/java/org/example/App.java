package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Richard Collins
 * D00230925
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private static void start() {
        File fileName = new File("JC_Results.txt");
        readFile(fileName);
    }

    public static void readFile(File file) {
        int[] codes = new int[8];
        int[] grades = new int[8];
        String studentID = null;

        try {
            Scanner scanner = new Scanner(new File(String.valueOf(file)));
            scanner.useDelimiter("[,\r\n]+");
            System.out.println("Student Average");
            while (scanner.hasNext()) {
                studentID = scanner.next();
                for (int i = 0; i < 8; i++) {
                    codes[i] = scanner.nextInt();
                    grades[i] = scanner.nextInt();
                }
                int[] selectedGrades = selectFiveGrades(codes, grades);
                double avg = calculateAverage(selectedGrades);

                print(studentID, avg);
            }
        } catch (IOException e) {
            System.out.println("Error - Couldn't find file");
        }


    }

    private static void print(String studentID, double avg) {
        System.out.printf("%s %6.2f\n" , studentID, avg);
    }

    public static int[] selectFiveGrades(int[] codes, int[] grades) {
        ArrayList<Integer> bestGrades = new ArrayList<>(0);
        int largestA = grades[0];
        int largestB = -1;

        for (int i = 0; i < codes.length; i++) {
            if (codes[i] <= 3) {
                bestGrades.add(grades[i]);
            } else if (codes[i] > 3) {

                for (int j = 0; j < grades.length; j++) {
                    if (grades[i] > largestA) {
                        largestB = largestA;
                        largestA = grades[i];
                    } else if (grades[i] > largestB && largestA != grades[i]) {
                        largestB = grades[i];
                    }
                }
            }
        }
        bestGrades.add(largestA);
        bestGrades.add(largestB);
        int[] result = new int[bestGrades.size()];

        for (int j = 0; j < bestGrades.size(); j++) {
            result[j] = bestGrades.get(j);
        }

        return result;
    }

    public static double calculateAverage(int[] selectedGrades) {
        double avg = 0;
        int total = 0;

        for (int i = 0; i < selectedGrades.length; i++) {
            total = selectedGrades[i] + total;
        }
        avg = (double) total / selectedGrades.length;

        return avg;
    }

}
