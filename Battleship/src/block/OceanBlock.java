package block;

public class OceanBlock
{
    private boolean aHit = false;
    private fleet.Ship aShip = null;

    public boolean setHit()
    {
        aHit = true;

        if (aShip == null)
        {
            return false;
        }
        aShip.setHit();
        return true;
    }

    public String toString() {
        if (aShip == null)
        {
            return "|";
        }
        if (aShip.hasSunk())
        {
            return aShip.toString();
        }
        if (aHit)
        {
            return "X";
        }
    }

    public boolean hasShip()
    {
        return aShip == null;
    }

    public boolean gotHit()
    {
        return aHit;
    }

    public void setShip(fleet.Ship pShip)
    {
        aShip = pShip;
    }

    public boolean hasSunk()
    {
        if (aShip == null){return false;}
        return aShip.hasSunk();
    }


}
