Online Shopping System


Project Overview

The Online Shopping System is a Java-based console application that simulates a simple e-commerce platform. It demonstrates core Object-Oriented Programming (OOP) concepts such as encapsulation, inheritance, polymorphism, abstraction, and aggregation.
The system allows a customer to select products, add them to a cart, apply discounts, and make payments using different methods like Credit Card or UPI. It is designed to give practical experience in building modular, maintainable, and reusable Java applications.



Features

Add multiple products to a shopping cart.
Apply different discount strategies: No Discount, Seasonal Discount, and Festival Discount.
Support multiple payment methods: Credit Card and UPI.
Integrate customer, cart, payment, and discount to place an order.
Demonstrates OOP principles: encapsulation, aggregation, inheritance, polymorphism, and abstraction.



Code Structure

The project is organized into multiple classes, each handling a specific responsibility:
Product: Represents items available for purchase. Stores name, price, and quantity; calculates total price.
Customer: Stores customer details such as name and email.
Cart: Holds multiple products and calculates the total price of all items.
DiscountStrategy (abstract): Defines the structure for discount calculation.
NoDiscount, SeasonalDiscount, FestivalDiscount: Implement different discount rules.
Payment (abstract): Defines the structure for payment methods.
CreditCardPayment, UPIPayment: Implement specific payment processing.
Order: Combines customer, cart, payment, and discount to place an order and display details.

Main class:
OnlineShoppingSystem: Demonstrates the complete workflow by creating products, a customer, a cart, applying discounts, and processing payments.




How to Run the Project

Prerequisites:
Java JDK installed (version 8 or above).
A Java IDE (e.g., VS Code, Eclipse, IntelliJ) or terminal to compile and run Java code.

Steps:
Open the project folder in your IDE or terminal.
   Compile all Java files:
   javac *.java
Run the main class:
  java OnlineShoppingSystem

Expected Output:
The program displays:
Customer details
Total amount of products in the cart
Discounted amount
Payment confirmation for each order



Learning Outcomes

Apply encapsulation in classes like Product and Customer.
Use aggregation to manage multiple products in a cart.
Implement inheritance and polymorphism for payment and discount strategies.
Design modular, reusable, and maintainable Java code.
Gain practical experience in integrating multiple classes to simulate a real-world system.




Future Enhancements

Add a Graphical User Interface (GUI) for better user interaction.
Integrate a database for storing products, customers, and orders.
Implement user authentication and profiles for secure access.
Include inventory management, product categories, and order tracking.
Add more payment methods and dynamic discount rules.



Conclusion

This project demonstrates how Object-Oriented Programming concepts can be applied to create a simple, functional online shopping system. It provides practical experience in Java programming while building a modular and maintainable application that can be extended in the future.
