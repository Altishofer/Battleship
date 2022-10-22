package block;

public class Block
{
    private boolean aHit = false;
    // TODO: replace null with anonymous class
    // TODO: check if final possible
    private fleet.Ship aShip = null;

    // TODO: check if needs boolean
    public void setHit()
    {
        if (aShip == null){return;}
        aShip.setHit();
    }

    public String toStringOcean() {
        if (aShip != null && !aHit){return Character.toString(aShip.toString().charAt(0));}
        if (aShip != null && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringTarget() {
        if (aShip != null && aHit && aShip.hasSunk()){return Character.toString(aShip.toString().charAt(0));}
        if (aShip != null && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public boolean hasShip(){return aShip != null;}
    public boolean gotHit(){return aHit;}
    public void setShip(fleet.Ship pShip){aShip = pShip;}
    public boolean hasSunk()
    {
        if (aShip == null){return false;}
        return aShip.hasSunk();
    }
}
