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

# npx

npx is a very powerful command that’s been available in npm starting version 5.2, released in July 2017. If you don’t want to install npm, you can install npx as a standalone package. npx lets you run code built with Node.js and published through the npm registry, without needing to install the package itself. This is particularly useful for trying out new tools, running one-time commands, or using packages in shared environments where global installations are undesirable. npx takes care of downloading the package on-the-fly, running the desired command, and then cleaning up the temporary installation. This keeps your project’s dependencies lean and avoids version conflicts.

# npm

npm is the standard package manager for Node.js.

It is two things: first and foremost, it is an online repository for the publishing of open-source Node.js projects; second, it is a command-line utility for interacting with said repository that aids in package installation, version management, and dependency management. A plethora of Node.js libraries and applications are published on npm, and many more are added every day

# Global Install vs Local Install

NodeJS and NPM allow two methods of installing dependencies/packages: Local and Global. This is mainly used when adding a package or dependency as part of a specific project you’re working on. The package would be installed (with its dependencies) in node_modules folder under your project. In addition, in package.json file there will be a new line added for the installed dependency under the label dependencies. At this point - you can start using the package in your NodeJS code by importing the package. Unlike the local install, you can install packages and dependencies globally. This would install it in a system path, and these packages would be available to any program which runs on this specific computer. This method is often used for installing command line tools (for example, even npm program is a Globally installed npm package).

# Local Install

Locally installed packages are available only to the project where the packages are installed, while the globally installed packages can be used any where without installing them into a project. Another use case of the global packages is when using CLI tools.

# Semantic Versioning

Semantic Versioning is a standard for versioning software that’s widely adopted in the npm ecosystem. It provides a clear and consistent way to communicate changes in a software package to users.

Version Format
A semantic version number consists of three parts separated by dots:

MAJOR: Incremented when there are incompatible API changes.
MINOR: Incremented when new functionality is added in a backwards-compatible manner.
PATCH: Incremented when bug fixes are made without affecting the API.

## Example: 1.2.3

1 is the major version.
2 is the minor version.
3 is the patch version.

# Reference

https://roadmap.sh/nodejs