// Import the io module from the standard library for input/output operations
use std::io;

fn main() {
    // Print "Guess the number!" to the console
    println!("Guess the number!");

    // Print "Please input your guess." to the console
    println!("Please input your guess.");

    // Create a mutable (by default is inmutable) variable `guess` and initialize it with a new, empty String
    let mut guess = String::new();

    // Call the stdin function from the io module to get the standard input handle
    // Read a line of input from the user and store it in the `guess` variable
    // If reading the line fails, print an error message and terminate the program
    io::stdin()
        /*  The full job of read_line is to take whatever the user types into standard input
        and append that into a string (without overwriting its contents),
        so we therefore pass that string as an argument.
        
        The & indicates that this argument is a reference, which gives you a way to let multiple
        parts of your code access one piece of data without needing to copy that data into memory multiple times.

        Should be: "&mut guess" rather than "&guess" to make it mutable
        */
        .read_line(&mut guess)
        /*
        Values of the Result type, like values of any type,
        have methods defined on them. An instance of Result has an expect
        method that you can call. If this instance of Result is an Err value,
        expect will cause the program to crash and display the message that
        you passed as an argument to expect. If the read_line method returns an Err,
        it would likely be the result of an error coming from the underlying operating system.
        If this instance of Result is an Ok value, expect will take the return value that Ok
        is holding and return just that value to you so you can use it.
        In this case, that value is the number of bytes in the user’s input.
         */
        .expect("Failed to read line");

    // Print "You guessed: " followed by the value of the `guess` variable to the console
    println!("You guessed: {}", guess);
} // End of the main function
 
 // Continue on: https://doc.rust-lang.org/book/ch02-00-guessing-game-tutorial.html#generating-a-secret-number

