package hu.nye.progtech.torpedo.service;

import java.util.Random;

import hu.nye.progtech.torpedo.model.Locations;
import hu.nye.progtech.torpedo.model.OceanVO;

public class RandomShipPlacement extends ShipPlacement {
    public RandomShipPlacement(OceanVO ocean) {
        super(ocean);
    }

    @Override
    protected Locations requestShipCoordinates(int shipNumber) {
        int gridSize = anOcean.size();
        Random r = new Random();
        int randomX = r.nextInt(gridSize);
        int randomY = r.nextInt(gridSize);

        return new Locations(randomX, randomY);
    }

    @Override
    protected boolean placeSingleShip(Locations shipLocation) {
        return anOcean.addShip(shipLocation);
    }
}
