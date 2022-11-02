import ui.Board;

public class Main
{
    private final static Board BOARD = new Board();
    public static void main(String[] args)
    {
        while(true)
        {
            BOARD.printTargetGrid();
            BOARD.printOceanGrid();
            if (BOARD.gameIsOver()){break;}
            BOARD.userMove();

            BOARD.printTargetGrid();
            BOARD.printOceanGrid();
            if (BOARD.gameIsOver()){break;}
            BOARD.npcMove();
        }
    }
}