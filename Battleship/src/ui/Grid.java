package ui;

import block.OceanBlock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Grid implements Iterable
{

    public Iterator<OceanBlock> iterator()
    {
        return new CustomIteratorGrid(this);
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

class CustomIteratorGrid implements Iterator<OceanBlock>
{
    int curr = 0;
    OceanGrid aGrid;

    public CustomIteratorGrid(OceanGrid pGrid)
    {
        aGrid = pGrid;
    }
    public boolean hasNext()
    {
        if (curr >= 81){
            return false;
        }
        return true;
    }
    public OceanBlock next()
    {
        int tempX = curr % 9;
        int tempY = curr / 9;
        return aGrid[tempY][tempX].type;
    }

    public  void remove(){}


}
