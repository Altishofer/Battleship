package fleet;

public abstract class ShipFactory
{
    public static Ship getShip(String pType)
    {
        if (pType == null){return null;}
        if (pType.equalsIgnoreCase("Battleship"))
        {
            return new Ship(ShipType.BATTLESHIP, false);
        }
        if (pType.equalsIgnoreCase("Carrier"))
        {
            return new Ship(ShipType.CARRIER, false);
        }
        if (pType.equalsIgnoreCase("Patrol Boat"))
        {
            return new Ship(ShipType.PATROLBOAT, false);
        }
        if (pType.equalsIgnoreCase("Submarine"))
        {
            return new Ship(ShipType.SUBMARINE, false);
        }
        if (pType.equalsIgnoreCase("Null"))
        {
            return SingletonNullShip.getInstance();
        }
        return null;
    }
}
