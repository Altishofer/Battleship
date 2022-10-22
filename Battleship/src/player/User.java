package player;

import fleet.Fleet;
import fleet.Ship;
import fleet.ShipTypes.Battleship;
import fleet.ShipTypes.Carrier;
import fleet.ShipTypes.PatrolBoat;
import fleet.ShipTypes.Submarine;
import ui.Grid;

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
        for (int i=0; i<1; i++){configureShip(new Carrier());}
        for (int i=0; i<2; i++){configureShip(new Battleship());}
        for (int i=0; i<3; i++){configureShip(new Submarine());}
        for (int i=0; i<4; i++){configureShip(new PatrolBoat());}
         */
        configureShip(new Carrier(), "A0,B0,C0,D0,E0,F0");
        configureShip(new Battleship(), "A1,B1,C1,D1");
        configureShip(new Submarine(), "A2,B2,C2");
        for (int i=0; i<4; i++){configureShip(new PatrolBoat(), new String());}
    }

    private void configureShip(Ship pShip, String debug)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Set up %s by typing %d valid coordinates", pShip.toString(), pShip.getSize()));
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
                System.out.println("coordinates are not valid");
                allGood = false;
            }
            if (allGood && coordinates.size() != pShip.getSize())
            {
                System.out.println("number of coordinates is not correct");
                allGood = false;
            }
            if (allGood && !aGrid.isFree(coordinates))
            {
                System.out.println("some coordinates are already occupied");
                allGood = false;
            }
            // TODO: check if all coordinates in line (see in GridUtils) and next to each other
            if(allGood)
            {
                pShip.setCoordinates(coordinates);
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
    public String nextMove()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Type a single coordinate to shoot"));
        while (true)
        {
            String coordinate = scanner.nextLine();
            if (ui.GridUtils.coordinatesAreValid(coordinate)){return coordinate;}
            System.out.println(String.format("The given coordinate (%s) is not valid, try again! ;)", coordinate));
        }
    }
}
