package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.OceanVO;
import hu.nye.progtech.torpedo.service.RandomShipPlacement;
import hu.nye.progtech.torpedo.service.ShipInt;
import hu.nye.progtech.torpedo.service.inputShipPlacement;
import hu.nye.progtech.torpedo.ui.OceanPrint;

public class Main {
    public static void main(String[] args) {
        final int gridSize = 10;
        OceanVO oceanField = new OceanVO(gridSize);

        System.out.printf("Van %d hajod, helyezd el oket %n", ShipInt.MAX_SHIPS);

        ShipInt playerPlacement = new inputShipPlacement(oceanField);
        playerPlacement.placeShips();

        System.out.println("A jatekos tablazata:");
        OceanPrint playerDisplay = new OceanPrint(oceanField, true);
        playerDisplay.render();

        OceanVO computerField = new OceanVO(gridSize);

        ShipInt computerDistributor = new RandomShipPlacement(computerField);
        computerDistributor.placeShips();

        System.out.println();
        System.out.println("A szamitogep tablazata:");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        OceanPrint computerDisplay = new OceanPrint(computerField, showComputerShips);
        computerDisplay.render();
    }
}

