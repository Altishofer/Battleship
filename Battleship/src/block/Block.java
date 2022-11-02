package block;

import fleet.ShipFactory;
import fleet.ShipType;

public class Block
{
    private boolean aHit = false;

    private fleet.Ship aShip = ShipFactory.getShip(ShipType.NULL);

    public void setHit()
    {
        aHit = true;
        if (aShip.equals(ShipFactory.getShip(ShipType.NULL))){
            System.out.println("Shot missed!");
            return;
        }
        System.out.println("A ship was hit!");
        aShip.setHit();
    }

    public String toStringOcean() {
        if (!aShip.equals(ShipFactory.getShip(ShipType.NULL)) && !aHit){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.equals(ShipFactory.getShip(ShipType.NULL)) && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringTarget() {
        if (!aShip.equals(ShipFactory.getShip(ShipType.NULL)) && aHit && aShip.hasSunk()){return Character.toString(aShip.toString().charAt(0));}
        if (!aShip.equals(ShipFactory.getShip(ShipType.NULL)) && aHit){return "X";}
        if (aHit){return "o";}
        return " ";
    }

    public String toStringFinal() {
        if (!aShip.equals(ShipFactory.getShip(ShipType.NULL))){return Character.toString(aShip.toString().charAt(0));}
        return " ";
    }

    public boolean hasShip(){return !aShip.equals(ShipFactory.getShip(ShipType.NULL));}

    public boolean gotHit(){return aHit;}

    public void setShip(fleet.Ship pShip){aShip = pShip;}
}
