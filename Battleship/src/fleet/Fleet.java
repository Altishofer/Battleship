package fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet
{
    ArrayList<Ship> fleet;

    public boolean gameLost(){
        for (Ship ship : fleet)
        {
            if (!ship.hasSunk())
            {
                return false;
            }
        }
        return true;
    }
}
