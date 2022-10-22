package ui;

import player.Npc;
import player.User;

public class Board {
    private User user = new User();
    private Npc npc = new Npc();

    public boolean gameIsOver()
    {
        if (user.defeated())
        {
            System.out.println("User has been defeated!");
            return true;
        }
        if (npc.defeated())
        {
            System.out.println("Npc has been defeated!");
            return true;
        }
        return false;
    }

    public void npcMove()
    {
        while (true) {
            String shot = npc.nextMove();
            if (!user.getGrid().beenShot(shot)) {
                user.getGrid().setHit(shot);
                break;
            }
        }
    }

    public void userMove()
    {
        while (true)
        {
            String shot = user.nextMove();
            if (!npc.getGrid().beenShot(shot))
            {
                npc.getGrid().setHit(shot);
                break;
            }
            System.out.println(String.format("The given coordinate (%s) has already been shot, try again! ;)", shot));
        }
    }
    private final String titleOceanGrid = "===== OCEAN GRID =====";
    private final String titleTargetGrid = "===== TARGET GRID =====";
    private final String letterCoordinates = "  A B C D E F G H I J";
    private final String delimiter2 = "=======================";
    private final String delimiter3 = "\n-----------------------\n";
    private final String delimiter1 = " +-+-+-+-+-+-+-+-+-+-+";

    public void printOceanGrid(){
        String[][] oceanBoard = user.getGrid().getOceanGridStrings();
        Grid grid = user.getGrid();
        System.out.println(titleOceanGrid);
        System.out.println(letterCoordinates);
        System.out.println(delimiter1);
        for (Integer i=0; i<oceanBoard.length; i++)
        {
            String line = i.toString();
            for (Integer j = 0; j<oceanBoard[i].length; j++)
            {
                line += "|" + oceanBoard[i][j];
            }
            line += "|" + i.toString();
            System.out.println(line);
        }
        System.out.println(delimiter1);
        System.out.println(letterCoordinates);
        System.out.println(delimiter2);
    }

    public void printTargetGrid(){
        String[][] oceanBoard = npc.getGrid().getTargetGridStrings();
        System.out.println(titleTargetGrid);
        System.out.println(letterCoordinates);
        System.out.println(delimiter1);
        for (Integer i=0; i<oceanBoard.length; i++)
        {
            String line = i.toString();
            for (Integer j = 0; j<oceanBoard[i].length; j++)
            {
                line += "|" + oceanBoard[i][j];
            }
            line += "|" + i.toString();
            System.out.println(line);
        }
        System.out.println(delimiter1);
        System.out.println(letterCoordinates);
        System.out.println(delimiter2);
        System.out.println(delimiter3);
    }
}
