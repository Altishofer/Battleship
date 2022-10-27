package fleet;

import java.util.ArrayList;

public class Ship
{
    private ArrayList<int[]> aCoordinates = new ArrayList<int[]>();
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
    public boolean istNullShip(){return aType == "Null";}
    public final ArrayList<int[]> getCoordinates()
    {
        ArrayList<int[]> copy = new ArrayList<int[]>();
        for (int[] elem : aCoordinates)
        {
            copy.add(new int[]{elem[0], elem[1]});
        }
        return copy;
    }
    public final void setCoordinates(ArrayList<int[]> pCoordinates)
    {
        for (int[] coor : pCoordinates)
        {
            aCoordinates.add(coor);
        }
    }

    @Override
    public boolean equals (Object pObject)
    {
        if( pObject == null ) {
            return false;
        }
        else if( pObject == this ) {
            return true;
        }
        else if( pObject.getClass() != getClass()) {
            return false;
        }
        else {
            return aType == ((Ship)pObject).aType;
        }
    }

    @Override
    public int hashCode()
    {
        return aType.hashCode();
    }
}