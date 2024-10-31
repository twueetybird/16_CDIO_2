package com.ioouteractive;

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
