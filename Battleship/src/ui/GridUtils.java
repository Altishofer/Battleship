package ui;

import java.util.ArrayList;

public abstract class GridUtils {
    private static boolean isNumeric(char ch) {
        try {
            Double.parseDouble(String.valueOf(ch));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //TODO: check if that many "coordinatesAreValidType" methods are necessary
    public static  boolean coordinatesAreValid(ArrayList<String> coordinates)
    {
        for (String coor : coordinates) {
            if (!coordinatesAreValid(coor)) { return false;}
        }
        return true;
    }

    public static boolean coordinatesAreValid(String coordinate)
    {
        if (
                coordinate.length() != 2 ||
                !isNumeric(coordinate.charAt(1)) ||
                isNumeric(coordinate.charAt(0))
        ){return false;}
        int[] convCoor = convertCoordinates(coordinate);
        if (convCoor[0] > 9 || convCoor[1] > 9){return false;}
        return true;
    }

    public static int[] convertCoordinates(String coordinate) {
        int column, row;
        coordinate = coordinate.toUpperCase();
        column = coordinate.charAt(0) - 'A';
        row = coordinate.charAt(1) - '0';
        return new int[]{row, column};
    }

    public static ArrayList<int[]> convertCoordinates(ArrayList<String> pCoordinate) {
        int column, row;
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < pCoordinate.size(); i++) {
            String tmpCoor = pCoordinate.get(i).toUpperCase();
            column = tmpCoor.charAt(0) - 'A';
            row = tmpCoor.charAt(1) - '0';
            res.add(new int[]{row, column});
        }
        return res;
    }

    public static boolean coordinatesInLine(ArrayList<int[]> xyCoordinates) {
        int[] startPoint = xyCoordinates.get(0);
        int[] endPoint = xyCoordinates.get(1);

        if (startPoint[0] == endPoint[0] || startPoint[1] == endPoint[1]) {return true;}
        return false;
    }

    //TODO: remove if not needed
        /*
        int startRow = xyCoordinates.get(0)[0];
        int startCol = xyCoordinates.get(0)[1];

        boolean consecutiveRow = true;
        boolean consecutiveCol = true;

        int index = 0;

        for (int[] coor : xyCoordinates){
            if (coor[0] - index != startRow) {
                consecutiveRow = false;
                if (coor[0] != startRow){
                    return false;
                }
            }
            if (coor[1] - index != startCol) {
                consecutiveCol = false;
                if (coor[1] != startCol){
                    return false;
                }
            }

            index += 1;
        }

        return (consecutiveCol ^ consecutiveRow);
    }*/

    public static void getConsecutiveCoordinates(ArrayList<int[]> xyCoordinates) {
        int[] startPoint = xyCoordinates.get(0);
        int[] endPoint = xyCoordinates.get(1);

        if (startPoint[0] == endPoint[0]) {
            if (startPoint[1] <= endPoint[1]) {
                for (int i = 1; i < endPoint[1] - startPoint[1]; i++) {
                    int[] adder = new int[]{startPoint[0], startPoint[1] + i};
                    xyCoordinates.add(i, adder);
                }
            } else {
                for (int i = 1; i < startPoint[1] - endPoint[1]; i++) {
                    int[] adder = new int[]{startPoint[0], endPoint[1] + i};
                    xyCoordinates.add(1, adder);
                }
            }
        }
        if (startPoint[1] == endPoint[1]) {
            if (startPoint[0] <= endPoint[0]){
                for (int i = 1; i < endPoint[0] - startPoint[0]; i++) {
                    int[] adder = new int[]{startPoint[0] + i, startPoint[1]};
                    xyCoordinates.add(i, adder);
                }
            } else {
                for (int i = 1; i < startPoint[0] - endPoint[0]; i++) {
                    int[] adder = new int[]{endPoint[0] + i, startPoint[1]};
                    xyCoordinates.add(1, adder);
                }
            }
        }
    }
}