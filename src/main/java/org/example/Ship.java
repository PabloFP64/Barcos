package org.example;

import java.util.HashSet;

public class Ship {
    private int size;
    private CardinalPoints direction;
    private Point startPoint;
    private Point endPoint;
    private HashSet<Point> hits;

    public Ship(Point startPoint, Point endPoint) throws Exception {
        if (!isValid(startPoint, endPoint)) {
            throw new Exception("Invalid ship placement!");
        }
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.direction = getDirection(startPoint, endPoint);
        this.size = getSize(startPoint, endPoint);
        this.hits = new HashSet<>();
    }


    private boolean isValid(Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint)) {
            return false;
        }
        if (startPoint.getX() != endPoint.getX() && startPoint.getY() != endPoint.getY()) {
            return false;
        }
        return true;
    }

    private CardinalPoints getDirection(Point startPoint, Point endPoint) {
        if (startPoint.getX() == endPoint.getX()) {
            if (startPoint.getY() < endPoint.getY()) {
                return CardinalPoints.EAST;
            } else {
                return CardinalPoints.WEST;
            }
        } else {
            if (startPoint.getX() < endPoint.getX()) {
                return CardinalPoints.SOUTH;
            } else {
                return CardinalPoints.NORTH;
            }
        }
    }

    private int getSize(Point startPoint, Point endPoint) {
        if (startPoint.getX() == endPoint.getX()) {
            return Math.abs(startPoint.getY() - endPoint.getY()) + 1;
        } else {
            return Math.abs(startPoint.getX() - endPoint.getX()) + 1;
        }
    }

    public boolean isSunk() {
        return hits.size() == size;
    }

    public boolean getShot(Point shotPoint) {
        if (isHit(shotPoint)) {
            hits.add(shotPoint);
            return true;
        }
        return false;
    }

    private boolean isHit(Point shotPoint) {
        if (direction == CardinalPoints.NORTH) {
            return startPoint.getX() == shotPoint.getX() && startPoint.getY() - hits.size() == shotPoint.getY();
        } else if (direction == CardinalPoints.EAST) {
            return startPoint.getY() == shotPoint.getY() && startPoint.getX() + hits.size() == shotPoint.getX();
        } else if (direction == CardinalPoints.SOUTH) {
            return startPoint.getX() == shotPoint.getX() && startPoint.getY() + hits.size() == shotPoint.getY();
        } else {
            return startPoint.getY() == shotPoint.getY() && startPoint.getX() - hits.size() == shotPoint.getX();
        }
    }

    public int getSize() {
        return size;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public int getLength() {
        return size;
    }

    public char getSymbol() {
        return 'S';
    }

    public void setPosition(int row, int i, int i1) {


    }
}

