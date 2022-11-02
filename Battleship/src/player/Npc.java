package player;

import fleet.ShipFactory;
import fleet.Ship;
import fleet.ShipType;
import ui.GridUtils;
import java.util.ArrayList;
import java.util.Random;

public class Npc extends Player
{
    public Npc()
    {
        super();
        setFleet();
    }

    @Override
    public int[] nextMove()
    {
        final String upper = "ABCDEFGHIJ";
        Random ran = new Random();
        while (true)
        {
            int numberX = ran.nextInt(10);
            int numberY = ran.nextInt(10);
            return new int[]{numberY, numberX};
        }
    }

    @Override
    public void setFleet()
    {
        for (int i=0; i<ShipType.CARRIER.quantity; i++){ configureShip(ShipFactory.getShip(ShipType.CARRIER));}
        for (int i=0; i<ShipType.BATTLESHIP.quantity; i++){configureShip(ShipFactory.getShip(ShipType.BATTLESHIP));}
        for (int i=0; i<ShipType.SUBMARINE.quantity; i++){configureShip(ShipFactory.getShip(ShipType.SUBMARINE));}
        for (int i=0; i<ShipType.PATROLBOAT.quantity; i++){configureShip(ShipFactory.getShip(ShipType.PATROLBOAT));}
    }

    // TODO: remove debug
    protected void configureShip(Ship pShip) {
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
            ArrayList<int[]> xyCoordinates = GridUtils.convertCoordinates(coordinates);
            if (allGood && !aGrid.isFree(xyCoordinates))
            {
                allGood = false;
            }
            // TODO: check if all coordinates in line (see in GridUtils) and next to each other
            if(allGood)
            {
                pShip.setCoordinates(xyCoordinates);
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
