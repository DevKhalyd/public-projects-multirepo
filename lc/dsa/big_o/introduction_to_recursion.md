# Introduction to Recursion

Recursion is a problem solving method. In code, recursion is implemented using a function that calls itself.

The opposite of a recursive algorithm would be an iterative algorithm. There is a branch of study that proves that any iterative algorithm can be written recursively. While iterative algorithms use for loops and while loops to simulate repetition, recursive algorithms use function calls to simulate the same logic.

Let's say that we wanted to print the numbers from 1 to 10. Here's some pseudocode for an iterative algorithm:

```java
for (int i = 1; i <= 10; i++) {
    print(i)
}
```

Here's some pseudocode for an equivalent recursive algorithm:

```java
function fn(i):
    print(i)
    fn(i + 1)
    return

fn(1)
```

Each call to fn first prints i (which starts at 1), and then calls fn again, but incrementing i (to print the next number).

However, this code is actually wrong. Do you see the problem? The function calls will never stop! Running this code would print natural numbers (positive integers) infinitely (or until the computer exploded). The return line never gets reached because fn(i + 1) comes before it.