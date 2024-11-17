# Overview

Functions are prevalent in Rust code. You’ve already seen one of the most important functions in the language: the main function, which is the entry point of many programs. You’ve also seen the fn keyword, which allows you to declare new functions.

Rust code uses snake case as the conventional style for function and variable names, in which all letters are lowercase and underscores separate words. Here’s a program that contains an example function definition:

```rust
fn main() {
    println!("Hello, world!");
    another_function();
}

fn another_function() {
    println!("Another function.");
}

// with parameters
fn main() {
    another_function(5);
}

fn another_function(x: i32) {
    println!("The value of x is: {x}");
}
```
Continue: https://doc.rust-lang.org/book/ch03-03-how-functions-work.html#statements-and-expressions

Reference: https://doc.rust-lang.org/book/ch03-03-how-functions-work.html

