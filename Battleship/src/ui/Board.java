package ui;

import player.Npc;
import player.User;
import java.util.concurrent.TimeUnit;

public class Board {
    private User user = new User();
    private Npc npc = new Npc();

    public boolean gameIsOver()
    {
        if (user.defeated())
        {
            System.out.println("User has been defeated!");
            printFinalGrid();
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
        System.out.println("NPC is playing...");
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            // Is this ok?
        };
        while (true) {
            int[] shot = npc.nextMove();
            if (!user.beenShot(shot)) {
                user.setHit(shot);
                break;
            }
        }
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            // Is this ok?
        };
    }

    public void userMove()
    {
        System.out.println("\nIt is your turn!");
        while (true)
        {
            int[] shot = user.nextMove();
            if (!npc.beenShot(shot))
            {
                npc.setHit(shot);
                break;
            }
            System.out.println("The given coordinate has already been shot, try again!");
        }
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            // Is this ok?
        };
    }
    private final String titleFinalNPCGrid = "===== NPC GRID =====";
    private final String titleOceanGrid = "===== OCEAN GRID =====";
    private final String titleTargetGrid = "===== TARGET GRID =====";
    private final String letterCoordinates = "  A B C D E F G H I J";
    private final String delimiter2 = "=======================";
    private final String delimiter3 = "\n-----------------------\n";
    private final String delimiter1 = " +-+-+-+-+-+-+-+-+-+-+";

    public void printOceanGrid(){
        String[][] oceanBoard = user.getOceanGridStrings();
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
        String[][] oceanBoard = npc.getTargetGridStrings();
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

    // TODO: potentially dangerous
    private void printFinalGrid(){
        String[][] oceanBoard = npc.getGrid().getFinalGridStrings();
        Grid grid = npc.getGrid();
        System.out.println(titleFinalNPCGrid);
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
}
