package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.model.OceanVO;

public class OceanPrint {
    private OceanVO oOcean;
    private boolean showShips;

    public OceanPrint(OceanVO ocean, boolean showShips) {
        oOcean = ocean;
        showShips = showShips;
    }

    public void render() {
        int size = oOcean.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%c ", squareToMarking(i, j));
            }
            System.out.println();
        }
    }

    public char squareToMarking(int x, int y) {
        OceanVO.Square square = oOcean.atSquare(x, y);
        char retChar = '!';
        switch (square) {
            case Hit:
                retChar = '+';
                break;

            case Miss:
                retChar = 'X';
                break;

            case Empty:
                retChar = '^';
                break;

        }
        if (showShips && square != OceanVO.Square.Hit && oOcean.isShipAtLocation(x, y)) {
            retChar = '-';
        }
        return retChar;
    }
}
