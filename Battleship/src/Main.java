
import ui.Board;

public class Main
{
    private static final Board board = new Board();
    public static void main(String[] args)
    {
        while(true)
        {
            board.printTargetGrid();
            board.printOceanGrid();
            if (board.gameIsOver()){break;}
            board.userMove();

            board.printTargetGrid();
            board.printOceanGrid();
            if (board.gameIsOver()){break;}
            board.npcMove();
        }
    }
}