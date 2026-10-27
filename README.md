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

##Day 15 - Payment System Using Interfaces

###Features

- Supports Card, Wallet, and UPI payment methods.

- Accepts a payment amount through the pay() method.

- Displays the payment method and amount.

###Concepts Practiced

- Java Interfaces

- implements keyword

- Method Overriding

- Classes and Objects

- Method Parameters

##Day 16 – Library Management System

###Project Overview

The Library Management System is a beginner-friendly Java console application that helps manage books and display member details. It uses Java Collections to store and manage book and member objects.

###Features

- Display all books

- Search for a book by ID

- Add a new book

- Issue a book

- Return a book

- Calculate overdue days using a simplified 14-day rule

- Display member details

- Menu-driven interface

###Concepts Practiced

- Classes and objects

- Constructors and this keyword

- ArrayList and Collections

- for-each loop

- if-else statements

- switch statement

- do-while loop

- Methods for list operations such as add() and size()

- Book search by ID

- Basic issue and return functionality

###Current Limitations

- Data is stored in memory and resets when the program restarts.

- Overdue calculation uses manually entered days and a simplified 14-day rule.

- Book issue records are not linked to specific members.

- Book and member data are not stored in a database.

##Day 17: Inventory Management System in Java

###Project Overview

Developed a console-based Inventory Management System using Java to manage product details and perform basic inventory operations.

###Features

- Add Product: Add a new product with its ID, name, and price.

- Search Product: Find a product using its ID.

- Update Product: Modify an existing product's name and price.

- Delete Product: Remove a product from the inventory.

- Display All Products: View all available products.

- Menu-Driven Interface: Select operations through a numbered menu.

- Input Validation: Handle invalid menu input.

###Concepts Practiced

- Object-Oriented Programming (OOP)

- Classes, objects, and constructors

- ArrayList for storing products

- Scanner for user input

- For-each and traditional for loops

- if-else and switch statements

- do-while loop

- Boolean variables and break

##Day 18: Employee Lookup System (Java)

###Description:
Developed a console-based Employee Lookup System using Java's HashMap to manage employee records through employee IDs and names.

###Features:

- Add new employee records

- Search employees by ID

- Update employee names

- Delete employee records

- Display all employee records

- Menu-driven interface with an exit option

- Prevent duplicate employee IDs

###Concepts Learned:

- Java HashMap

- Key-value pairs

- put(), get(), containsKey(), and remove()

- Scanner for user input

- do-while loop and switch statement

- Conditional statements and input handling

##Day 19: Unique Email Registry (Java)

###Description:
Developed a console-based Email Registry using Java's HashSet to store unique email addresses.

###Features:

- Register email addresses

- Prevent duplicate entries

- Remove registered emails

- Display all registered emails

- Menu-driven interface with an exit option

###Concepts Learned:

- Java HashSet

- Unique elements and duplicate handling

- add(), remove(), and isEmpty()

- Scanner for user input

- do-while loop and switch statement

- Enhanced for loop

##Day 20: Customer Support Queue

**Project:** Customer Support Queue Management System

###Description:
A Java-based program that manages customer support tickets using a Queue and tracks their status using a HashMap.

###Key Concepts Learned:

**Queue:** Stores customer support tickets.

**FIFO:** First In, First Out — the first ticket added is processed first.

**ArrayDeque:** Implements the Queue interface.

**HashMap:** Stores ticket statuses as key-value pairs.

**offer():** Adds a ticket to the queue.

**poll():** Removes and retrieves the first ticket.

**isEmpty():** Checks whether the queue is empty.

**while loop:** Processes tickets until the queue becomes empty.

###Features:

- Add multiple customer support tickets.

- Display the current queue.

- Process tickets in FIFO order.

- Update ticket status from Pending to Completed.

- Display the remaining queue after processing.

## Day 21: Stack-Based Undo System

**Project:** Stack-Based Undo System

**Description:**

A Java-based text editor simulation that uses a stack to store previous text states and restore them through Undo operations.

**Key Concepts Learned:**
- **Deque and ArrayDeque:** Used to implement a stack.
- **LIFO:** Last In, First Out.
- **push():** Saves the previous text state.
- **pop():** Retrieves and removes the most recently saved state.
- **isEmpty():** Checks whether the stack is empty.
- **while loop and switch:** Manage repeated menu operations.

**Features:**
- Edit text multiple times.
- Undo previous text changes.
- Support multiple Undo operations.
- Display a message when no more Undo operations are available.
- Exit through a menu option.

# Day 22: Banking & Account Management System

## Description
A simple banking application that allows users to deposit money, withdraw money, and check their account balance. It demonstrates custom exception handling and input validation.

## Features
- Deposit money with amount validation
- Withdraw money with balance validation
- Check current account balance
- Handle insufficient balance using a custom exception
- Validate invalid menu inputs
- Display error messages for invalid amounts
- Menu-driven banking interface

## Concepts Practiced
- Custom Exception Handling
- `try-catch` block
- `throw` and `throws` keywords
- Creating custom exception classes
- Methods and method parameters
- `switch` statement
- `while` loop
- Input validation using `Scanner`
- `break` and `return` statements
- Static variables and methods

# Day 23: File-Based Student Record System

## Description
A Java-based application that stores student records in a text file. It allows users to add, read, search, and update student information using file handling.

## Features
- Add new student records
- Prevent duplicate student IDs
- Display all student records
- Search students by ID
- Update student names and marks
- Validate student input and marks
- Store records permanently in a text file
- Handle file-related errors

## Concepts Practiced
- File Handling (File I/O)
- FileReader and FileWriter
- BufferedReader and BufferedWriter
- Try-with-resources
- Exception Handling
- IOException and NumberFormatException
- Methods and switch statements
- Loops and input validation
- Reading, writing, searching, and updating records

# Day 24: CSV Employee Data Processor

## Description
A Java application that reads employee records from a CSV file, validates the data, calculates salary statistics, and saves valid records to an output CSV file.

## Features
- Read employee data from a CSV file
- Validate employee records
- Detect missing fields and invalid salaries
- Identify duplicate employee IDs
- Skip invalid records without stopping the program
- Calculate total and average salary
- Generate a processed CSV file
- Handle file-related errors

## Concepts Practiced
- CSV File Processing
- File I/O
- FileReader and FileWriter
- BufferedReader and BufferedWriter
- Try-with-resources
- Exception Handling
- NumberFormatException
- HashSet and duplicate detection
- Loops and conditional statements
- Data validation and statistics calculation

# Day 25: Log File Analyzer

## Description
A Java application that reads log files, identifies log levels, counts messages, and generates an analysis report.

## Features
- Read log files line by line
- Count INFO, WARNING, and ERROR messages
- Identify invalid log entries
- Display error details
- Generate a text report
- Handle file-related errors

## Concepts Practiced
- Java File Handling
- BufferedReader and BufferedWriter
- String methods
- HashMap and ArrayList
- Loops and conditional statements
- Exception Handling
- Report Generation

# Day 27: Thread-Safe Counter

## Objective
To understand race conditions in multithreading and implement thread-safe counters using `synchronized` and `AtomicInteger`.

## Concepts Used
- Multithreading
- Race Condition
- Thread Synchronization
- `synchronized` Keyword
- `AtomicInteger`
- Thread `start()` and `join()` Methods

## Features
- Demonstrates a race condition using an unsafe counter.
- Implements a thread-safe counter using `synchronized`.
- Implements a thread-safe counter using `AtomicInteger`.
- Runs two threads, each performing 100,000 increments.
- Compares the final count of all three approaches.

## Sample Output

Expected Count: 200000

Synchronized Count: 200000

AtomicInteger Count: 200000

Unsafe Counter: 159059

**Note:** The unsafe counter's actual value may vary on each run because of race conditions. It may occasionally reach 200000 as well.

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
├── application.log
├── log_report.txt
├── employees.csv
├── processed_employees.csv
│
└── src/
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
    │
    ├── day14/
    │   └── shapecalculator/
    │       ├── Shape.java
    │       ├── Circle.java
    │       ├── Rectangle.java
    │       ├── Triangle.java
    │       └── Main.java
    │
    ├── day15/
    │   └── paymentsystem/
    │       ├── Payment.java
    │       ├── CardPayment.java
    │       ├── WalletPayment.java
    │       ├── UpiPayment.java
    │       └── Main.java
    │
    ├── day16/
    │   └── librarymanagement/
    │       ├── Book.java
    │       ├── Member.java
    │       └── Main.java
    │
    ├── day17/
    │   └── inventory/
    │       ├── Product.java
    │       └── InventoryManagementSystem.java
    │
    ├── day18/
    │   └── employeelookup/
    │       └── EmployeeLookupSystem.java
    │
    ├── day19/
    │   └── emailregistry/
    │       └── EmailRegistry.java
    │
    ├── day20/
    │   └── customersupport/
    │       └── CustomerSupportQueue.java
    │
    ├── day21/
    │   └── undostack/
    │       └── StackBasedUndoSystem.java
    │
    ├── day22/
    │   └── customexception/
    │       ├── BankingSystem.java
    │       └── InsufficientBalanceException.java
    │
    ├── day23/
    │   └── filerecord/
    │       └── StudentRecordSystem.java
    │
    ├── day24/
    │   └── csvprocessor/
    │       └── CSVEmployeeDataProcessor.java
    │
    ├── day25/
    │    └── loganalyzer/
    │        └── LogFileAnalyzer.java
    └── day27/
    	 └── threadsafecounter/
        	  └── ThreadSafeCounter.java
            ```

    

## Outcome

Developed practical Java programs and strengthened understanding of Java fundamentals, problem-solving, input validation, arrays, loops, methods, and conditional statements.