#include <stdio.h>

// Constants
const float tax = 0.08625;
const float commissionPercent = 0.072;
const float hourlyWage = 15.0;
const float overtimePayRate = 1.5;

// Function prototypes
void calculateManagerPay(int managerCount, int managerIDs[], float managerSalaries[]);
void calculateHourlyPay(int hourlyCount, int hourlyIDs[], int hourlyHours[]);
void calculateCommissionedPay(int commissionedCount, int commissionedIDs[], float commissionedSales[]);

void printTableHeader();
void printEmployeeRow(int employeeID, float grossSalary, float taxesPaid, float netPay);

int main() {
    int employeeCode;

    do {
        // Prompt for employee code
        printf("\nEnter employee code (1 for Manager, 2 for Hourly, 3 for Commissioned, -1 to quit): ");
        scanf("%d", &employeeCode);

        switch (employeeCode) {
            case 1: {
                // Collect data for managers
                int managerIDs[5];
                float managerSalaries[5];
                calculateManagerPay(5, managerIDs, managerSalaries);
                break;
            }
            case 2: {
                // Collect data for hourly employees
                int hourlyIDs[10];
                int hourlyHours[10];
                calculateHourlyPay(10, hourlyIDs, hourlyHours);
                break;
            }
            case 3: {
                // Collect data for commissioned workers
                int commissionedIDs[5];
                float commissionedSales[5];
                calculateCommissionedPay(5, commissionedIDs, commissionedSales);
                break;
            }
            case -1:
                printf("Exiting program...\n");
                break;
            default:
                printf("Invalid employee code\n");
                break;
        }
    } while (employeeCode != -1);

    return 0;  // Indicates successful execution
}

void printTableHeader() {
    printf("\n%-15s%-15s%-15s%-15s\n", "Employee ID", "Gross Salary", "Taxes Paid", "Net Pay");
    printf("--------------------------------------------------------\n");
}

void printEmployeeRow(int employeeID, float grossSalary, float taxesPaid, float netPay) {
    printf("%-15d%-15.2f%-15.2f%-15.2f\n", employeeID, grossSalary, taxesPaid, netPay);
}

void calculateManagerPay(int managerCount, int managerIDs[], float managerSalaries[]) {
    for (int i = 0; i < managerCount; ++i) {
        // Prompt for employee ID and annual salary
        printf("Enter employee ID for Manager %d: ", i + 1);
        scanf("%d", &managerIDs[i]);
        printf("Enter annual salary: ");
        scanf("%f", &managerSalaries[i]);
    }

    // Print the results in a tabular format
    printTableHeader();
    for (int i = 0; i < managerCount; ++i) {
        int employeeID = managerIDs[i];
        float grossSalary = managerSalaries[i];
        float taxesPaid = grossSalary * tax;
        float netPay = grossSalary - taxesPaid;
        printEmployeeRow(employeeID, grossSalary, taxesPaid, netPay);
    }
}

void calculateHourlyPay(int hourlyCount, int hourlyIDs[], int hourlyHours[]) {
    for (int i = 0; i < hourlyCount; ++i) {
        // Prompt for employee ID and hours worked
        printf("Enter employee ID for Hourly Employee %d: ", i + 1);
        scanf("%d", &hourlyIDs[i]);
        printf("Enter hours worked: ");
        scanf("%d", &hourlyHours[i]);
    }

    // Print the results in a tabular format
    printTableHeader();
    for (int i = 0; i < hourlyCount; ++i) {
        int employeeID = hourlyIDs[i];
        int hoursWorked = hourlyHours[i];
        float grossSalary;
        if (hoursWorked <= 40) {
            grossSalary = hoursWorked * hourlyWage;
        } else {
            int overtime = hoursWorked - 40;
            float overtimePay = hourlyWage * overtimePayRate;
            grossSalary = (hourlyWage * 40) + (overtime * overtimePay);
        }
        float taxesPaid = grossSalary * tax;
        float netPay = grossSalary - taxesPaid;
        printEmployeeRow(employeeID, grossSalary, taxesPaid, netPay);
    }
}

void calculateCommissionedPay(int commissionedCount, int commissionedIDs[], float commissionedSales[]) {
    for (int i = 0; i < commissionedCount; ++i) {
        // Prompt for employee ID and commission sales
        printf("Enter employee ID for Commissioned Worker %d: ", i + 1);
        scanf("%d", &commissionedIDs[i]);
        printf("Enter commission sales: ");
        scanf("%f", &commissionedSales[i]);
    }

    // Print the results in a tabular format
    printTableHeader();
    for (int i = 0; i < commissionedCount; ++i) {
        int employeeID = commissionedIDs[i];
        float commissionSales = commissionedSales[i];
        float grossSalary = commissionSales * commissionPercent;
        float taxesPaid = grossSalary * tax;
        float netPay = grossSalary - taxesPaid;
        printEmployeeRow(employeeID, grossSalary, taxesPaid, netPay);
    }
}
