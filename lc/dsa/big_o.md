# Overview

What is an algorithm? An algorithm is a set of instructions that are followed to solve a problem. It is a step-by-step procedure that defines a set of instructions to be executed in a certain order to get the desired output.

Algorithms take an input and produce an output. The output will be the answer to a question regarding the input. For example, let's say you had a non-empty array of positive integers called nums, and you wanted to answer the question: "What is the largest number in nums?".

Algorithms take an input and produce an output. The output will be the answer to a question regarding the input. For example, let's say you had a non-empty array of positive integers called nums, and you wanted to answer the question: "What is the largest number in nums?".

To answer this question, you would write an algorithm that takes an array called nums as input, and outputs the largest number in nums. Here is an example of such an algorithm:

1. Create a variable maxNum and initialize it to 0.

2. Iterate over each element num in nums.

3. If num is greater than maxNum, update maxNum = num.

4. Output maxNum.

Here, we have written down a set of instructions that when followed, will solve the problem. We can now implement these instructions in code so that a computer can quickly solve the problem. There are some important requirements for algorithms in the context of LC:

- Algorithms should be deterministic. Given the same input, the algorithm should always produce the same output. Basically, there shouldn't be any randomness.

- The algorithm should be correct for any arbitrary valid input. In our example, we said that nums is a non-empty array of positive integers. There are infinitely many of such arrays, and our algorithm works for all of them. Note that if nums had negative numbers, the input would be invalid since we stated the integers are positive. In fact, our algorithm would actually break because we initialized maxNum to 0, so if all of nums was negative, we would incorrectly output 0.

# Big O

Big O is a notation used to describe the computational complexity of an algorithm. The computational complexity of an algorithm is split into two parts: time complexity and space complexity. The time complexity of an algorithm is the amount of time the algorithm needs to run relative to the input size. The space complexity of an algorithm is the amount of memory allocated by the algorithm when run relative to the input size.

```bash
Typically, people care about the time complexity more than the space complexity, but both are important to know.
```

Time complexity: as the input size grows, how much longer does the algorithm take to complete?

Space complexity: as the input size grows, how much more memory does the algorithm use?

# How complexity works?

Complexity is described by a function (math formula). What should the arguments to this function be?

The arguments are variables defined by the programmer, but they should represent values that change between different inputs, and these values should affect the algorithm. For example, the most common variable you'll see is **n**, which usually denotes the length of an input array or string. In the example above, we could say that **n** is equal to the length of nums.

Here, "the length of nums" is a value that changes between inputs, and it directly affects the algorithm. The longer **nums** is, the more elements we need to iterate through, and thus the longer our algorithm will take to complete.

In the context of LC, there are some common assumptions that we make. When dealing with integers, the larger the integer, the more time operations like addition, multiplication, or printing will take. While this is relevant in theory, we typically ignore this fact because the difference is practically very small, and treat all integers the same. If you are given an array of integers as an input, the only variable you would use is **n** to denote the length of the array. Technically, you could introduce another variable, let's say **k** which denotes the average value of the integers in the array. However, nobody does this.

When written, the function is wrapped by a capital O. Here are some example complexities:

- O(n): Linear time complexity. The time it takes to run the algorithm grows linearly with the input size. If the input size doubles, the time it takes to run the algorithm also doubles.

- O(n^2): Quadratic time complexity. The time it takes to run the algorithm grows quadratically with the input size. If the input size doubles, the time it takes to run the algorithm quadruples.

- O (2^n): Exponential time complexity. The time it takes to run the algorithm grows exponentially with the input size. If the input size doubles, the time it takes to run the algorithm squares.

- O(log n): Logarithmic time complexity. The time it takes to run the algorithm grows logarithmically with the input size. If the input size doubles, the time it takes to run the algorithm only increases by a constant amount.

- O(n * m): The time complexity of the algorithm is the product of the lengths of two input arrays. If the first array doubles in size, the time it takes to run the algorithm also doubles. The same applies to the second array.


These functions represent the complexity. For example, you would say "The time complexity of my algorithm is O(n)" or "The space complexity of my algorithm is O(n^2)". The function is a mathematical representation of how the algorithm scales with input size.

# Calculating complexity

