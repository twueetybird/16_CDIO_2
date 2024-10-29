public class Player {
    private String name; 
    private Account account; 
    private boolean extraTurn; 

    public static final int startBalance = 1000; // Starting balance for both players
    public static final int winningBalance = 3000; // Balance required to win the game

    public Player(String name) {
        this.name = name;
        this.account = new Account(startBalance); 
        this.extraTurn = false; 
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return account.getBalance(); 
    }

    public boolean hasWon() {
        return account.getBalance() >= winningBalance; // Check if the player has reached the winning balance
    }

    public boolean hasExtraTurn() {
        return extraTurn; 
    }

    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn; 
    }

    public String addBalance(int amount) {
        return account.deposit(amount); 
    }

    public String subtractBalance(int amount) {
        return account.withdraw(amount); 
    }

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return name + " - " + account.toString(); // Return a string representation of the player and their account
    }
}

