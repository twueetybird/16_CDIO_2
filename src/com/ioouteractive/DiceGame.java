package com.ioouteractive;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    private static final int[] fieldEffects = {0, 0, 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
    private static final String[] fieldMessages = {
            "", 
            "",
            "You've climbed the Eiffel Tower and gained 250 coins!",
            "You fell into a Meteor Crater and lost 100 coins. Watch your step next time.",
            "You entered through the graceful Palace Gates and gained 100 coins!",
            "You're walking through the Cold Desert, and lost 20 coins. Brrr...",
            "You've found shelter in the Walled City and gained 180 coins!",
            "You've arrived at the Monastery, but nothing happened.",
            "You got lost in the Black Cave and a Black Cave thief stole your 70 coins.",
            "You found refuge in the Huts in the Mountain and the villagers kindly gifted you 60 coins.",
            "You faced the mysterious Werewall and lost 80 coins but earned an extra turn!",
            "You fell into the big hollow Pit and 50 of your coins fell too.",
            "You've discovered the a huge Goldmine and found 650 coins! "
    };

    private Player player1;
    private Player player2;
    private Random dice;
    private Scanner scanner;

    public DiceGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.dice = new Random();
        this.scanner = new Scanner(System.in); 
    }

    private int rollDice() {
        return dice.nextInt(bound:6) + 1 + dice.nextInt(bound:6) + 1;
    }
    
      private void processField(Player player, int field) {
        int effect = fieldEffects[field - 2];
        if (effect > 0) {
            System.out.println(player.addBalance(effect));
        } else {
            System.out.println(player.subtractBalance(-effect));
        }

        System.out.println(player.getName() + " rolled a " + field + ": " + fieldMessages[field - 2]);
        System.out.println("New Balance: " + player.getBalance());

    }

    private static boolean CheckExtraRoll() {
        if(DiceRolls() == 10) {
            return true;
        }

        return false;
    }

           public static void main(String[] args) {
        System.out.println("Hello and welcome to Ding Dong Dice!");    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        DiceGame game = new DiceGame(player1Name, player2Name);
        game.playGame();
        scanner.close();
    
}
}
