
import ui.Board;
import java.util.Random;

public class Main
{
    private static final Board board = new Board();
    public static void main(String[] args)
    {
        while(true)
        {
            //clearConsole();
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

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}