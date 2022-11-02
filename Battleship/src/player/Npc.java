package player;

import fleet.ShipFactory;
import fleet.Ship;
import fleet.ShipType;

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
        configureShip(ShipFactory.getShip(ShipType.CARRIER));
        for (int i=0; i<2; i++)
        {
            configureShip(ShipFactory.getShip(ShipType.BATTLESHIP));
        }
        for (int i=0; i<3; i++)
        {
            configureShip(ShipFactory.getShip(ShipType.SUBMARINE));
        }
        for (int i=0; i<4; i++)
        {
            configureShip(ShipFactory.getShip(ShipType.PATROLBOAT));
        }
    }

    protected void configureShip(Ship pShip) {
        while (true){
            ArrayList<int[]> xyCoordinates = getCoordinates(pShip.getSize());
            boolean allGood = true;
            if (!ui.GridUtils.coordinatesAreValidInt(xyCoordinates))
            {
                allGood = false;
            }
            if (allGood && !ui.GridUtils.coordinatesInLine(xyCoordinates))
            {
                allGood = false;
            }
            if (allGood) {
                ui.GridUtils.getConsecutiveCoordinates(xyCoordinates);
            }
            if (allGood && xyCoordinates.size() != pShip.getSize())
            {
                allGood = false;
            }
            if (allGood && !aGrid.isFree(xyCoordinates))
            {
                allGood = false;
            }
            if(allGood)
            {
                pShip.setCoordinates(xyCoordinates);
                aFleet.addShip(pShip);
                aGrid.setShip(pShip);
                System.out.println(String.format("NPC placed a %s\n", pShip.toString()));
                return;
            }
        }
    }

    private ArrayList<int[]> getCoordinates(int shipSize){
        Random rand = new Random();
        boolean direction = rand.nextBoolean();

        if(direction) {
            int xCoor = rand.nextInt(10);
            int yCoor = rand.nextInt(10 - (shipSize-1));
            int[] startPoint = new int[] {xCoor, yCoor};
            int[] endPoint = new int[] {xCoor, yCoor + shipSize-1};
            ArrayList<int[]> placement = new ArrayList<int[]>();
            placement.add(startPoint);
            placement.add(endPoint);
            return placement;
        }

        int xCoor = rand.nextInt(10 - (shipSize-1));
        int yCoor = rand.nextInt(10);
        int[] startPoint = new int[] {xCoor, yCoor};
        int[] endPoint = new int[] {xCoor + shipSize-1, yCoor};
        ArrayList<int[]> placement = new ArrayList<int[]>();
        placement.add(startPoint);
        placement.add(endPoint);
        return placement;
    }
}
