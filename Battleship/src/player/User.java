package player;

import fleet.Ship;
import fleet.ShipFactory;
import fleet.ShipType;
import ui.GridUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player
{
    public User()
    {
        super();
        setFleet();
    }

    @Override
    public void setFleet()
    {
        for (int i = 0; i < ShipType.CARRIER.quantity; i++) {
            printOceanGrid();
            configureShip(ShipFactory.getShip(ShipType.CARRIER));
        }

        for (int i = 0; i < ShipType.BATTLESHIP.quantity; i++) {
            printOceanGrid();
            configureShip(ShipFactory.getShip(ShipType.BATTLESHIP));
        }
        for (int i = 0; i < ShipType.SUBMARINE.quantity; i++) {
            printOceanGrid();
            configureShip(ShipFactory.getShip(ShipType.SUBMARINE));
        }
        for (int i = 0; i < ShipType.PATROLBOAT.quantity; i++) {
            printOceanGrid();
            configureShip(ShipFactory.getShip(ShipType.PATROLBOAT));
        }
    }

    @Override
    public int[] nextMove()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(String.format("Type a single coordinate to shoot: "));
        while (true)
        {
            String coordinate = scanner.nextLine();
            if (ui.GridUtils.coordinatesAreValidString(coordinate)){
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
            if (allGood && !ui.GridUtils.coordinatesAreValidString(coordinates))
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

    public void printOceanGrid(){
        String[][] oceanGrid = aGrid.getOceanGridStrings();
        GridUtils.printGrid(oceanGrid, new String(), GridUtils.TITLE_OCEAN_GRID);
    }
}
