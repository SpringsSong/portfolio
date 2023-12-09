/*importing the scanner util*/
import java.util.*;
public class TBRepairEstimate {
    public static double compute(double materialSubtotal, boolean veteranDiscountApplied) {
        /*Variable declaration for the compute method. I couldn't get them to work outside the method,
        so they are here instead.*/
        final double hourlyRate = 43.50;
        final double travelRate = 9.25;
        final double taxes = 0.0825;
        final double veteranDiscount = 0.125;
        double travelTime;
        double estimatedWorkHours;
        double workSubtotal;
        double travelSubtotal = 0;
        double veteranEstimate = 0;
        double estimateSubtotal;
        double taxSubtotal;
        double finalTotal = 0;
        Scanner input = new Scanner(System.in);

        /*Enter travel time in minutes. If job is greater than 120 minutes, the job is rejected and no further
        calculations are made.*/
        System.out.println("Please input the travel time in minutes for this job.");
        System.out.println("Be advised that travel times in excess of 120 minutes (2 hours) will be rejected.");
        travelTime = input.nextDouble();
        input.nextLine();

        /*Begin calculations for job estimate.*/
        if(travelTime <= 120) {
            System.out.println("Please enter the estimated hours for this job.");
            estimatedWorkHours = input.nextDouble();
            input.nextLine();
            workSubtotal = estimatedWorkHours * hourlyRate;
            /*Me making sure I was doing my math correctly*/
            /*System.out.println("This job will cost approximately $" +
                    String.format("%.2f", workSubtotal) + " for labor.");*/

            if(travelTime > 30) {
                travelSubtotal = (travelTime/60) * travelRate;
                /*Making sure correct calculations are made*/
                /*System.out.println("Additionally, this job will require $" +
                        String.format("%.2f", travelSubtotal) + " for travel expenses.");*/
            }
            else {
                System.out.println("Because this job takes less than 30 minutes to commute to," +
                        " there is no cost for travel.");
            }

            /*Determine the subtotal for the job. Different equations for if customer is a veteran.*/
            estimateSubtotal = travelSubtotal + workSubtotal + materialSubtotal;
            if (veteranDiscountApplied == true) {
                veteranEstimate = estimateSubtotal + (estimateSubtotal * veteranDiscount);
                taxSubtotal = veteranEstimate * taxes;
                finalTotal = veteranEstimate + taxSubtotal;
            }
            else {
                taxSubtotal = estimateSubtotal * taxes;
                finalTotal = taxSubtotal + estimateSubtotal;
            }

            /*Display breakdown of job cost*/
            System.out.println("Overall, you will be spending: ");
            System.out.println("$" + String.format("%.2f", materialSubtotal) + " for materials");
            System.out.println("$" + String.format("%.2f", workSubtotal) + " for labor");
            System.out.println("$" + String.format("%.2f", travelSubtotal) + " for travel expenses");
            if(veteranDiscountApplied == true){
                System.out.println("You saved $" + (estimateSubtotal - veteranEstimate) +
                        " due to your service for our country.");
            }
            System.out.println("$" + String.format("%.2f", taxSubtotal) + " in taxes");
            System.out.println("Your final estimate for this job is $" + String.format("%.2f", finalTotal));
        }
        /*Rejection message if job is too far away.*/
        if(travelTime > 120) {
            System.out.println("This job is too far away to be accepted.");
        }
        return finalTotal;
    }
    public static void main(String[] args) {
        /*Variable declaration for the main function.*/
        String jobName;
        String material;
        double individualMaterialCost;
        double materialQuantity;
        double materialsCost;
        double materialSubtotal = 0;
        String isVeteran;
        boolean veteranDiscountApplied;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Henderson's Repair Services.");
        System.out.println("Please enter a job name, or enter nothing (\"\") to quit:");
        jobName = input.nextLine();

        /*While loop allows for multiple jobs to be entered.*/
        while (jobName != ""){
            System.out.println("Please enter the necessary materials for the job, or enter nothing (\"\") to quit: ");
            material = input.nextLine();

            /*While loop allows for multiple material names, quantities, and costs to be entered*/
            while(material != "") {
                System.out.println("Enter how much of that material you expect you will need: ");
                materialQuantity = input.nextDouble();
                input.nextLine();

                System.out.println("Enter how much that material will cost: ");
                individualMaterialCost = input.nextDouble();
                input.nextLine();

                /*Cost of material quantity totaled here, and added to overall material subtotal*/
                materialsCost = materialQuantity * individualMaterialCost;
                materialSubtotal += materialsCost;

                System.out.println("Please enter the necessary materials for the job," +
                        " or enter nothing (\"\") to quit: ");
                material = input.nextLine();
            }
            System.out.println("Is the customer a veteran? Enter Y/y for yes, or anything else for no: ");
            isVeteran = input.nextLine();

            /*Determining if customer is veteran or not*/
            if (isVeteran == "Y" || isVeteran == "y") {
                veteranDiscountApplied = true;
            }
            else {
                veteranDiscountApplied = false;
            }
            /*Call the compute method, which has the bulk of the function of the program*/
            compute(materialSubtotal, veteranDiscountApplied);

            /*Begin the loop again*/
            System.out.println("Please enter a job name, or enter nothing (\"\") to quit: ");
            jobName = input.nextLine();
        }
        /*Exiting the loop and ending program execution*/
        System.out.println("Thank you for choosing Henderson's Repair Services. Have a great day.");
    }
}