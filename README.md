# Veda Technology Java Internship

A collection of Java programming tasks and projects completed as part of the Veda Technology 45-Day Java Internship.

## Day 1 - Command-Line Calculator

### Features

- Addition
- Subtraction
- Multiplication
- Division
- Modulus
- Invalid number validation
- Division by zero validation
- Separate methods for operations

### Concepts Practiced

- Scanner
- Methods
- Switch statement
- Input validation

## Day 2 - Student Grade Calculator

### Features

- Accepts marks for multiple subjects
- Uses arrays to store marks
- Calculates total marks
- Calculates percentage
- Assigns grade based on percentage
- Validates marks between 0 and 100

### Concepts Practiced

- Arrays
- Loops
- Methods
- Conditional statements
- Input validation

## Day 3 - Number Guessing Game

### Features

- Generates a random number between 1 and 100
- Accepts user guesses
- Gives "Too high" or "Too low" hints
- Validates guesses between 1 and 100
- Counts the number of valid attempts
- Displays the result when the correct number is guessed

### Concepts Practiced

- Random class
- Scanner
- While loop
- If-else statements
- Input validation

## Day 4 - Student Management System

### Features

- Add new students
- Search student by ID
- Update student information
- Display all students
- Handles invalid student IDs
- Limits the system to 5 students
- Handles student limit validation

### Concepts Practiced

- Arrays
- Methods
- Loops
- Switch statement
- Conditional statements
- Linear search
- Input validation

## Day 5 - Multiplication Table Generator

### Features

- Generates a multiplication table for a single number
- Generates multiplication tables for a range of numbers
- Provides formatted table output
- Uses separate methods for table generation
- Uses nested loops for range-based table generation

### Concepts Practiced

- Scanner
- Methods
- For loops
- Nested loops
- If-else statements
- Input handling

## Day 6 - Palindrome Checker
### Features
- Checks whether a string is a palindrome
- Checks whether a number is a palindrome
- Performs case-insensitive string checking
- Reverses strings using StringBuilder
- Reverses numbers using mathematical logic
- Displays whether the input is a palindrome or not

### Concepts Practiced
- String handling
- StringBuilder
- Scanner
- While loop
- If-else statements
- Number reversal
- String comparison using equals()

## Day 7 - Prime Number Analysis
### Features
- Checks whether a number is prime
- Generates prime numbers within a specified range
- Performs range-based prime number analysis
- Handles numbers less than 2
- Uses an optimized prime-checking approach

### Concepts Practiced
- Methods
- For loops
- If-else statements
- Modulus operator
- Mathematical logic
- Boolean return values
- Algorithm optimization

## Day 8 - Simple ATM Simulation

### Features

* PIN authentication with a maximum of 3 attempts
* Checks the current account balance
* Allows users to deposit money
* Allows users to withdraw money
* Prevents withdrawals exceeding the available balance
* Validates invalid deposit and withdrawal amounts
* Handles invalid menu choices
* Provides a menu-driven console interface

### Concepts Practiced

* Methods
* Static variables
* Final variables
* While loops
* Switch statements
* If-else statements
* User input using Scanner
* Input validation
* State management
* Conditional logic

## Day 9: Simple Banking Account Class

###Concepts Covered:

* Classes and Objects
* Constructors
* Encapsulation using private fields
* Getters and Methods
* Deposit and Withdrawal Operations
* Input Validation and Insufficient Balance Handling

###Features:

* Stores account number, account holder name, and balance.
* Initializes account details using a constructor.
* Deposits valid amounts into the account.
* Withdraws money when the balance is sufficient.
* Rejects invalid deposit amounts and withdrawals exceeding the available balance.
* Displays account details and the current balance.

## Day 10: Constructor Overloading

###Features:
- Create student objects using different constructors.
- Initialize student details using name, age, and course.
- Display student information.

###Concepts Practiced:
- Constructors in Java
- Constructor overloading
- Object creation and initialization
- `this` keyword
- Default values of instance variables## Project Structure


## Day 11: Employee Management System

### Features
- Add new employees
- Display all employees
- Search employees by ID
- Update employee salary
- Validate salary to prevent invalid values
- Prevent duplicate employee IDs
- Handles employee limit validation

### Concepts Practiced
- Classes and Objects
- Constructors
- Encapsulation using private fields
- Getters and Setters
- Arrays
- Loops
- Switch statement
- Linear search
- Input validation
- Object-Oriented Programming

##Day 12 - Employee Hierarchy Using Inheritance

###Features

- Created a parent Employee class with employee ID, name, and salary.

- Created Developer, Manager, and Intern classes that inherit from Employee.

- Used constructors to initialize employee details.

- Used the super() keyword to call the parent class constructor.

- Displayed employee details using getter methods.

- Implemented separate work() methods for each employee type.

- Demonstrated inheritance using objects of child classes.

###Concepts Practiced

- Inheritance

- Parent and Child Classes

- Constructors

- super() Keyword

- Encapsulation

- Private Data Members

- Getter Methods

- Method Implementation

- Object Creation

- Access Modifiers

##Day 13 - Runtime Polymorphism in Java

###Features

- Created an Employee parent class with a common work() method.

- Created Developer, Manager, and Intern child classes using inheritance.

- Overrode the work() method in each child class.

- Used the @Override annotation to demonstrate method overriding.

- Used parent class references to hold child class objects.

- Demonstrated runtime polymorphism through different method outputs.

###Concepts Practiced

- Inheritance

- Method Overriding

- @Override Annotation

- Runtime Polymorphism

- Parent Class Reference

- Child Class Objects

- Dynamic Method Dispatch

- Object-Oriented Programming (OOP)

##Day 14 - Shape Calculator Using Abstraction

###Features

- Calculates the area and perimeter of a Circle.

- Calculates the area and perimeter of a Rectangle.

- Calculates the area and perimeter of a Triangle.

- Uses an abstract Shape class as a common blueprint for all shapes.

###Concepts Practiced

- Abstract Classes and Abstract Methods

- Inheritance using extends

- Method Overriding using @Override

- Constructors and this keyword

- Returning values using return

- Mathematical calculations using Math.PI


## Technologies Used

- Java
- JDK
- Eclipse IDE
- Git
- GitHub


## Project Structure

```text
## Project Structure

```text
Veda-Technology-Internship/
│
├── README.md
├── .gitignore
│
└── src/
    │
    ├── day01/
    │   └── calculator/
    │       └── Calculator.java
    │
    ├── day02/
    │   └── studentgradecalculator/
    │       └── StudentGradeCalculator.java
    │
    ├── day03/
    │   └── numberguessing/
    │       └── NumberGuessingGame.java
    │
    ├── day04/
    │   └── studentmanagement/
    │       └── StudentManagementSystem.java
    │
    ├── day05/
    │   └── [Day 5 package and Java files]
    │
    ├── day06/
    │   └── [Day 6 package and Java files]
    │
    ├── day07/
    │   └── [Day 7 package and Java files]
    │
    ├── day08/
    │   └── [Day 8 package and Java files]
    │
    ├── day09/
    │   └── [Day 9 package and Java files]
    │
    ├── day10/
    │   └── [Day 10 package and Java files]
    │
    ├── day11/
    │   └── employeemanagement/
    │       ├── Employee.java
    │       └── EmployeeManagementSystem.java
    │
    ├── day12/
    │   └── employeehierarchy/
    │       ├── Employee.java
    │       ├── Developer.java
    │       ├── Manager.java
    │       ├── Intern.java
    │       └── Main.java
    │
    ├── day13/
    │   └── runtimepolymorphism/
    │       ├── Employee.java
    │       ├── Developer.java
    │       ├── Manager.java
    │       ├── Intern.java
    │       └── Main.java
    └── day14/
        └── shapecalculator/
            ├── Shape.java
            ├── Circle.java
            ├── Rectangle.java
            ├── Triangle.java
            └── Main.java
```

    

## Outcome

Developed practical Java programs and strengthened understanding of Java fundamentals, problem-solving, input validation, arrays, loops, methods, and conditional statements.