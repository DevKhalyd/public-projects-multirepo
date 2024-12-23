# Overview

Node.js is an open-source and cross-platform JavaScript runtime environment. It is a popular tool for almost any kind of project! Node.js runs the V8 JavaScript engine, Google Chrome’s core, outside the browser. This allows Node.js to be very performant. A Node.js app runs in a single process, without creating a new thread for every request.

Node.js provides a set of asynchronous I/O primitives in its standard library that prevent JavaScript code from blocking and generally, libraries in Node.js are written using non-blocking paradigms, making blocking behavior the exception rather than the norm.

Node.js is a cross-platform runtime, perfect for a wide range of use cases. Its huge community makes it easy to get started. It uses the V8 engine to compile JavaScript and runs at lightning-fast speeds. Node.js applications are very scalable and maintainable. Cross-platform support allows the creation of all kinds of applications - desktop apps, software as a service, and even mobile applications. Node.js is perfect for data-intensive and real-time applications since it uses an event-driven, non-blocking I/O model, making it lightweight and efficient. With such a huge community, a vast collection of Node.js packages is available to simplify and boost development.

# CommonJS vs ESM

CommonJS and ES (EcmaScript) are module systems used in Node. CommonJS is the default module system. However, a new module system was recently added to NodeJS - ES modules. CommonJS modules use the require() statement for module imports and module.exports for module exports while it’s import and export for ES.

# ESM

ESM (ECMAScript Modules) is a standardized module system in JavaScript that allows for the organized, maintainable, and reusable structuring of code. It uses import and export statements for including and sharing functions, objects, or primitives between files. ESM supports static analysis, enabling better optimization and tooling, and is always in strict mode to reduce common JavaScript issues. Node.js fully supports ESM, which can be used with .mjs file extensions or configured in the package.json for .js files, making it easier to write modular and efficient JavaScript applications.

# Node.js Modules

We split our code into different files to maintain, organize and reuse code whenever possible. A module system allows us to split and include code and import code written by other developers whenever required. In simple terms, a module is nothing but a JavaScript file. Node.js has many built-in modules that are part of the platform and comes with Node.js installation, for example, HTTP, fs, path, and more.

# Global Keyword

In browsers, the top-level scope is the global scope, and its global object is called the window object. Within the browser, var something will define a new global variable inside the window object. In Node.js, this is different. The top-level scope is not the global scope; var something inside a Node.js module will be local to that module.