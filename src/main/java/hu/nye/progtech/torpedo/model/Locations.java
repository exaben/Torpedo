package hu.nye.progtech.torpedo.model;

public class Locations {
    private static String location;
    private final int cX;
    private final int cY;
    public Locations(int x, int y) {
        cX = x;
        cY = y;
    }
    public int getX() {
        return cX;
    }

    public int getY() {
        return cY;
    }
    public static Locations INAPP_LOC = new Locations(-1,-1);

    public static Locations parseLocation(String location) {
        location = location.toUpperCase();

        if (location.length() <= 3) {

            char letter = location.charAt(0);
            String number = location.substring(1);

            int x = (letter - 'A');
            try {
                int y = Integer.parseInt(number) - 1;
                return new Locations(x, y);
            }
            catch (NumberFormatException e) {
                return Locations.INAPP_LOC;
            }
        }
        else {
            return Locations.INAPP_LOC;
        }
    }
}
