#include <stdio.h>

const float downPaymentRate = 0.10;
const float annualInterestRate = 0.15;
const float monthlyPaymentRate = 0.05;
const float studentDiscount = 0.07;
const float veteranDiscount = 0.12;

void printPaymentSchedule(float purchasePrice, int isStudent, int isVeteran);

int main() {
    float purchasePrice;
    int isStudent, isVeteran;

    // Get user input
    printf("Enter the purchase price: $");
    scanf("%f", &purchasePrice);

    printf("Is the buyer a student? (1 for Yes, 0 for No): ");
    scanf("%d", &isStudent);

    if (isStudent) {
        printf("Is the student a veteran? (1 for Yes, 0 for No): ");
        scanf("%d", &isVeteran);
    } else {
        isVeteran = 0; // If not a student, not applicable
    }

    // Calculate discounted price
    float discountedPrice = purchasePrice;
    if (isStudent) {
        discountedPrice -= purchasePrice * studentDiscount;
        if (isVeteran) {
            discountedPrice -= purchasePrice * veteranDiscount;
        }
    }

    // Print payment schedule
    printPaymentSchedule(discountedPrice, isStudent, isVeteran);

    return 0;
}

void printPaymentSchedule(float purchasePrice, int isStudent, int isVeteran) {
    // Calculate down payment
    float downPayment = purchasePrice * downPaymentRate;
    float loanAmount = purchasePrice - downPayment;
    float monthlyInterestRate = annualInterestRate / 12;

    // Calculate monthly payment
    float monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - pow(1 + monthlyInterestRate, -12));

    // Print payment schedule
    printf("\nPayment Schedule:\n");
    printf("Month\tMonthly Payment\tRemaining Balance\n");
    
    float remainingBalance = loanAmount;
    for (int month = 1; month <= 12; ++month) {
        remainingBalance -= monthlyPayment - remainingBalance * monthlyInterestRate;

        printf("%d\t$%.2f\t\t$%.2f\n", month, monthlyPayment, remainingBalance);
    }
}
