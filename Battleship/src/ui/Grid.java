package ui;

import block.Block;

import java.util.ArrayList;

public class Grid {
    private Block[][] aGrid = new Block[10][10];

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

    public void setShip(ArrayList<String> pCoordinate, fleet.Ship pShip)
    {
        for (String coor : pCoordinate)
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
        int[] coor = convertCoordinates(pCoordinate);
        return aGrid[coor[0]][coor[1]];
    }

    public boolean isFree(String pCoordinate)
    {
        int[] coor = convertCoordinates(pCoordinate);
        return !aGrid[coor[0]][coor[1]].hasShip();
    }


    private static boolean isNumeric(char ch) {
        try {
            Double.parseDouble(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean coordinatesAreValid(String coordinate)
    {
        if (coordinate.length() != 2 && isNumeric(coordinate.charAt(0)))
        {
            return false;
        }
        int[] convCoor = convertCoordinates(coordinate);
        if (convCoor[0] > 9 || convCoor[1] > 9)
        {
            return false;
        }
        return true;
    }

    public static int[] convertCoordinates(String coordinate)
    {
        int column;
        int row;
        coordinate = coordinate.toUpperCase();

        column = coordinate.charAt(0) - 'A';
        row = coordinate.charAt(1) - '1';

        return new int[] {column, row};
    }


}
