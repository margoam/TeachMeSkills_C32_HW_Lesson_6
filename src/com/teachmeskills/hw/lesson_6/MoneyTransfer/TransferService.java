package com.teachmeskills.hw.lesson_6.MoneyTransfer;

import java.util.Scanner;

public class TransferService {

    private CreditCard[] cards;
    Scanner scanner = new Scanner(System.in);

    public void createCards(int numberOfCards) {
        cards = new CreditCard[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            System.out.println("Enter information for a card №" + (i + 1) + ":");

            System.out.print("Card Number: ");
            String cardNumber = scanner.nextLine();

            int cardBalance = -1;
            boolean validUserInput = false;
            System.out.print("Card Balance: ");
            while (!validUserInput) {
                if (scanner.hasNextInt()) {
                    cardBalance = scanner.nextInt();
                    if (cardBalance >= 0) {
                        validUserInput = true;
                    } else {
                        System.out.print("Invalid input. Please, enter a valid number for the balance: ");
                    }
                } else {
                    System.out.print("Invalid input. Please, enter a valid number for the balance: ");
                    scanner.next();
                }
            }
            cards[i] = new CreditCard(cardNumber, cardBalance);
            scanner.nextLine();
        }
    }

    public int selectNumberOfCardsToCreate() {
        int numberOfCards = 0;
        boolean validUserInput = false;

        while (!validUserInput) {
            System.out.print("Please, enter a number of cards to be created: ");
            if (scanner.hasNextInt()) {
                numberOfCards = scanner.nextInt();
                if (numberOfCards > 0) {
                    validUserInput = true;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again. ");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numberOfCards;
    }

    public CreditCard selectCardForOperation() {
        int cardNumber = 0;
        boolean validUserInput = false;

        while (!validUserInput) {
            System.out.println("Please, select a card for operation: ");
            if (scanner.hasNextInt()) {
                cardNumber = scanner.nextInt();
                if (cardNumber > 0 && cardNumber <= cards.length) {
                    validUserInput = true;
                } else {
                    System.out.println("No valid card selected. Please, try again.");
                }
            } else {
                System.out.println("No valid card selected. Please, try again.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return cards[cardNumber - 1];
    }

    public void depositMoney(int moneyToDeposit, CreditCard card) {
        if (moneyToDeposit > 0) {
            card.accountBalance += moneyToDeposit;
            System.out.println("Operation is completed successfully. The actual balance is: " + card.accountBalance);
        } else {
            System.out.print("Incorrect sum for deposit. Please, correct it and repeat the operation: ");
        }
    }

    public void withdrawMoney(int moneyToWithdraw, CreditCard card) {
        if (card.accountBalance >= moneyToWithdraw) {
            card.accountBalance -= moneyToWithdraw;
            System.out.println("Operation is completed successfully. The actual balance is: " + card.accountBalance);
        } else {
            System.out.println("Not enough money to withdraw. The operation is cancelled.");
        }
    }

    public void showActualBalance(CreditCard card) {
        System.out.println("Card number is: " + card.accountNumber + "\nActual balance is: " + card.accountBalance);
    }

    public int requestMoneyForOperation() {
        int moneyForOperation = 0;
        boolean validUserInput = false;

        System.out.print("Please, enter money amount for the operation: ");
        while (!validUserInput) {
            if (scanner.hasNextInt()) {
                moneyForOperation = scanner.nextInt();
                if (moneyForOperation > 0) {
                    validUserInput = true;
                } else {
                    System.out.print("Invalid sum is entered. Please, try again: ");
                }
            } else {
                System.out.print("Invalid sum is entered. Please, try again: ");
                scanner.next();
            }
        }
        scanner.nextLine();
        return moneyForOperation;
    }

    public void selectOperation() {
        String userAction;
        do {
            CreditCard card = selectCardForOperation();
            System.out.println("Please, select an operation (a number): 1 - Show card information, 2 - Deposit money, " +
                    "3 - Withdraw money, or type 'exit' to quit");

            userAction = scanner.nextLine().trim().toLowerCase();

            if (!userAction.equals("exit")) {
                switch (userAction) {
                    case "1": {
                        showActualBalance(card);
                        break;
                    }
                    case "2": {
                        int moneyForOperation = requestMoneyForOperation();
                        depositMoney(moneyForOperation, card);
                        break;
                    }
                    case "3": {
                        int moneyForOperation = requestMoneyForOperation();
                        withdrawMoney(moneyForOperation, card);
                        break;
                    }
                    default: {
                        System.out.println("Incorrect operation is selected. Please, try again.");
                    }
                }
            }
        } while (!userAction.equals("exit"));

        System.out.println("Thanks for using our service!");
    }
}
