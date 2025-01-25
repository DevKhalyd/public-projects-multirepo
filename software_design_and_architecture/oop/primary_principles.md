# Inheritance

Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a new class to inherit the properties and methods of an existing class. The class that is inherited from is called the parent or super class, while the class that inherits is called the child or sub class. Inheritance enables code reuse and allows for a hierarchical organization of classes, where a child class can inherit the properties and methods of its parent class and potentially add or override them. The main advantage of inheritance is that it allows for a clean and organized way to reuse code and share functionality among classes.

# Polymorphism

Polymorphism is a concept in object-oriented programming (OOP) that allows objects of different classes to be treated as objects of a common parent class. This is achieved by defining a common interface for all classes that need to be treated polymorphically. The word polymorphism is derived from Greek, “poly” means many and “morph” means form.

There are two types of polymorphism:

Compile-time polymorphism (also called static polymorphism or early binding) occurs when the type of the object that is going to be acted upon is determined at compile-time. This is achieved through method overloading, which allows multiple methods to have the same name but different parameters within the same class.
Run-time polymorphism (also called dynamic polymorphism or late binding) occurs when the type of the object is determined at run-time. This is achieved through method overriding, which allows a child class to provide a specific implementation of a method that is already defined in its parent class.

# Abstraction

Abstraction is a concept in object-oriented programming (OOP) that refers to the process of hiding the implementation details of an object and exposing only its essential features. It enables the use of objects without the need to understand the underlying complexity of their internal structure and behavior.

There are two types of abstraction:

Data abstraction: refers to hiding the internal representation of data and providing a simplified view of the data through a set of well-defined interfaces.
Behavioral abstraction: refers to hiding the internal behavior of an object and providing a simplified view of its capabilities through a set of well-defined interfaces.

# Encapsulation

Encapsulation is a concept in object-oriented programming (OOP) that refers to the practice of wrapping an object’s internal data and behavior within a defined interface, and hiding the implementation details from the outside world. It is one of the fundamental concepts of OOP and is closely related to the concepts of data hiding and information hiding.

Encapsulation is achieved by using access modifiers (such as “public,” “private,” and “protected”) to control the visibility and accessibility of an object’s data and methods. For example, data members of a class can be declared as private, which means they can only be accessed by methods within the class, while methods can be declared as public, which means they can be called by any code that has a reference to the object.