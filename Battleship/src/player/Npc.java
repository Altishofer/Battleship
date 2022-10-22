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
import java.util.Random;

public class Npc extends Player
{
    public Npc()
    {
        super();
        setFleet();
    }
    @Override
    public String nextMove()
    {
        final String upper = "ABCDEFGHIJ";
        Random ran = new Random();
        while (true)
        {
            String letter = Character.toString(upper.charAt(ran.nextInt(9)));
            String number = Integer.toString(ran.nextInt(10));
            String coordinate = letter + number;
            if (ui.GridUtils.coordinatesAreValid(coordinate)){return coordinate;}
        }
    }

    @Override
    public void setFleet()
    {
        configureShip(new Carrier(), "A0,B0,C0,D0,E0,F0");
        configureShip(new Battleship(), "A1,B1,C1,D1");
        configureShip(new Submarine(), "A2,B2,C2");
        configureShip(new PatrolBoat(), "A3,B3");
    }

    @Override
    public boolean defeated()
    {
        return aFleet.defeated();
    }

    // TODO: encapsulation
    public Grid getGrid()
    {
        return aGrid;
    }

    private void configureShip(Ship pShip, String debug)
    {
        String line = debug;
        ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(line.split(",")));
        //ui.GridUtils.coordinatesAreValid(coordinates) && aGrid.isFree(coordinates))
        pShip.setCoordinates(coordinates);
        aFleet.addShip(pShip);
        aGrid.setShip(pShip);
    }
}
