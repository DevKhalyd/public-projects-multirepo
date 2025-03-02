# Combine

Combine is Apple’s built-in framework for reactive programming, using the same publisher-subscriber pattern as most modern approaches to this issue. Combine introduces the concept of a Cancellable (i.e. a subscription) and many different operators to use on these Cancellables. When writing Combine code, developers will notice complex generic types. For this reason, type-erasure can be done through AnyCancellable.

Ref: https://developer.apple.com/documentation/combine

