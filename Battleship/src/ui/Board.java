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
            System.out.println("Please do not interrupt!");
            // TODO: Is this ok?
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
            System.out.println("Please do not interrupt!");
            // TODO: Is this ok?
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
            System.out.println("Please do not interrupt!");
            // TODO: Is this ok?
        };
    }
    private final String titleFinalNPCGrid = "===== NPC GRID =====";
    private final String titleOceanGrid = "===== OCEAN  GRID =====";
    private final String titleTargetGrid = "===== TARGET GRID =====";
    private final String letterCoordinates = "  A B C D E F G H I J";
    private final String delimiter2 = "=======================";
    private final String delimiter3 = "\n-----------------------\n";
    private final String delimiter1 = " +-+-+-+-+-+-+-+-+-+-+";

    public void printOceanGrid(){
        String[][] oceanGrid = user.getOceanGridStrings();
        printGrid(oceanGrid, new String(), titleOceanGrid);
    }

    public void printTargetGrid(){
        String[][] targetGrid = npc.getTargetGridStrings();
        printGrid(targetGrid, delimiter3, titleTargetGrid);
    }

    private void printFinalGrid(){
        String[][] targetGrid = npc.getFinalGridStrings();
        printGrid(targetGrid, delimiter2, titleFinalNPCGrid);
    }

    private void printGrid(String[][] board, String delimiter, String title)
    {
        System.out.println(title);
        System.out.println(letterCoordinates);
        System.out.println(delimiter1);
        for (Integer i=0; i<board.length; i++)
        {
            String line = i.toString();
            for (Integer j = 0; j<board[i].length; j++)
            {
                line += "|" + board[i][j];
            }
            line += "|" + i.toString();
            System.out.println(line);
        }
        System.out.println(delimiter1);
        System.out.println(letterCoordinates);
        System.out.println(delimiter2);
        System.out.println(delimiter);
    }
}
