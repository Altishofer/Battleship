package player;

import fleet.Ship;
import fleet.ShipFactory;
import ui.GridUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player
{
    public User()
    {
        super();
        System.out.println("define your fleet by the following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");
        setFleet();
    }

    @Override
    public void setFleet()
    {
        configureShip(ShipFactory.getShip("Carrier"));
        for (int i=0; i<2; i++){configureShip(ShipFactory.getShip("Battleship"));}
        for (int i=0; i<3; i++){configureShip(ShipFactory.getShip("Submarine"));}
        for (int i=0; i<4; i++){configureShip(ShipFactory.getShip("Patrol Boat"));}

        /*configureShip(ShipFactory.getShip("Carrier"), "A0,F0");
        configureShip(ShipFactory.getShip("Submarine"), "A2,C2");
        configureShip(ShipFactory.getShip("Patrol Boat"), "A1,B1");
        configureShip(ShipFactory.getShip("Battleship"), new String());*/
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
                int[] xyCoordinate = GridUtils.convertCoordinates(coordinate);
                return xyCoordinate;
            }
            System.out.println(String.format("The given coordinate (%s) is not valid, try again!", coordinate));
        }
    }

    protected void configureShip(Ship pShip)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("Set up %s with length %s by entering valid start and end coordinates of your ship: ", pShip.toString(), pShip.getSize()));
        while (true){
            String line;
            Boolean allGood = true;
            ArrayList<String> coordinates = new ArrayList<String>();
            ArrayList<int[]> xyCoordinates = new ArrayList<int[]>();

            /*if (debug.isEmpty())
            {
                line = scanner.nextLine();
            }
            else {
                line = debug;
            }
            */

            line = scanner.nextLine();

            if (line != null && !line.isEmpty())
            {
                line = line.replaceAll("\\s+","");
                coordinates = new ArrayList<String>(List.of(line.split(",")));
            }
            else
            {
                System.out.println("Given coordinates are empty!");
                allGood = false;
            }
            if (allGood && !ui.GridUtils.coordinatesAreValid(coordinates))
            {
                System.out.println("Coordinates are not valid!");
                allGood = false;
            }
            if (allGood) {
                xyCoordinates = ui.GridUtils.convertCoordinates(coordinates);
            }
            if (allGood && !ui.GridUtils.coordinatesInLine(xyCoordinates))
            {
                System.out.println("Coordinates are not in a horizontal or vertical line!");
                allGood = false;
            }
            if (allGood) {
                ui.GridUtils.getConsecutiveCoordinates(xyCoordinates);
            }
            if (allGood && xyCoordinates.size() != pShip.getSize())
            {
                System.out.println(String.format("Coordinates do not match length %s of %s!", pShip.getSize(), pShip.toString()));
                allGood = false;
            }
            if (allGood && !aGrid.isFree(xyCoordinates))
            {
                System.out.println("Some coordinates are already occupied!");
                allGood = false;
            }
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
}
