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
        if (aShip.equals(ShipFactory.getShip("Null"))){
            System.out.println("Shot missed!");
            return;
        }
        System.out.println("A ship was hit!");
        aShip.setHit();
    }

    public String toStringOcean() {
        if (!aShip.equals(ShipFactory.getShip("Null")) && !aHit){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.equals(ShipFactory.getShip("Null")) && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringTarget() {
        if (!aShip.equals(ShipFactory.getShip("Null")) && aHit && aShip.hasSunk()){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.equals(ShipFactory.getShip("Null")) && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringFinal() {
        if (!aShip.equals(ShipFactory.getShip("Null"))){return Character.toString(aShip.toString().charAt(0));}
        return " ";
    }

    public boolean hasShip(){return !aShip.equals(ShipFactory.getShip("Null"));}
    public boolean gotHit(){return aHit;}

    public void setShip(fleet.Ship pShip){aShip = pShip;}
    public boolean hasSunk()
    {
        if (!aShip.equals(ShipFactory.getShip("Null"))){return false;}
        return aShip.hasSunk();
    }
}
