package fleet;

import java.util.ArrayList;

public class SingletonNullShip extends Ship {

    private static final SingletonNullShip INSTANCE = new SingletonNullShip();

    private SingletonNullShip() {
        super(ShipType.NULL, true);
    }

    public static SingletonNullShip getInstance() {return INSTANCE;}
    @Override
    public int getSize(){return 0;}

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
}
