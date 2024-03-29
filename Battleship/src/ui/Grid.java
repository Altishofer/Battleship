package ui;

import block.Block;
import fleet.Ship;

import java.util.ArrayList;

public class Grid {
    private final Block[][] aBlocks = new Block[10][10];

    public Grid ()
    {
        for (int i = 0; i < aBlocks.length; i++)
        {
            for (int j = 0; j < aBlocks[i].length; j++)
            {
                aBlocks[i][j] = new Block();
            }
        }
    }

    public String[][] getOceanGridStrings(){
        String[][] copyGrid = new String[10][10];
        for (int i = 0; i < aBlocks.length; i++)
        {
            for (int j = 0; j < aBlocks[i].length; j++)
            {
                copyGrid[i][j] = aBlocks[i][j].toStringOcean();
            }
        }
        return copyGrid;
    }

    public String[][] getTargetGridStrings(){
        String[][] copyGrid = new String[10][10];

        for (int i = 0; i < aBlocks.length; i++)
        {
            for (int j = 0; j < aBlocks[i].length; j++)
            {
                copyGrid[i][j] = aBlocks[i][j].toStringTarget();
            }
        }
        return copyGrid;
    }

    public void setShip(Ship pShip)
    {
        for (int[] coor : pShip.getCoordinates())
        {
            Block block = getBlock(coor);
            block.setShip(pShip);
        }
    }

    public void setHit(int[] pCoordinate)
    {
        Block block = getBlock(pCoordinate);
        block.setHit();
    }

    private Block getBlock(int[] pCoordinate)
    {
        return aBlocks[pCoordinate[0]][pCoordinate[1]];
    }

    public boolean isFree(int[] pCoordinate)
    {
        return !aBlocks[pCoordinate[0]][pCoordinate[1]].hasShip();
    }

    public boolean beenShot(int[] pCoordinate)
    {
        return aBlocks[pCoordinate[0]][pCoordinate[1]].gotHit();
    }

    public boolean isFree(ArrayList<int[]> coordinates)
    {
        for (int[] coor : coordinates)
        {
            if (!isFree(coor)){return false;}
        }
        return true;
    }
}
