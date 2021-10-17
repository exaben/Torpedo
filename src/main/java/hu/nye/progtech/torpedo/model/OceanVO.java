package hu.nye.progtech.torpedo.model;

public class OceanVO {
    private static final int LINE_SIZE = 7;
    public enum Square {
        Hit,
        Miss,
        Empty
    }
    private Square[][] playground;
    private boolean[][] shipLocations;
    public int size() {
        return playground.length;
    }
    private void initGrid() {
        int size = size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playground[i][j] = Square.Empty;
            }
        }
    }
    public Square atSquare(int x, int y) {
        return playground[x][y];
    }
    public OceanVO(int size) throws IllegalArgumentException {
        if (size >= LINE_SIZE) {
            playground = new Square[size][size];
            shipLocations = new boolean[size][size];
            initGrid();
        }
        else {
            throw new IllegalArgumentException("A jatek ter nem megfelelo!");
        }
    }
    public boolean isLocAtGrid(Locations l) {
        int playgroudSize = size();
        int x = l.getX();
        int y = l.getY();
        return l != Locations.INAPP_LOC && x < playgroudSize && x >= 0 && y < playgroudSize && y >= 0;
    }
    public boolean isShipAtLocation(int x, int y) {
        if (!isLocAtGrid(new Locations(x, y))) {
            return false;
        }
        return shipLocations[x][y];
    }
    public boolean isShipAtLocation(Locations l) {
        return isShipAtLocation(l.getX(), l.getY());
    }
    public boolean addShip(Locations location) {
        int x, y;
        x = location.getX();
        y = location.getY();
        if (isShipAtLocation(location)) {
            return false;
        }
        shipLocations[x][y] = true;
        return true;
    }
    public boolean addShip(int x, int y) {
        return addShip(new Locations(x, y));
    }
    public boolean isValidShipLocation(Locations l) {
        int playgroundSize = size();
        int x = l.getX();
        int y = l.getY();
        return isLocAtGrid(l) && !isShipAtLocation(l);
    }

}
