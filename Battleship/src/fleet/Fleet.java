package fleet;

import ui.Grid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fleet
{
    ArrayList<Ship> fleet;

    public Fleet()
    {
        System.out.println("DEFINE FLEET by following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");

    }

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

    private Ship createShip(int size)
    {
        System.out.println(String.format("Define BATTLESHIP with %d coordinates by typing %d valid coordinates seperated by comas", size, size));
        Scanner scanner = new Scanner(System.in);
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
