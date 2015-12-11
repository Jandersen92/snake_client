package main;

import logic.Logic;

/**
 * Created by johanandersen on 25/11/2015.
 */
public class Main {
    /**
     * main methoed that starts the program logic.run() from the logic class
     * @param args
     */
    public static void main (String[] args)
    {

        Logic logic = new Logic();
        logic.run();
    }
}
