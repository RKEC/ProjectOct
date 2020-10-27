package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public void start() {
        File fileName = new File("JC_Results.txt");
        readFile(fileName);

    }

    public void readFile(File file) {
        //declare
        String studentID;
        int[] codes = new int[8];
        int[] grades = new int[8];


        try {
            Scanner scanner = new Scanner(new File(String.valueOf(file)));
            scanner.useDelimiter("[,\r\n]+");
            System.out.println("Student Average");
            //runs through data until there is no more in file
            while (scanner.hasNext()) {
                studentID = scanner.next();
                for (int i = 0; i < 8; i++) {
                    codes[i] = scanner.nextInt();
                    grades[i] = scanner.nextInt();
                }

                Student student = new Student(studentID, codes, grades);

                int[] selectedGrades = selectFiveGrades(student.getCodes(), student.getGrades());
                double avg = calculateAverage(selectedGrades);

                print(student.getStudentID(), avg);
            }
        } catch (IOException e) {
            System.out.println("Error - Couldn't find file");
        }
    }

    public int[] selectFiveGrades(int[] codes, int[] grades) {
        //declare
        ArrayList<Integer> bestGrades = new ArrayList<>();
        int largestA = grades[0];
        int largestB = -1;

        //loop that identifies best grades
        for (int i = 0; i < codes.length; i++) {
            //adds Maths, Irish and English to arr
            if (codes[i] <= 3) {
                bestGrades.add(grades[i]);
            } else if (codes[i] > 3) {
                //loop that find the highest grades that isn't Maths, Irish or English
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
        //adds highest grade to arr
        bestGrades.add(largestA);
        //adds second highest grade to arr
        bestGrades.add(largestB);

        int[] result = new int[bestGrades.size()];
        for (int j = 0; j < bestGrades.size(); j++) {
            result[j] = bestGrades.get(j);
        }

        return result;
    }

    public double calculateAverage(int[] selectedGrades) {
        //declare
        double avg;
        int total = 0;

        //loop to add grades
        for (int selectedGrade : selectedGrades) {
            total += selectedGrade;
        }
        //cal to get avg
        avg = (double) total / selectedGrades.length;

        return avg;
    }

    private void print(String studentID, double avg) {
        //prints details neatly in table form
        System.out.printf("%s %6.2f\n", studentID, avg);
    }
}
