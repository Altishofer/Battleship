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

    public void printOceanGrid(){
        String[][] oceanGrid = user.getOceanGridStrings();
        GridUtils.printGrid(oceanGrid, new String(), GridUtils.TITLE_OCEAN_GRID);
    }

    public void printTargetGrid(){
        String[][] targetGrid = npc.getTargetGridStrings();
        GridUtils.printGrid(targetGrid, GridUtils.DELIMITER_3, GridUtils.TITLE_TARGET_GRID);
    }

    private void printFinalGrid(){
        String[][] targetGrid = npc.getFinalGridStrings();
        GridUtils.printGrid(targetGrid, GridUtils.DELIMITER_2, GridUtils.TITLE_FINAL_NPC_GRID);
    }
}
