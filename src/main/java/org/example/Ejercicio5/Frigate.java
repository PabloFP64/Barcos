package org.example.Ejercicio5;

import java.util.Arrays;

public class Frigate {
    private final int size = 3;
    private int hitsLeft;

    public Frigate() {
        hitsLeft = size;
    }

    public boolean hit(int position) {
        if (position >= size || position < 0) {
            throw new IllegalArgumentException("Invalid position for Frigate");
        }

        hitsLeft--;
        return true;
    }

    public boolean isSunk() {
        return hitsLeft == 0;
    }

    public int getSize() {
        return size;
    }
}


