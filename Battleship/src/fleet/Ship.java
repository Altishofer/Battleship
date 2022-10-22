package fleet;

import fleet.ShipTypes.Battleship;

import java.util.ArrayList;

public abstract class Ship
{
    private ArrayList<String> aCoordinates = new ArrayList<String>();
    private final String aType;
    private int aSize;

    public Ship(String pType, int pSize)
    {
        aType = pType;
        aSize = pSize;
    }
    public final int getSize(){return aSize;}
    public final String toString() {return aType;}
    public final void setHit() {aSize -= 1;}
    public final boolean hasSunk(){return aSize <= 0;}
    public final ArrayList<String> getCoordinates()
    {
        ArrayList<String> copy = new ArrayList<String>();
        for (String elem : aCoordinates){copy.add(elem);}
        return copy;
    }
    public final void setCoordinates(ArrayList<String> pCoordinates)
    {
        for (String coor : pCoordinates)
        {
            aCoordinates.add(coor);
        }
    }
}