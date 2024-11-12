# Overview

We’ll implement a classic beginner programming problem: a guessing game. Here’s how it works: the program will generate a random integer between 1 and 100. It will then prompt the player to enter a guess. After a guess is entered, the program will indicate whether the guess is too low or too high. If the guess is correct, the game will print a congratulatory message and exit.

# Commands


**cargo build:** Build the project from scratch
**cargo run:** Compile and run the binary
**cargo udpate:** Update all the dependencies




# Reference

https://doc.rust-lang.org/book/ch02-00-guessing-game-tutorial.html

# Terminology

**Crate:** It is a collection of Rust source code files. The project we’ve been building is a binary crate, which is an executable. The rand crate is a library crate, which contains code that is intended to be used in other programs and can’t be executed on its own.