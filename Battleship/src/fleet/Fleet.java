package fleet;

import java.util.ArrayList;

public class Fleet
{
    private ArrayList<Ship> aFleet = new ArrayList<Ship>();

    public void addShip(Ship pShip){aFleet.add(pShip);}

    public boolean gameLost(){
        for (Ship ship : aFleet)
        {
            if (!ship.hasSunk()){return false;}
        }
        return true;
    }


}
