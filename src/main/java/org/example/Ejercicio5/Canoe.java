package org.example.Ejercicio5;

public class Canoe {
    private final int size = 1;
    private int hitsLeft;

    public Canoe() {
        hitsLeft = size;
    }

    public boolean hit(int position) {
        if (position != 0) {
            throw new IllegalArgumentException("Invalid position for Canoe");
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

