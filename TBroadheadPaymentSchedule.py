def calculate_discount(purchase_price, is_student, is_veteran):
    discount = 0
    if is_student:
        discount = 0.07
        if is_veteran:
            discount = 0.12
    return discount

def generate_payment_schedule(purchase_price, is_student, is_veteran):
    down_payment_rate = 0.10
    annual_interest_rate = 0.15
    monthly_payment_rate = 0.05

    discount = calculate_discount(purchase_price, is_student, is_veteran)
    discounted_price = purchase_price * (1 - discount)

    down_payment = discounted_price * down_payment_rate
    loan_amount = discounted_price - down_payment
    monthly_interest_rate = annual_interest_rate / 12

    # Calculate monthly payment
    monthly_payment = (loan_amount * monthly_interest_rate) / (1 - (1 + monthly_interest_rate) ** -12)

    # Generate payment schedule
    remaining_balance = loan_amount
    schedule = []
    for month in range(1, 13):
        interest_payment = remaining_balance * monthly_interest_rate
        principal_payment = monthly_payment - interest_payment
        remaining_balance -= principal_payment

        schedule.append((month, monthly_payment, interest_payment, principal_payment, remaining_balance))

    return schedule

def main():
    # Get user input
    purchase_price = float(input("Enter the purchase price: $"))
    is_student = input("Is the buyer a student? (yes/no): ").lower() == 'yes'
    is_veteran = False

    if is_student:
        is_veteran = input("Is the student a veteran? (yes/no): ").lower() == 'yes'

    # Generate payment schedule
    payment_schedule = generate_payment_schedule(purchase_price, is_student, is_veteran)

    # Print payment schedule
    print("\nPayment Schedule:")
    print("{:<6}{:<18}{:<11}{:<13}{:<18}".format("Month", "Monthly Payment", "Interest", "Principal", "Remaining Balance"))
    for entry in payment_schedule:
        print("{:<6}${:<17.2f}${:<10.2f}${:<12.2f}${:<17.2f}".format(*entry))

if __name__ == "__main__":
    main()
