package fleet;

import java.util.ArrayList;

public class SingletonNullShip extends Ship {

    private static SingletonNullShip INSTANCE;

    private SingletonNullShip() {
        super(ShipType.NULL);
    }

    public static synchronized SingletonNullShip getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SingletonNullShip();
        }
        return INSTANCE;
    }

    @Override
    public int getSize(){return 0;}

    @Override
    public  void setHit() {}

    @Override
    public  boolean hasSunk(){return false;}

    @Override
    public ArrayList<int[]> getCoordinates()
    {
        return  new ArrayList<>();
    }

    @Override
    public  void setCoordinates(ArrayList<int[]> pCoordinates){}
}
