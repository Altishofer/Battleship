package player;

import fleet.Ship;
import fleet.ShipFactory;
import ui.Grid;
import ui.GridUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User extends Player
{
    public User()
    {
        super();
        System.out.println("define your fleet by following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");
        setFleet();
    }

    // TODO: remove or adapt return of Grid for encapsulation
    public Grid getGrid()
    {
        return aGrid;
    }

    @Override
    public void setFleet()
    {
        /*
        configureShip(ShipFactory.getShip("Carrier"));
        for (int i=0; i<2; i++){configureShip(ShipFactory.getShip("Battleship");}
        for (int i=0; i<3; i++){configureShip(ShipFactory.getShip("Submarine"));}
        for (int i=0; i<4; i++){configureShip(ShipFactory.getShip("Patrol Boat"));}
        */
        configureShip(ShipFactory.getShip("Carrier"), "A0,B0,C0,D0,E0,F0");
//        configureShip(ShipFactory.getShip("Battleship"), "A1,B1,C1,D1");
//        configureShip(ShipFactory.getShip("Submarine"), "A2,B2,C2");
//        configureShip(ShipFactory.getShip("Patrol Boat"), new String());
    }

    private void configureShip(Ship pShip, String debug)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("Set up %s by typing %d valid coordinates: ", pShip.toString(), pShip.getSize()));
        while (true){
            String line;
            //TODO: remove debug features
            if (debug.isEmpty())
            {
                line = scanner.nextLine();
            }
            else {
                line = debug;
            }
            ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(line.split(",")));
            Boolean allGood = true;

            if (!ui.GridUtils.coordinatesAreValid(coordinates))
            {
                System.out.println("Coordinates are not valid!");
                allGood = false;
            }
            ArrayList<int[]> xyCoordinates = GridUtils.convertCoordinates(coordinates);
            if (allGood && coordinates.size() != pShip.getSize())
            {
                System.out.println("Number of coordinates is not correct!");
                allGood = false;
            }
            if (allGood && !aGrid.isFree(xyCoordinates))
            {
                System.out.println("Some coordinates are already occupied!");
                allGood = false;
            }
            // TODO: check if all coordinates in line (see in GridUtils) and next to each other
            if(allGood)
            {
                pShip.setCoordinates(xyCoordinates);
                aFleet.addShip(pShip);
                aGrid.setShip(pShip);
                System.out.println(String.format("All coordinates are valid -> %s was created\n", pShip.toString()));
                return;
            }
            System.out.println("Please try again");
        }
    }

    @Override
    public boolean defeated()
    {
        return aFleet.defeated();
    }

    @Override
    public int[] nextMove()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("Type a single coordinate to shoot: "));
        while (true)
        {
            String coordinate = scanner.nextLine();
            if (ui.GridUtils.coordinatesAreValid(coordinate)){
                return GridUtils.convertCoordinates(coordinate);
            }
            System.out.println(String.format("The given coordinate (%s) is not valid, try again!", coordinate));
        }
    }
}
