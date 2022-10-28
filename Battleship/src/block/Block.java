package block;

import fleet.ShipFactory;

public class Block
{
    private boolean aHit = false;
    // TODO: replace null with anonymous class
    // TODO: check if final possible
    private fleet.Ship aShip = ShipFactory.getShip("Null");

    // TODO: check if needs boolean
    public void setHit()
    {
        aHit = true;
        if (aShip.isNull()){return;}
        aShip.setHit();
    }

    public String toStringOcean() {
        if (!aShip.isNull() && !aHit){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.isNull() && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringTarget() {
        if (!aShip.isNull() && aHit && aShip.hasSunk()){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.isNull() && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public boolean hasShip(){return !aShip.isNull();}
    public boolean gotHit(){return aHit;}

    public void setShip(fleet.Ship pShip){aShip = pShip;}
    public boolean hasSunk()
    {
        if (!aShip.isNull()){return false;}
        return aShip.hasSunk();
    }
}
