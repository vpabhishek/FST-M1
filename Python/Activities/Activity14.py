def generate_fibonacci(n):
    # Starting values for the Fibonacci sequence
    fib_sequence = []
    a, b = 0, 1
    
    # Generate Fibonacci sequence up to the nth number
    for _ in range(n):
        fib_sequence.append(a)
        a, b = b, a + b  # Update a and b to the next pair in the sequence
    
    return fib_sequence

def main():
    # Ask the user how many Fibonacci numbers to generate
    try:
        num = int(input("How many Fibonacci numbers would you like to generate? "))
        
        if num <= 0:
            print("Please enter a positive integer.")
        else:
            fibonacci_numbers = generate_fibonacci(num)
            print("The first", num, "Fibonacci numbers are:")
            print(fibonacci_numbers)
    
    except ValueError:
        print("Invalid input! Please enter a positive integer.")

if __name__ == "__main__":
    main()
