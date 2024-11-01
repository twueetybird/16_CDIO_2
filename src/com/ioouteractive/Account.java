package com.ioouteractive;

public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void setBalance(int amount) {
        if (amount < 0) {
            this.balance = 0;
        }
        this.balance = amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public int deposit(int amount) { // Returns balance
        this.balance += amount;
        return this.balance;
    }

    public int withdraw(int amount) { // Returns remaining balance. If balance goes below zero, it is set to zero
        this.balance -= amount;
        if (this.balance < 0) {
            this.balance = 0;
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return String.valueOf(this.balance);
    }
}
