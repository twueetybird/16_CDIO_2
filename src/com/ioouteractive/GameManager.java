package com.ioouteractive;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameManager {

    private static String SAVE_DIR = System.getProperty("user.dir") + "/DingDongDice/";

    public static boolean savePlayer(Player player) { // Return false if player could not be saved
        File file = new File(SAVE_DIR + "/" + player.getName() + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            if (file.createNewFile()) { // If the file does not exist
                System.out.println("Overwriting previous save data");
            }
            fileWriter.write(String.valueOf(player.getBalance()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Player \"" + player + "\" has been saved.");
        return true;
    }

    public static Player createPlayer(String playerName) { // Used to create all players. Returns new blank player if no save data exists
        File file = new File(SAVE_DIR + "/" + playerName + ".txt");

        Player player = new Player(playerName);
        if (file.exists()) {
            System.out.println("Player already exists. Accessing previous data...");
            Scanner scanner = new Scanner(file);
            player.getAccount().setBalance(scanner.nextInt());
            scanner.close();
        }

        return player;
    }
}
