package ui;

import block.Block;

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

    public String[][] getOceanGridStrings(){
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

    public void setShip(String pCoordinate, fleet.Ship pShip)
    {
        Block block = getBlock(pCoordinate);
        block.setShip(pShip);
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


    private static boolean isNumeric(char ch) {
        try {
            Double.parseDouble(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int[] convertCoordinates(String coordinate)
    {
        int column;
        int row;
        coordinate = coordinate.toUpperCase();

        if (coordinate.length() > 2)
        {
            throw new IllegalArgumentException("Coordinates must be of length two");
        }
        if (!isNumeric(coordinate.charAt(0)))
        {
            throw new IllegalArgumentException("First char of Coordinates needs to be numeric");
        }

        column = coordinate.charAt(0) - 'A';
        row = coordinate.charAt(1) - '1';

        if (column >= 10 || row >= 10)
        {
            throw new IllegalArgumentException("Coordinates are out of range");
        }

        return new int[] {column, row};
    }


}
