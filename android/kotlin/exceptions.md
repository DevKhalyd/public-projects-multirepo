# Exceptions

Exceptions help your code run more predictably, even when runtime errors occur that could disrupt program execution. Kotlin treats all exceptions as unchecked by default. Unchecked exceptions simplify the exception handling process: you can catch exceptions, but you don't need to explicitly handle or declare them.

Working with exceptions consists of two primary actions:

**Throwing exceptions:** indicate when a problem occurs.

**Catching exceptions:** handle the unexpected exception manually by resolving the issue or notifying the developer or application user.

# Throw exceptions with precondition functions﻿

Kotlin offers additional ways to automatically throw exceptions using precondition functions. Precondition functions include:

- require() -> Checks user input validity
- check() -> Checks object or variable state validity
- error() -> Indicates an illegal state or condition

Ref: https://kotlinlang.org/docs/exceptions.html
