package fleet;

public abstract class ShipFactory
{
    public static Ship getShip(String pType)
    {
        if (pType == null){return null;}
        if (pType.equalsIgnoreCase("Battleship"))
        {
            return new Ship("Battleship", 4);
        }
        if (pType.equalsIgnoreCase("Carrier"))
        {
            return new Ship("Carrier", 6);
        }
        if (pType.equalsIgnoreCase("Patrol Boat"))
        {
            return new Ship("Patrol Boat", 2);
        }
        if (pType.equalsIgnoreCase("Submarine"))
        {
            return new Ship("Submarine", 3);
        }
        if (pType.equalsIgnoreCase("Null"))
        {
            return new Ship("Null", 0);
        }
        return null;
    }
}
