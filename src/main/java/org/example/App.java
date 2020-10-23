package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
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


        try {
            Scanner scanner = new Scanner(new File(String.valueOf(file)));
            scanner.useDelimiter("[,\r\n]+");

            String studentID;
            int[] codes = new int[8];
            int[] grades = new int[8];


            while (scanner.hasNext()) {

                studentID = scanner.next(); // reads in as String

                for (int i = 0; i < 8; i++) {
                    codes[i] = scanner.nextInt();
                    grades[i] = scanner.nextInt();
                }
                int[] selectedGrades = selectFiveGrades(codes, grades);
                System.out.println(Arrays.toString(selectedGrades));
//                double avg = calculateAverage(selectedGrades);
//                System.out.println(avg);

            }

        } catch (IOException e) {
            System.out.println("Error - Couldn't find file");
        }

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


        return avg;
    }
}
