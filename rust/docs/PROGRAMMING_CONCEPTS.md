# Overview

This file describes the syntax and semantics of the Rust programming language.

# Constants

Constants are values that are bound to a name and are not allowed to change. They are declared using the `const` keyword.

```rust
const MAX_POINTS: u32 = 100_000;
```

# Shadowing

Shadowing is a feature that allows you to redeclare a variable with the same name. This is useful when you want to change the type of a variable but keep the same name.

```rust
fn main() {
    let x = 5;

    let x = x + 1;

    {
        let x = x * 2;
        println!("The value of x in the inner scope is: {x}");
    }

    println!("The value of x is: {x}");
}

/*
Expected output:

$ cargo run
   Compiling variables v0.1.0 (file:///projects/variables)
    Finished `dev` profile [unoptimized + debuginfo] target(s) in 0.31s
     Running `target/debug/variables`
The value of x in the inner scope is: 12
The value of x is: 6


Shadowing is different from marking a variable as mut because we’ll get a compile-time error if we accidentally try to reassign to this variable without using the let keyword. By using let, we can perform a few transformations on a value but have the variable be immutable after those transformations have been completed.
    */
```

# Data Types

Keep in mind that Rust is a statically typed language, which means that it must know the types of all variables at compile time. The compiler can usually infer what type we want to use based on the value and how we use it. In cases when many types are possible, such as when we converted a String to a numeric type using parse in the “Comparing the Guess to the Secret Number” section in Chapter 2, we must add a type annotation, like this:

```rust
let guess: u32 = "42".parse().expect("Not a number!");

/* If we don’t add the : u32 type annotation shown in the preceding code, Rust will display the following error, which means the compiler needs more information from us to know which type we want to use: */

/*  --> src/main.rs:2:9
  |
2 |     let guess = "42".parse().expect("Not a number!");
  |         ^^^^^        ----- type must be known at this point */
```

## Scalar Types

A scalar type represents a single value. Rust has four primary scalar types: integers, floating-point numbers, Booleans, and characters.

todo: finish the scalar types


# Integer Types
An integer is a number without a fractional component. We used one integer type in Chapter 2, the u32 type. This type declaration indicates that the value
it’s associated with should be an unsigned integer (signed integer types start with i instead of u) that takes up 32 bits of space. Table 3-1 shows the built-in integer types in Rust. We can use any of
these variants to declare the type of an integer value.

| Length | Signed | Unsigned |
|--------|--------|----------|
| 8-bit  | i8     | u8       |
| 16-bit | i16    | u16      |
| 32-bit | i32    | u32      |
| 64-bit | i64    | u64      |
| 128-bit| i128   | u128     |
| arch   | isize  | usize    |


Each variant can be either signed or unsigned and has an explicit size. Signed and unsigned refer to whether it’s possible
for the number to be negative—in other words, whether the number needs to have a sign with it (signed) or whether it will
only ever be positive and can therefore be represented without a sign (unsigned). It’s like writing numbers on paper:
when the sign matters, a number is shown with a plus sign or a minus sign; however, when it’s safe to assume the number is positive, it’s shown with no sign.

Signed integers can represent both positive and negative numbers, while unsigned integers can only represent non-negative numbers (zero and positive numbers).

In Rust, signed integer types start with i (e.g., i32), and unsigned integer types start with u (e.g., u32).

For example:

i32 can represent values from -2,147,483,648 to 2,147,483,647.
u32 can represent values from 0 to 4,294,967,295.


Each signed variant can store numbers from -(2n - 1) to 2n - 1 - 1 inclusive, where n is the number of bits that variant uses. So an i8 can store numbers from -(27) to 27 - 1, which equals -128 to 127. Unsigned variants can store numbers from 0 to 2n - 1, so a u8 can store numbers from 0 to 28 - 1, which equals 0 to 255.

Additionally, the isize and usize types depend on the architecture of the computer your program is running on, which is denoted in the table as “arch”: 64 bits if you’re on a 64-bit architecture and 32 bits if you’re on a 32-bit architecture.

You can write integer literals in any of the forms shown in Table 3-2. Note that number literals that can be multiple numeric types allow a type suffix, such as 57u8, to designate the type. Number literals can also use _ as a visual separator to make the number easier to read, such as 1_000, which will have the same value as if you had specified 1000.

Number literals	Example
Decimal:	98_222
Hex:	0xff
Octal:	0o77
Binary:	0b1111_0000
Byte: (u8 only)	b'A'


So how do you know which type of integer to use? If you’re unsure, Rust’s defaults are generally good places to start: integer types default to i32. The primary situation in which you’d use isize or usize is when indexing some sort of collection.

### Integer Overflow

Let’s say you have a variable of type u8 that can hold values between 0 and 255. If you try to change the variable to a value outside that range, such as 256, integer overflow will occur, which can result in one of two behaviors. When you’re compiling in debug mode, Rust includes checks for integer overflow that cause your program to panic at runtime if this behavior occurs. Rust uses the term panicking when a program exits with an error; we’ll discuss panics in more depth in the “Unrecoverable Errors with panic!” section in Chapter 9.

When you’re compiling in release mode with the --release flag, Rust does not include checks for integer overflow that cause panics. Instead, if overflow occurs, Rust performs two’s complement wrapping. In short, values greater than the maximum value the type can hold “wrap around” to the minimum of the values the type can hold. In the case of a u8, the value 256 becomes 0, the value 257 becomes 1, and so on. The program won’t panic, but the variable will have a value that probably isn’t what you were expecting it to have. Relying on integer overflow’s wrapping behavior is considered an error.

To explicitly handle the possibility of overflow, you can use these families of methods provided by the standard library for primitive numeric types:

Wrap in all modes with the wrapping_* methods, such as wrapping_add.
Return the None value if there is overflow with the checked_* methods.
Return the value and a boolean indicating whether there was overflow with the overflowing_* methods.
Saturate at the value’s minimum or maximum values with the saturating_* methods.

# Floating-Point Types

Rust also has two primitive types for floating-point numbers, which are numbers with decimal points. Rust’s floating-point types are f32 and f64, which are 32 bits and 64 bits in size, respectively. The default type is f64 because on modern CPUs it’s roughly the same speed as f32 but is capable of more precision.

All floating-point types are signed.


```rust
fn main() {
    let x = 2.0; // f64

    let y: f32 = 3.0; // f32
}
```


Floating-point numbers are represented according to the IEEE-754 standard. The f32 type is a single-precision float, and f64 has double precision.


# Numeric Operations

Rust supports the basic mathematical operations you’d expect for all the number types: addition, subtraction, multiplication, division, and remainder. Integer division truncates toward zero to the nearest integer. The following code shows how you’d use each numeric operation in a let statement:

```rust
fn main() {
    // addition
    let sum = 5 + 10;

    // subtraction
    let difference = 95.5 - 4.3;

    // multiplication
    let product = 4 * 30;

    // division
    let quotient = 56.7 / 32.2;
    let truncated = -5 / 3; // Results in -1

    // remainder
    let remainder = 43 % 5;
}

```
Each expression in these statements uses a mathematical operator and evaluates to a single value, which is then bound to a variable. Appendix B contains a list of all operators that Rust provides.

# The Boolean Type
As in most other programming languages, a Boolean type in Rust has two possible values: true and false. Booleans are one byte in size. The Boolean type in Rust is specified using bool. For example:

```rust
fn main() {
    let t = true;

    let f: bool = false; // with explicit type annotation
}
```

The main way to use Boolean values is through conditionals, such as an if expression. We’ll cover how if expressions work in Rust in the “Control Flow” section.

# The Character Type
Rust’s char type is the language’s most primitive alphabetic type. Here are some examples of declaring char values:

```rust

fn main() {
    let c = 'z';
    let z = 'ℤ';
    let heart_eyed_cat = '😻';
}
```

Note that we specify char literals with single quotes, as opposed to string literals, which use double quotes. Rust’s char type is four bytes in size and represents a Unicode Scalar Value, which means it can represent a lot more than just ASCII. Accented letters; Chinese, Japanese, and Korean characters; emoji; and zero-width spaces are all valid char values in Rust. Unicode Scalar Values range from U+0000 to U+D7FF and U+E000 to U+10FFFF inclusive. However, a “character” isn’t really a concept in Unicode, so your human intuition for what a “character” is may not match up with what a char is in Rust. We’ll discuss this topic in detail in “Storing UTF-8 Encoded Text with Strings” in Chapter 8.


# Compound Types

Compound types can group multiple values into one type. Rust has two primitive compound types: tuples and arrays.

## The Tuple Type

A tuple is a general way of grouping together a number of values with a variety of types into one compound type. Tuples have a fixed length: once declared, they cannot grow or shrink in size.

Example tuple

```rust
fn main() {
    let tup = (500, 6.4, 1);

    let (x, y, z) = tup;

    println!("The value of y is: {y}");
}
```

Access Tuple by position

```rust
fn main() {
    let x: (i32, f64, u8) = (500, 6.4, 1);

    let five_hundred = x.0;

    let six_point_four = x.1;

    let one = x.2;
}
```


## The Array Type

Unlike a tuple, every element of an array must have the same type. Unlike arrays in some other languages, arrays in Rust have a fixed length.

Example

```rust
fn main() {
    let a = [1, 2, 3, 4, 5];
}
```


Arrays are useful when you want your data allocated on the stack rather than the heap (we will discuss the stack and the heap more in Chapter 4) or when you want to ensure you always have a fixed number of elements. An array isn’t as flexible as the vector type, though. A vector is a similar collection type provided by the standard library that is allowed to grow or shrink in size. If you’re unsure whether to use an array or a vector, chances are you should use a vector. Chapter 8 discusses vectors in more detail.

However, arrays are more useful when you know the number of elements will not need to change. For example, if you were using the names of the month in a program, you would probably use an array rather than a vector because you know it will always contain 12 elements.

You write an array’s type using square brackets with the type of each element, a semicolon, and then the number of elements in the array, like so:

```rust
fn main() {
    let a: [i32; 5] = [1, 2, 3, 4, 5];
}
```

You can also initialize an array to contain the same value for each element by specifying the initial value, followed by a semicolon, and then the length of the array in square brackets, as shown here:

```rust
fn main() {
    let a = [3; 5]; // [3, 3, 3, 3, 3]
}
```

An array is a single chunk of memory of a known, fixed size that can be allocated on the stack. You can access elements of an array using indexing, like this:

```rust
fn main() {
    let a = [1, 2, 3, 4, 5];

    let first = a[0];
    let second = a[1];
}
```

If you try to access to a non-existent element, Rust will panic at runtime. This is why it’s important to ensure your index is within the array’s bounds.

This is an example of Rust's memory safety principles in action. In many low-level languages, this kind of check is not done, and when you provide an incorrect index, invalid memory can be accessed. Rust protects you against this kind of error by immediately exiting instead of allowing the memory access and continuing. Chapter 9 discusses more of Rust’s error handling and how you can write readable, safe code that neither panics nor allows invalid memory access.

Reference: https://doc.rust-lang.org/book/ch03-02-data-types.html#the-array-type

# Functions:

Functions
https://doc.rust-lang.org/book/ch03-03-how-functions-work.html