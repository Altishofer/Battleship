package fleet;

import java.util.ArrayList;

public class Ship
{
    protected ArrayList<int[]> aCoordinates = new ArrayList<int[]>();
    protected final ShipType aType;
    protected int aSize;
    public Ship(ShipType pType)
    {
        aType = pType;
        aSize = pType.size;
    }
    public int getSize(){return aSize;}
    public String toString() {return aType.toString();}
    public void setHit() {
        aSize -= 1;
        if(aSize<=0){
            System.out.println("A "+aType.toString()+" sunk!");
        }
    }

    public boolean hasSunk(){return aSize <= 0;}

    public  ArrayList<int[]> getCoordinates()
    {
        ArrayList<int[]> copy = new ArrayList<int[]>();
        for (int[] elem : aCoordinates)
        {
            copy.add(new int[]{elem[0], elem[1]});
        }
        return copy;
    }
    public  void setCoordinates(ArrayList<int[]> pCoordinates)
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