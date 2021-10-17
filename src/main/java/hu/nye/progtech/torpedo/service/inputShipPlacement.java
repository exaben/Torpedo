package hu.nye.progtech.torpedo.service;

import java.util.Scanner;

import hu.nye.progtech.torpedo.model.Locations;
import hu.nye.progtech.torpedo.model.OceanVO;

public class inputShipPlacement extends PlayerShipPlacement {
    private static Scanner input;
    private Scanner scannerInput() {
        if (input == null) {
            input = new Scanner(System.in);
        }
        return input;
    }
    public inputShipPlacement(OceanVO ocean) {
        super(ocean);
    }
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Locations requestShipCoordinates(int shipNumber) {
        printMessage(String.format("Ird be a hajo helyzetet %s: ", shipNumber));
        Locations locations = Locations.parseLocation(scannerInput().nextLine());
        return locations;
    }

}
