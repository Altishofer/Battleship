package player;

import fleet.Fleet;
import ui.Grid;

public abstract class Player
{
    protected final Fleet aFleet = new Fleet();
    protected final Grid aGrid = new Grid();

    public abstract int[] nextMove();
    public abstract void setFleet();
    public boolean defeated()
    {
        return aFleet.defeated();
    }
    public boolean beenShot(int[] shot)
    {
        return aGrid.beenShot(shot);
    }
    public void setHit(int[] shot)
    {
        aGrid.setHit(shot);
    }
    public String[][] getOceanGridStrings()
    {
        return aGrid.getOceanGridStrings();
    }
    public String[][] getTargetGridStrings()
    {
        return aGrid.getTargetGridStrings();
    }
    //public String[][] getFinalGridStrings(){return aGrid.getFinalGridStrings();}
    protected abstract void configureShip(fleet.Ship ship);

}
