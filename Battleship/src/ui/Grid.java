package ui;

import block.Block;
import fleet.Fleet;
import fleet.Ship;

import java.util.ArrayList;

public class Grid {
    private Block[][] aGrid = new Block[10][10];
    private fleet.Fleet fleet;

    public Grid ()
    {
        for (int i = 0; i < aGrid.length; i++)
        {
            for (int j = 0; j < aGrid[i].length; j++)
            {
                aGrid[i][j] = new Block();
            }
        }
        fleet = new Fleet();
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
        for (String coor : pShip.getCoordinates())
        {
            Block block = getBlock(coor);
            block.setShip(pShip);
        }
    }

    public void setHit(String pCoordinate)
    {
        Block block = getBlock(pCoordinate);
        block.setHit();
    }

    private Block getBlock(String pCoordinate)
    {
        int[] coor = GridUtils.convertCoordinates(pCoordinate);
        return aGrid[coor[0]][coor[1]];
    }

    public boolean isFree(String pCoordinate)
    {
        int[] coor = GridUtils.convertCoordinates(pCoordinate);
        return !aGrid[coor[0]][coor[1]].hasShip();
    }

    public boolean beenShot(String pCoordinate)
    {
        int[] coor = GridUtils.convertCoordinates(pCoordinate);
        return aGrid[coor[0]][coor[1]].gotHit();
    }

    public boolean isFree(ArrayList<String> coordinates)
    {
        for (String coor : coordinates)
        {
            if (!isFree(coor)){return false;}
        }
        return true;
    }

    private boolean allInputCorrect(ArrayList<String> coordinates)
    {
        for (String coor : coordinates)
        {
            if (!GridUtils.coordinatesAreValid(coor)){return false;}
        }
        if (!coordinatesAreFree(coordinates)){return false;}
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

    private boolean coordinatesAreFree(ArrayList<String> coordinates){
        for (String coor : coordinates)
        {
            if (this.isFree(coor))
            {
                return false;
            }
        }
        return true;
    }


}
