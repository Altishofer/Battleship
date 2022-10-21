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

public class User implements Player{

    private final Fleet aFleet = new Fleet();
    private final Grid aGrid = new Grid();

    public User()
    {
        System.out.println("DEFINE FLEET by following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");
        setFleet();
    }

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
        configureShip(new PatrolBoat(), "A3,B3");
    }

    private void configureShip(Ship pShip, String debug)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Set up %s by typing %d valid coordinates", pShip.toString(), pShip.getSize()));
        while (true){
            //String line = scanner.nextLine();
            String line = debug;
            ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(line.split(",")));
            if(ui.GridUtils.coordinatesAreValid(coordinates) && aGrid.isFree(coordinates) && coordinates.size() == pShip.getSize())
            {

                pShip.setCoordinates(coordinates);
                aFleet.addShip(pShip);
                aGrid.setShip(pShip);
                return;
            }
            System.out.println("Given Input is not correct, please try again");
        }
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
