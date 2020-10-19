package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.start();
    }
    private static void start() {

        File file = new File("JC_Results.txt");
        readFile(file);

    }

    public static void readFile(File file) {


        try {
            Scanner scanner = new Scanner(new File(String.valueOf(file)));
            scanner.useDelimiter("[,\r\n]+");

            String studentID;
            int[] codes = new int[8];
            int[] grades = new int[8];


            while( scanner.hasNext() ) {

                studentID = scanner.next(); // reads in as String

                for( int i=0; i<8; i++) {
                        codes[i] = scanner.nextInt();
                        grades[i] = scanner.nextInt();
                }

                int[] selectedGrades = selectFiveGrades( codes, grades );
                System.out.println(Arrays.toString(selectedGrades));
            }
        }
        catch  (IOException e) {
            System.out.println("Error - Couldn't find file");
        }

    }


    public static int[] selectFiveGrades(int[] codes, int[] grades) {

        int[] bestGrades = new int[5];
        int[] temp = new int[8];

        for(int i = 0; i < codes.length; i++)
        {
            while(bestGrades.length <= 5) {
                if (codes[i] < 3) {
                    grades[i] = bestGrades[i];
                } else {
                    if(grades[i] > temp[i])
                    {
                        temp[i] = grades[i];
                    }
                }
            }
        }



        return bestGrades;
    }

    private double calculateAverage(int[] selectedGrades) {
        double avg = 0;

        return avg;
    }
}
