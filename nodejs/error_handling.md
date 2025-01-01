# Error Handling

Error handling is a way to find bugs and solve them as quickly as humanly possible. The errors in Node.js can be either operation or programmer errors.

## System Errors

Node.js generates system errors when exceptions occur within its runtime environment. These usually occur when an application violates an operating system constraint. For example, a system error will occur if an application attempts to read a file that does not exist.

## User Specified Errors

User specified errors can be created by extending the base Error object, a built-in error class. When creating errors in this manner, you should pass a message string that describes the error. This message can be accessed through the message property on the object. The Error object also contains a name and a stack property that indicate the name of the error and the point in the code at which it is created.

## Assertion Errors

An AssertionError in Node.js is an error that is thrown when the assert module determines that a given expression is not truthy. The assert module is a built-in Node.js module that provides a simple set of assertion tests that can be used to test the behavior of your code.

## JavaScript Errors

JavaScript Errors are used by JavaScript to inform developers about various issue in the script being executed. These issues can be syntax error where the developer/programmer has used the wrong syntax, it can be due to some wrong user input or some other problem.

## Uncaught Exceptions

When a JavaScript error is not properly handled, an uncaughtException is emitted. These suggest the programmer has made an error, and they should be treated with the utmost priority.


The correct use of uncaughtException is to perform synchronous cleanup of allocated resources (e.g. file descriptors, handles, etc) before shutting down the process. It is not safe to resume normal operation after uncaughtException because system becomes corrupted. The best way is to let the application crash, log the error and then restart the process automatically using nodemon or pm2.

## Async errors

Errors must always be handled. If you are using synchronous programming you could use a try catch. But this does not work if you work asynchronous! Async errors will only be handled inside the callback function!

## Stack Trace

The stack trace is used to trace the active stack frames at a particular instance during the execution of a program. The stack trace is useful while debugging code as it shows the exact point that has caused an error.

## Debugger


Node.js includes a command-line debugging utility. The Node.js debugger client is not a full-featured debugger, but simple stepping and inspection are possible. To use it, start Node.js with the inspect argument followed by the path to the script to debug.

Example:

```bash
node inspect myscript.js
```

Reference: https://www.freecodecamp.org/news/how-to-debug-node-js-applications/
