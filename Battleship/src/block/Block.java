package block;

public class Block
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

    public String toStringOcean() {
        if (aShip != null && !aHit)
        {
            return aShip.toString();
        }
        if (aShip != null && aHit)
        {
            return "X";
        }
        if (aHit)
        {
            return "0";
        }
        return " ";
    }

    public String toStringTarget() {
        if (aShip != null && aHit && aShip.hasSunk())
        {
            return aShip.toString();
        }
        if (aShip != null && aHit)
        {
            return "X";
        }
        if (aHit)
        {
            return "0";
        }
        return " ";
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
