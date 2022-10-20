package ui;

import java.util.ArrayList;

public class Board {

    Grid playerGrid;
    Grid npcGrid;


    private final String titleOceanGrid = "==== OCEAN GRID ====";
    private final String titelTargetGrid = "==== TARGET GRID ====";
    private final String titleLetters = "A B C D E F G H I J";
    private final String delimiter = "+-+-+-+-+-+-+-+-+-+-+";

    public void printaGrid(){
        String[][] oceanBoard = grid.getOceanGridStrings();
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
