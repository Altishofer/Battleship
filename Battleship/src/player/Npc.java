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
        configureShip(new Carrier());
        for (int i=0; i<2; i++){configureShip(new Battleship());}
        for (int i=0; i<3; i++){configureShip(new Submarine());}
        for (int i=0; i<4; i++){configureShip(new PatrolBoat());}
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

    private void configureShip(Ship pShip) {
        while (true){
            ArrayList<String> coordinates = getCoordinates(pShip.getSize());
            boolean allGood = true;
            if (!ui.GridUtils.coordinatesAreValid(coordinates))
            {
                allGood = false;
            }
            if (allGood && coordinates.size() != pShip.getSize())
            {
                allGood = false;
            }
            if (allGood && !aGrid.isFree(coordinates))
            {
                allGood = false;
            }
            // TODO: check if all coordinates in line (see in GridUtils) and next to each other
            if(allGood)
            {
                pShip.setCoordinates(coordinates);
                aFleet.addShip(pShip);
                aGrid.setShip(pShip);
                System.out.println(String.format("NPC successfully placed %s\n", pShip.toString()));
                return;
            }
        }
    }

    private ArrayList<String> getCoordinates(int shipSize){
        Random rand = new Random();
        ArrayList<String> placement = new ArrayList<>();
        boolean direction = rand.nextBoolean();
        final String upper = "ABCDEFGHIJ";

        if(direction) {
            String letter = Character.toString(upper.charAt(rand.nextInt(9)));
            int randNum = rand.nextInt(10 - (shipSize-1));
            for(int i = 0; i < shipSize; i++){
                String number = Integer.toString(randNum + i);
                String coordinates = letter + number;
                placement.add(coordinates);
            }
        } else {
            String number = Integer.toString(rand.nextInt(10));
            int randNum = rand.nextInt(9 - (shipSize-1));
            for(int i = 0; i < shipSize; i++){
                String letter = Character.toString(upper.charAt(randNum + i));
                String coordinates = letter + number;
                placement.add(coordinates);
            }
        }

        return placement;
    }
}
