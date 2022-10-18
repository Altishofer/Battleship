package ui;

import block.Block;
import block.BlockType;

import java.util.ArrayList;
import java.util.List;

public abstract class Grid
{
    private BlockType[][] aGrid = new BlockType[10][10];

    public BlockType getBlockTypeByCoordinate(String pCoordinate)
    {
        int[] coordinates = convertCoordinates(pCoordinate);
        return aGrid[coordinates[0]][coordinates[1]];
    }

    public void setBlockTypeByCoordinate(String pCoordinate, BlockType type)
    {
        int[] coordinates = convertCoordinates(pCoordinate);
        aGrid[coordinates[0]][coordinates[1]] = type;

    }

    private static boolean isNumeric(char ch) {
        try {
            Double.parseDouble(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static int[] convertCoordinates(String coordinate)
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
