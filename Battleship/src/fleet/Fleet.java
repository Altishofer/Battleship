package fleet;

import ui.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fleet
{
    ArrayList<Ship> fleet;

    public boolean gameLost(){
        for (Ship ship : fleet)
        {
            if (!ship.hasSunk())
            {
                return false;
            }
        }
        return true;
    }


    public void Fleet(Grid grid)
    {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("DEFINE FLEET by following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");
        System.out.println("define BATTLESHIP with 2 coordinates by typing 2 valid coordinates");

        String line = scanner.nextLine();
        ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(line.split(",")));
        if (allInputCorrect(coordinates))
        {
            grid.setShip(coordinates);
        }


    }

    private void createShip()
    {

    }

    private boolean allInputCorrect(ArrayList<String> coordinates)
    {
        for (String coor : coordinates)
        {
            if (!Grid.coordinatesAreValid(coor))
            {
                return false;
            }
        }
        if (!coordinatesAreFree(coordinates))
        {
            return false;
        }
        if (!coordinatesFormLine(coordinates))
        {
            return false;
        }
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
            if (!board.npcGrid.isFree(coor))
            {
                return false;
            }
        }
        return true;
    }
}
