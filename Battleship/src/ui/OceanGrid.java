package ui;

import block.OceanBlock;

public class OceanGrid extends Grid
{
    private OceanBlock[][] aGrid = new block.OceanBlock[10][10];
    public void setBlock(String pCoordinate, fleet.Ship pShip)
    {
        int[] coor = convertCoordinates(pCoordinate);
        aGrid[coor[0]][coor[1]].setShip(pShip);
    }

    public void getShot(String pCoordinate)
    {
        int[] coor = convertCoordinates(pCoordinate);
        aGrid[coor[0]][coor[1]].setHit();
    }

}
