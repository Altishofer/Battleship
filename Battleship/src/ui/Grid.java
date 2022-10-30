package ui;

import block.Block;
import fleet.Fleet;
import fleet.Ship;

import java.util.ArrayList;

public class Grid {
    private final Block[][] aGrid = new Block[10][10];
    private final fleet.Fleet aFleet;

    public Grid ()
    {
        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                aGrid[i][j] = new Block();
            }
        }
        aFleet = new Fleet();
    }

    public String[][] getOceanGridStrings(){
        String[][] copyGrid = new String[10][10];
        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                copyGrid[i][j] = aGrid[i][j].toStringOcean();
            }
        }
        return copyGrid;
    }

    public String[][] getFinalGridStrings(){
        String[][] copyGrid = new String[10][10];
        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                copyGrid[i][j] = aGrid[i][j].toStringFinal();
            }
        }
        return copyGrid;
    }

    public String[][] getTargetGridStrings(){
        String[][] copyGrid = new String[10][10];

        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                copyGrid[i][j] = aGrid[i][j].toStringTarget();
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
        return aGrid[pCoordinate[0]][pCoordinate[1]];
    }

    public boolean isFree(int[] pCoordinate)
    {
        return !aGrid[pCoordinate[0]][pCoordinate[1]].hasShip();
    }

    public boolean beenShot(int[] pCoordinate)
    {
        return aGrid[pCoordinate[0]][pCoordinate[1]].gotHit();
    }

    public boolean isFree(ArrayList<int[]> coordinates)
    {
        for (int[] coor : coordinates)
        {
            if (!isFree(coor)){return false;}
        }
        return true;
    }

    // TODO: delet if not used, else replace
    private boolean allInputCorrect(ArrayList<String> coordinates)
    {
        for (String coor : coordinates)
        {
            if (!GridUtils.coordinatesAreValid(coor)){return false;}
        }
        ArrayList<int[]> yxCoordinates = GridUtils.convertCoordinates(coordinates);
        if (!coordinatesAreFree(yxCoordinates)){return false;}
        if (!coordinatesFormLine(coordinates)) {return false;}
        return true;
    }
    private boolean coordinatesFormLine(ArrayList<String> coordinates){
        //TODO: check if all coordinates are without gaps between them
        String row =  String.valueOf(coordinates.get(0).charAt(0));
        String column = String.valueOf(coordinates.get(0).charAt(1));
        boolean allInLine = true;
        boolean allInRow = true;
        for (String coor : coordinates)
        {
            if (!coor.startsWith(row))
            {
                allInLine = false;
            }
            if (!coor.startsWith(column))
            {
                allInRow = false;
            }
        }
        return allInLine || allInRow;
    }

    private boolean coordinatesAreFree(ArrayList<int[]> coordinates){
        for (int[] coor : coordinates)
        {
            if (this.isFree(coor))
            {
                return false;
            }
        }
        return true;
    }
}
