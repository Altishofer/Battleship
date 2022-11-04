package fleet;

public class ShipFactory
{
    public static Ship getShip(ShipType pType)
    {
        switch(pType) 
        {
            case BATTLESHIP: return new Ship(ShipType.BATTLESHIP);
            case CARRIER:    return new Ship(ShipType.CARRIER);
            case PATROLBOAT: return new Ship(ShipType.PATROLBOAT);
            case SUBMARINE:  return new Ship(ShipType.SUBMARINE);
            case NULL:       return SingletonNullShip.getInstance();
        }
        return null;
    }
}
