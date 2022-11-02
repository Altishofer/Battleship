package fleet;

public class ShipFactory
{
    public static Ship getShip(ShipType pType)
    {
        if (pType == null){return null;}
        if (pType.equals(ShipType.BATTLESHIP))
        {
            return new Ship(ShipType.BATTLESHIP);
        }
        if (pType.equals(ShipType.CARRIER))
        {
            return new Ship(ShipType.CARRIER);
        }
        if (pType.equals(ShipType.PATROLBOAT))
        {
            return new Ship(ShipType.PATROLBOAT);
        }
        if (pType.equals(ShipType.SUBMARINE))
        {
            return new Ship(ShipType.SUBMARINE);
        }
        if (pType.equals(ShipType.NULL))
        {
            return SingletonNullShip.getInstance();
        }
        return null;
    }
}
