package ui;

import player.Npc;
import player.User;

public class Board {
    private User user = new User();
    private Npc npc = new Npc();

    public Board ()
    {


    }
    private final String titleOceanGrid = "==== OCEAN GRID ====";
    private final String titleTargetGrid = "==== TARGET GRID ====";
    private final String letterCoordinates = "A B C D E F G H I J";
    private final String delimiter = "+-+-+-+-+-+-+-+-+-+-+";

    public void printOceanGrid(Grid grid){
        String[][] oceanBoard = grid.getOceanGridStrings();
        System.out.println(titleOceanGrid);
        System.out.println(letterCoordinates);
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

    public void printTargetGrid(Grid grid){
        String[][] oceanBoard = grid.getTargetGridStrings();
        System.out.println(titleOceanGrid);
        System.out.println(letterCoordinates);
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
