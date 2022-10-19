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
        aShip.
        return true;
    }

    public boolean getHit()
    {
        return aHit;
    }

    public void setShip(fleet.Ship pShip)
    {
        aShip = pShip;
    }


}
