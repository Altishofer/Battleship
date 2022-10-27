package player;

import fleet.Fleet;
import ui.Grid;

public abstract class Player
{
    protected final Fleet aFleet = new Fleet();
    protected final Grid aGrid = new Grid();

    public abstract int[] nextMove();
    public abstract void setFleet();
    public abstract boolean defeated();
}
