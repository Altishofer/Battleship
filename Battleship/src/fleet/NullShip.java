package fleet;

import java.util.ArrayList;

public class NullShip extends Ship {

    public NullShip() {
        super("", 0, true);
    }
    @Override
    public  int getSize(){return 0;}

    @Override
    public  String toString() {return "Null";}

    @Override
    public  void setHit() {}

    @Override
    public  boolean hasSunk(){return false;}

    @Override
    public boolean istNullShip(){return true;}

    @Override
    public ArrayList<int[]> getCoordinates()
    {
        return  new ArrayList<>();
    }

    @Override
    public  void setCoordinates(ArrayList<int[]> pCoordinates){}

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
