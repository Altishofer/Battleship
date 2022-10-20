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


    public Fleet(Grid grid)
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("define BATTLESHIP with 2 coordinates by typing 2 valid coordinates");

        String line = scanner.nextLine();
        ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(line.split(",")));
        if (ui.GridUtils.coordinatesAreValid(coordinates))
        {
            grid.setShip(coordinates);
        }


    }

    private void createShip()
    {

    }


}
