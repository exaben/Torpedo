package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Locations;
import hu.nye.progtech.torpedo.model.OceanVO;

public abstract class PlayerShipPlacement extends ShipPlacement {
    public abstract void printMessage(String message);
    public PlayerShipPlacement(OceanVO ocean) {
        super(ocean);
    }
    @Override
    protected boolean placeSingleShip(Locations shipLocation) {

        if (anOcean.isShipAtLocation(shipLocation)) {
            printMessage("Itt mar van hajod");
        } else {
            if (!anOcean.isLocAtGrid(shipLocation)) {
                printMessage("Nem jol helyezted el");
            }
            else {
                anOcean.addShip(shipLocation.getX(), shipLocation.getY());
                return true;
            }
        }

        return false;
    }

}
