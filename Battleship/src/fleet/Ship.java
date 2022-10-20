package fleet;

import java.util.ArrayList;

public class Ship
{

    private final ArrayList<String> aCoordinates;
    private final String aType;
    private int aSize;

    public String toString() {
        return aType;
    }

    public Ship(String pType, ArrayList<String> pCoordinates)
    {
        this.aType = pType;
        this.aSize = pCoordinates.size();
        this.aCoordinates = pCoordinates;
    }
    public void setHit()
    {
        aSize -= 1;
    }
    public boolean hasSunk()
    {
        return aSize <= 0;
    }

    public ArrayList getCoordinates()
    {
        ArrayList<String> copy = new ArrayList<String>();
        for (String elem : aCoordinates)
        {
            copy.add(elem);
        }
        return copy;
    }
}
