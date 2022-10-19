package fleet;

import java.util.ArrayList;

public class Ship
{

    private final ArrayList<String> aCoordinates;
    private final char aType;
    private int aSize;

    public Ship(char pType, ArrayList<String> pCoordinates)
    {
        this.aType = pType;
        this.aSize = pCoordinates.size();
        this.aCoordinates = pCoordinates;
    }
    public void gotHit()
    {
        aSize -= 1;
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
