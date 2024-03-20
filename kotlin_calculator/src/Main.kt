// Import necessary math functions from Kotlin standard library
import kotlin.math.pow
import kotlin.math.sqrt

// Calculator class to encapsulate calculator functionalities
class Calculator {
    // List to store calculation history
    private val calculationHistory = mutableListOf<String>()

    // Function to perform addition
    fun performAddition(num1: Double, num2: Double): Double {
        val result = num1 + num2

        // Record calculation history
        recordCalculation("$num1 + $num2 = $result")
        return result
    }

    // Function to perform subtraction
    fun performSubtraction(num1: Double, num2: Double): Double {
        val result = num1 - num2

        // Record Calculation history
        recordCalculation("$num1 - $num2 = $result")
        return result
    }

    // Function to perform multiplication
    fun performMultiplication(num1: Double, num2: Double): Double {
        val result = num1 * num2

        // Record calculation history
        recordCalculation("$num1 * $num2 = $result")
        return result
    }

    // Function to perform division
    fun performDivision(dividend: Double, divisor: Double): Double {
        if (divisor == 0.0) {
            throw IllegalArgumentException("Divisor cannot be zero")
        }
        val result = dividend / divisor

        // Record calculation history
        recordCalculation("$dividend / $divisor = $result")
        return result
    }

    // Function to perform square root
    fun performSquareRoot(num: Double): Double {
        if (num < 0) {
            throw IllegalArgumentException("Cannot calculate square root of negative number")
        }

        val result = sqrt(num)

        // record calculation history
        recordCalculation("sqrt($num) = $result")
        return result
    }

    // Function to perform power operation
    fun performPower(base: Double, exponent: Double): Double {
        val result = base.pow(exponent)

        // Record calculation history
        recordCalculation("$base ^ $exponent = $result")
        return result
    }

    // Function to perform percentage operation
    fun performPercentage(value: Double, percentage: Double): Double {
        val result = value * percentage / 100

        // Record calculation history
        recordCalculation("$percentage% of $value = $result")
        return result
    }

    // Private function to record calculation history
    private fun recordCalculation(calculation: String) {
        calculationHistory.add(calculation)
    }

    // Display calculation history
    fun displayCalculationHistory() {
        println("Calculation History:")
        calculationHistory.forEachIndexed { index, calculation ->
            println("${index + 1}. $calculation")
        }
    }

    // Function to demonstrate the creation and modification of collections (stretch challenge)
    fun demonstrateCollections() {
        val numbers = mutableListOf<Double>()

        // Add numbers to the collection
        numbers.add(10.0)
        numbers.add(20.0)
        numbers.add(30.0)

        // Print the Original numbers
        println("Original Numbers: $numbers")

        // Modify the collection to add more numbers
        numbers.add(40.0)
        numbers.add(50.0)

        // Print the modified collection
        println("Modified Numbers: $numbers")
    }
}

// Main function to run the calculator application
fun main() {
    println("Welcome to Basic Calculator")

    // Create an instance of  calculator class
    val calculator = Calculator()

    while (true) {
        // Display menu options
        println("Enter your choice: ")
        println("1. Addition")
        println("2. Subtraction")
        println("3. Multiplication")
        println("4. Division")
        println("5. Square Root")
        println("6. Power")
        println("7. Percentage")
        println("8. Display Calculation History")

        // Added option for demonstrating collections
        println("9. Demonstrate Collections")

        println("10. Exit")

        // Take user input for choice
        val choice = readLine()?.toIntOrNull()

        // Perform corresponding action base on user choice
        when (choice) {
            1 -> performBinaryOperation(calculator::performAddition, "Enter first number: ", "Enter second number: ")
            2 -> performBinaryOperation(calculator::performSubtraction, "Enter first number: ", "Enter second number: ")
            3 -> performBinaryOperation(calculator::performMultiplication, "Enter first number: ", "Enter second number: ")
            4 -> performBinaryOperation(calculator::performDivision, "Enter dividend:", "Enter divisor: ")
            5 -> performUnaryOperation(calculator::performSquareRoot, "Enter a number to find its square root: ")
            6 -> performBinaryOperation(calculator::performPower, "Enter the base: ", "Enter the exponent: ")
            7 -> performBinaryOperation(calculator::performPercentage, "Enter the value: ", "Enter the percentage: ")
            8 -> calculator.displayCalculationHistory()

            // Added option to demonstrate collection
            9 -> calculator.demonstrateCollections()
            10 -> {
                // Display exit message
                println("Exiting...")

                // Exit the program
                return
            }
            // Display message for invalid choice
            else -> println("Invalid choice. Please enter a number between 1 and 10")
        }
    }
}

// Function to perform binary operations (operations with two operands)
fun performBinaryOperation(operation: (Double, Double) -> Double, prompt1: String, prompt2: String) {

    // Prompt user for first operand
    println(prompt1)

    // Read and parse user input for first operand
    val num1 = readLine()?.toDoubleOrNull() ?: return

    // Prompt user for second operand
    println(prompt2)

    // Read and parse user input for second operand
    val num2 = readLine()?.toDoubleOrNull() ?: return

    try {
        // Perform operation
        val result = operation(num1, num2)

        // Display result
        println("Result: $result")
    } catch (e: IllegalArgumentException) {

        // Handle exception
        println("Error: ${e.message}")
    }
}

// Function to perform unary operations (operation with one operand)
fun performUnaryOperation(operation: (Double) -> Double, prompt: String) {
    // Prompt user for operand
    println(prompt)

    // Read and parse user input for operand
    val num = readLine()?.toDoubleOrNull() ?: return

    try {
        // Perform operation
        val result = operation(num)

        // Display result
        println("Result: $result")
    } catch (e: IllegalArgumentException) {

        // Handle exception
        println("Error: ${e.message}")
    }
}
