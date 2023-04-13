package org.example.Ejercicio5;

import org.example.Point;

import java.util.Arrays;

public class Battleship {
    private final int size = 5;
    private int hitsLeft;
    private boolean[] isIsolated;

    public Battleship(Point point, String orientation) {
        hitsLeft = size;
        isIsolated = new boolean[size];
        Arrays.fill(isIsolated, true);
    }

    public boolean hit(int position) {
        if (position >= size || position < 0) {
            throw new IllegalArgumentException("Invalid position for Battleship");
        }

        if (isIsolated[position]) {
            isIsolated[position] = false;
            hitsLeft--;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSunk() {
        return hitsLeft == 0;
    }

    public int getSize() {
        return size;
    }
}


