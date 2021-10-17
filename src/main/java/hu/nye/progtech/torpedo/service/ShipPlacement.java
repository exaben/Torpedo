package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Locations;
import hu.nye.progtech.torpedo.model.OceanVO;

public abstract class ShipPlacement implements ShipInt {
    protected OceanVO anOcean;
    public ShipPlacement(OceanVO ocean) {
        anOcean = ocean;
    }

    protected abstract Locations requestShipCoordinates(int shipNumber);
    protected abstract boolean placeSingleShip(Locations shipLocation);
    @Override
    public void placeShips() {
        Locations shipLocation;
        for (int i = 0; i < ShipInt.MAX_SHIPS; i++) {
            do {
                shipLocation = requestShipCoordinates(i + 1);
                boolean shipWasAdded;
                shipWasAdded = placeSingleShip(shipLocation);
                if (shipWasAdded) {
                    break;
                }
            } while (!anOcean.isValidShipLocation(shipLocation));
        }
    }
}
