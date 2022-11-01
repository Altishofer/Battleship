package fleet;

public abstract class ShipFactory
{
    public static Ship getShip(ShipType pType)
    {
        if (pType == null){return null;}
        if (pType.equals(ShipType.BATTLESHIP))
        {
            return new Ship(ShipType.BATTLESHIP, false);
        }
        if (pType.equals(ShipType.CARRIER))
        {
            return new Ship(ShipType.CARRIER, false);
        }
        if (pType.equals(ShipType.PATROLBOAT))
        {
            return new Ship(ShipType.PATROLBOAT, false);
        }
        if (pType.equals(ShipType.SUBMARINE))
        {
            return new Ship(ShipType.SUBMARINE, false);
        }
        if (pType.equals(ShipType.NULL))
        {
            return SingletonNullShip.getInstance();
        }
        return null;
    }
}
