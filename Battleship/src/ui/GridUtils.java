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
        if (xyCoordinates.size() != 2){return false;}
        int[] startPoint = xyCoordinates.get(0);
        int[] endPoint = xyCoordinates.get(1);

        if (startPoint[0] == endPoint[0] || startPoint[1] == endPoint[1]) {return true;}
        return false;
    }

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
            if (startPoint[0] <= endPoint[0]) {
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
    public static final String TITLE_FINAL_NPC_GRID = "===== NPC GRID =====";
    public static final String TITLE_OCEAN_GRID = "===== OCEAN  GRID =====";
    public static final String TITLE_TARGET_GRID = "===== TARGET GRID =====";
    public static final String LETTER_COORDINATES = "  A B C D E F G H I J";
    public static final String DELIMITER_1 = " +-+-+-+-+-+-+-+-+-+-+";
    public static final String DELIMITER_2 = "=======================";
    public static final String DELIMITER_3 = "\n-----------------------\n";

    public static void printGrid(String[][] board, String delimiter, String title)
    {
        System.out.println(title);
        System.out.println(GridUtils.LETTER_COORDINATES);
        System.out.println(GridUtils.DELIMITER_1);
        for (Integer i=0; i<board.length; i++)
        {
            String line = i.toString();
            for (Integer j = 0; j<board[i].length; j++)
            {
                line += "|" + board[i][j];
            }
            line += "|" + i.toString();
            System.out.println(line);
        }
        System.out.println(GridUtils.DELIMITER_1);
        System.out.println(GridUtils.LETTER_COORDINATES);
        System.out.println(GridUtils.DELIMITER_2);
        System.out.println(delimiter);
    }
}