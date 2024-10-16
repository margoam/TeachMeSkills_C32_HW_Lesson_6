# TeachMeSkills_C32_HW_Lesson_6
The following tasks are completed:
1. Create a class to describe a student from our group.
Class fields: name, surname, passport number, group name (you can add your own fields, like age).
Create objects of this class for each student in our group.
Put all these objects in an array.
Iterate through the array using a for loop and display the information on the console.
2. Create a class CreditCard with fields for account number and current balance.
Create a constructor with two parameters.
Create a TransferService class – a service for transfers.
Add a method that allows depositing an amount to the credit card.
The method takes the amount and the card as parameters. Inside the method, add the passed amount to the current balance of the passed card.
Add a method that allows withdrawing a certain amount from the card.
The method takes the amount and the card as parameters. Inside the method, subtract the passed amount from the current balance of the card.
Add a method to display the current card information on the console.
Think through and implement various checks in the withdrawal/deposit methods: for example, negative numbers, a zero amount, trying to withdraw more than is available on the card, and other possible checks.
Write a program that creates three CreditCard objects, each with an account number and an initial balance.
Test scenario:
Deposit money into the first two cards and withdraw from the third.
Display the current state of all three cards on the screen.
