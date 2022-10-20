package fleet;

import java.util.ArrayList;

public abstract class Ship
{
    private ArrayList<String> aCoordinates;
    private final String aType;
    private int aSize;
    public Ship(String pType, int pSize)
    {
        aType = pType;
        aSize = pSize;
    }
    public int getSize(){return aSize;}
    public String toString() {return aType;}
    public void setHit() {aSize -= 1;}
    public boolean hasSunk(){return aSize <= 0;}
    public ArrayList<String> getCoordinates()
    {
        ArrayList<String> copy = new ArrayList<String>();
        for (String elem : aCoordinates){copy.add(elem);}
        return copy;
    }
    public void setCoordinates(ArrayList<String> pCoordinates)
    {
        for (String coor : pCoordinates)
        {
            aCoordinates.add(coor);
        }
    }
}
