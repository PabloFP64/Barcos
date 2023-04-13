package org.example;

import org.example.Ejercicio5.Battleship;

import java.util.List;

public class User {
    private List<Ship> ships;
    private String name;
    private boolean isAlive;

    public User(String ships) throws Exception {
        if (ships == null || ships.isEmpty() || ships.size() > 3) {
            throw new Exception("Invalid number of ships");
        }
        for (Ship ship : ships) {
            if (ship == null) {
                throw new Exception("Invalid ship");
            }
        }
        this.ships = ships;
        this.isAlive = true;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        this.isAlive = false;
    }

    public boolean attack(Point shotPoint, User user) throws Exception {
        if (shotPoint == null || user == null) {
            throw new Exception("Invalid parameters");
        }
        for (Ship ship : user.getShips()) {
            if (ship.getShot(shotPoint)) {
                return true;
            }
        }
        return false;
    }

    public void getShot(Point shotPoint) throws Exception {
        if (shotPoint == null) {
            throw new Exception("Invalid parameter");
        }
        for (Ship ship : ships) {
            ship.getShot(shotPoint);
        }
    }

    public String getName() {
        return name;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }
}

