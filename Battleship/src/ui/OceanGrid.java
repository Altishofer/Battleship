package ui;

import block.OceanBlock;

import java.util.ArrayList;

public class OceanGrid extends Grid
{
    private OceanBlock[][] aGrid = new block.OceanBlock[10][10];

    public String[][] getGridStrings(){
        String[][] copyGrid = new String[10][10];

        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                copyGrid[i][j] = aGrid[i][j].toString();
            }
        }
        return copyGrid;
    }
    public void setShip(String pCoordinate, fleet.Ship pShip)
    {
        OceanBlock block = getBlock(pCoordinate);
        block.setShip(pShip);
    }

    public void setHit(String pCoordinate)
    {
        OceanBlock block = getBlock(pCoordinate);
        block.setHit();
    }

    private OceanBlock getBlock(String pCoordinate)
    {
        int[] coor = convertCoordinates(pCoordinate);
        return aGrid[coor[0]][coor[1]];
    }

}
