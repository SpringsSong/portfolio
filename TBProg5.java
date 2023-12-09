import java.util.*;
public class TBProg5 {

    /*displayGrades method prints out the array*/
    public static void displayGrades(double[] grades) {
        System.out.println("You entered the following values: ");
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.println("Grade " + (i + 1) + ": " + grades[i]);
        }
    }

    /*averageGrades takes the values within the array and averages them*/
    public static void averageGrades(double[] grades) {
        System.out.println("The average of the fifteen grades entered is: ");
        double sum = 0;
        for (int i = 0; i < 15; ++i) {
            sum += grades[i];
        }
        double average = sum / 15;
        System.out.println(average);
    }

    /*belowPoint takes the provided point and prints the grades below that*/
    public static void belowPoint(double[] grades) {
        int value = 70;
        System.out.println("The grades that are below " + value + " are: ");
        for (int i = 0; i < 15; ++i) {
            if (grades[i] < value) {
                System.out.print(grades[i] + " ");
            }
        }
    }

    /*minMax sorts the grades in ascending order and prints the lowest and highest values*/
    public static void minMax(double[] grades) {
        double sortGrades = grades.length - 1;
        for (int i = 0; i < grades.length - 1; i++) {
            for (int j = 0; j < sortGrades; j++) {
                if (grades[j] > grades[j + 1]) {
                    double temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;
                }
            }
            sortGrades--;
        }
        /*for (int i = 0; i < 15; ++i) {
            System.out.print(grades[i] + " ");
        }*/
        System.out.println();
        double min = grades[0];
        for (int i = 0; i < 15; i++) {
            if (min > grades[i]) {
                min = grades[i];
            }
        }
        double max = 0;
        for (int i = 0; i < 15; i++) {
            if (max < grades[i]) {
                max = grades[i];
            }
        }
        System.out.println("The lowest grade in the list is " + min + " while the highest grade is " + max + ".");
    }
    public static void main(String[] args) {
        /*Summary of program purpose follows*/
        System.out.println("Welcome to this grade entry program.");
        System.out.println("This program accepts the entry of fifteen grades into an array," +
                " prints all of the elements in the array, prints the grades below 70, sort the array in ascending " +
                "order and prints the highest and lowest grades entered, averages the grades, and finally, asks if " +
                "another set of grades.");
        System.out.println("Values below zero and above 100 will not be accepted.");
        System.out.print("You will also be able to enter in additional sets of grades should you so choose " +
                "by entering Y/y to continue or N/n to quit.\n\n");

        /*Variable declaration and scanner initialization*/
        int control;
        double[] grades = new double[15];
        double grade;
        int i;
        Scanner input = new Scanner(System.in);

        /*Program execution begins here*/
        System.out.println("Welcome to the entry program.");
        System.out.println("Enter 1 to enter a set of 15 grades or -1 to quit: ");
        control = input.nextInt();
        input.nextLine();

        /*Begin execution of loop that will allow entry of multiple 15-grade sets*/
        while (control != -1) {
            for (i = 0; i < 15;) {
                System.out.println("Please enter value number " + (i + 1));
                grade = input.nextInt();
                input.nextLine();
                /*Verify that value is valid*/
                if (grade > 100 || grade < 0) {
                    System.out.println("Invalid entry!");
                    System.out.println("Entries must be between 0 and 100, inclusive.");
                } else {
                    grades[i] = grade;
                    i++;
                }
            }

            /*Call methods for displaying different portions executed above*/
            displayGrades(grades);
            System.out.println();

            averageGrades(grades);
            System.out.println();

            belowPoint(grades);
            System.out.println();

            minMax(grades);
            System.out.println();

            /*Prompt for additional input*/
            System.out.println("Enter 1 to enter another set of 15 grades or -1 to quit: ");
            control = input.nextInt();
            input.nextLine();
        }
        /*Exit program*/
        System.out.println("Thank you for using this program.");
    }
}