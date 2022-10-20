package ui;

import java.util.ArrayList;

public class Board {

    ArrayList<String> output;
    Grid grid = new Grid();

    public void printOceanGrid(){
        String[][] oceanBoard = grid.getOceanGridStrings();
        String titleOceanGrid = "==== OCEAN GRID ====";
        String titleLetters = "A B C D E F G H I J";
        String delimiter = "+-+-+-+-+-+-+-+-+-+-+";

        System.out.println(titleOceanGrid);
        System.out.println(titleLetters);
        System.out.println(delimiter);
        for (Integer i=0; i<oceanBoard.length; i++)
        {
            String line = i.toString();
            for (Integer j = 0; j<oceanBoard[i].length; j++)
            {
                line += oceanBoard[i][j];
            }
            line += i.toString();
            System.out.println(line);
        }
    }

}
