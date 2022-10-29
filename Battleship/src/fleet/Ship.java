package fleet;

import java.util.ArrayList;

public class Ship
{
    protected ArrayList<int[]> aCoordinates = new ArrayList<int[]>();
    protected final String aType;
    protected int aSize;

    private boolean isNull;

    public Ship(String pType, int pSize, boolean pIsNull)
    {
        aType = pType;
        aSize = pSize;
        isNull = pIsNull;
    }
    //TODO: removed final to be able to override
    public int getSize(){return aSize;}
    //TODO: removed final to be able to override
    public String toString() {return aType;}
    //TODO: removed final to be able to override
    public void setHit() {
        aSize -= 1;
        if(aSize<=0){
            System.out.println("A "+aType+" sunk!");
        }
    }
    //TODO: removed final to be able to override
    public boolean hasSunk(){return aSize <= 0;}

    public boolean istNullShip(){return aType == "Null";}
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