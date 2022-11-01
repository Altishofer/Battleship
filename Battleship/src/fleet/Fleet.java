package fleet;

import java.util.ArrayList;

public class Fleet
{
    private ArrayList<Ship> aShips = new ArrayList<Ship>();

    public void addShip(Ship pShip){
        aShips.add(pShip);
    }

    public boolean defeated(){
        for (Ship ship : aShips)
        {
            if (!ship.hasSunk()){return false;}
        }
        return true;
    }
}