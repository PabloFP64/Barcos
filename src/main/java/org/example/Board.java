package org.example;

public class Board {
    private final int size = 10;
    private Ship[][] ships;

    public Board() {
        ships = new Ship[size][size];
    }

    public boolean addShip(Ship ship, int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IllegalArgumentException("Invalid position for ship");
        }

        if (x + ship.getSize() > size) {
            return false;
        }

        for (int i = 0; i < ship.getSize(); i++) {
            if (ships[x + i][y] != null) {
                return false;
            }
        }

        for (int i = 0; i < ship.getSize(); i++) {
            ships[x + i][y] = ship;
        }

        return true;
    }

    public boolean hit(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IllegalArgumentException("Invalid position for ship");
        }

        if (ships[x][y] == null) {
            return false;
        }

        ships[x][y].hit(x - ships[x][y].getX());
        return true;
    }

    public boolean allSunk() {
        for (Ship[] row : ships) {
            for (Ship ship : row) {
                if (ship != null && !ship.isSunk()) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Ship[] row : ships) {
            for (Ship ship : row) {
                if (ship == null) {
                    sb.append(" ");
                } else {
                    sb.append(ship.toString());
                }

}
