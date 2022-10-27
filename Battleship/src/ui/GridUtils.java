package ui;

import java.util.ArrayList;

public abstract class GridUtils
{
    private static boolean isNumeric(char ch) {
        try {
            Double.parseDouble(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static  boolean coordinatesAreValid(ArrayList<String> coordinates)
    {
        for (String coor : coordinates) {
            if (!coordinatesAreValid(coor)) { return false;}
        }
        return true;
    }

    public static boolean coordinatesAreValid(String coordinate)
    {
        if (coordinate.length() != 2 || !isNumeric(coordinate.charAt(1)) || isNumeric(coordinate.charAt(0))){return false;}
        int[] convCoor = convertCoordinates(coordinate);
        if (convCoor[0] > 9 || convCoor[1] > 9){return false;}
        return true;
    }

    public static int[] convertCoordinates(String coordinate)
    {
        int column, row;
        coordinate = coordinate.toUpperCase();
        column = coordinate.charAt(0) - 'A';
        row = coordinate.charAt(1) - '0';
        return new int[] {row, column};
    }

    public static ArrayList<int[]> convertCoordinates(ArrayList<String> pCoordinate)
    {
        int column, row;
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i<pCoordinate.size(); i++)
        {
            String tmpCoor = pCoordinate.get(i).toUpperCase();
            column = tmpCoor.charAt(0) - 'A';
            row = tmpCoor.charAt(1) - '0';
            res.add(new int[]{row, column});
        }
        return res;
    }
}