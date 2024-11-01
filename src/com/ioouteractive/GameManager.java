package com.ioouteractive;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GameManager {

    private static String SAVE_DIR = "DingDongDice/";

    public static boolean savePlayer(Player player) { // Return false if player could not be saved
        File file = new File(SAVE_DIR + player.getName() + ".txt");
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs(); // Create save directory
            }
            if (!file.exists()) {
                file.createNewFile();
                file.mkdirs();
                System.out.println("Creating save for " + player.getName());
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(player.getBalance()));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Player \"" + player.getName() + "\" has been saved.");
        return true;
    }

    public static Player createPlayer(String playerName) { // Used to create all players. Returns new blank player if no
                                                           // save data exists
        File file = new File(SAVE_DIR + playerName + ".txt");

        Player player = new Player(playerName);
        if (file.exists()) {
            System.out.print(playerName + " already exists. Accessing previous data. ");
            int balance = 0;
            try {
                Scanner scanner = new Scanner(file);
                balance = scanner.nextInt();
                player.getAccount().setBalance(balance);
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Points : " + balance);
        }
        return player;
    }
}
