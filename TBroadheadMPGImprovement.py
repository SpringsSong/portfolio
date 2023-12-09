def calculate_mpg(miles, gallons):
    if gallons != 0:
        return miles / gallons
    else:
        return 0

def main():
    total_miles = 0
    total_gallons = 0
    entry_count = 0

    keep_running = True

    while keep_running:
        miles = float(input("Enter miles traveled (-1 to exit): "))

        if miles == -1:
            keep_running = False
        else:
            gallons = float(input("Enter gallons of gas used: "))

            mpg = calculate_mpg(miles, gallons)

            print(f"MPG for this trip: {mpg:.2f}\n")

            total_miles += miles
            total_gallons += gallons
            entry_count += 1

    if entry_count > 0:
        overall_mpg = calculate_mpg(total_miles, total_gallons)
        print(f"\nOverall average MPG: {overall_mpg:.2f}")

if __name__ == "__main__":
    main()
