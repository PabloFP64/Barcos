package org.example;

import org.example.Ejercicio5.Battleship;
import org.example.Ejercicio5.Frigate;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Hundir la Flota");

        // Pedimos la configuración de los barcos del usuario 1
        System.out.println("Usuario 1, introduzca la configuración de sus barcos");
        User user1 = new User("Usuario 1");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Barco %d:\n", i+1);
            System.out.print("Coordenadas de inicio (fila, columna): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            System.out.print("Orientación (N, S, E, W): ");
            String orientation = scanner.next();
            user1.addShip(new Ship);
        }

        // Pedimos la configuración de los barcos del usuario 2
        System.out.println("Usuario 2, introduzca la configuración de sus barcos");
        User user2 = new User("Usuario 2");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Barco %d:\n", i+1);
            System.out.print("Coordenadas de inicio (fila, columna): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            System.out.print("Orientación (N, S, E, W): ");
            String orientation = scanner.next();
            user2.addShip(new Ship);
        }

        // Creamos el tablero
        Board board = new Board(user1, user2);

        // Comenzamos la partida
        while (user1.isAlive() && user2.isAlive()) {
            System.out.println("\nTurno de Usuario 1");
            System.out.print("Coordenadas de ataque (fila, columna): ");
            int attackX = scanner.nextInt();
            int attackY = scanner.nextInt();
            board.attack(user2, new Point(attackX, attackY));

            System.out.println("\nTurno de Usuario 2");
            System.out.print("Coordenadas de ataque (fila, columna): ");
            attackX = scanner.nextInt();
            attackY = scanner.nextInt();
            board.attack(user1, new Point(attackX, attackY));
        }

        // Mostramos el ganador o el empate
        if (!user1.isAlive() && !user2.isAlive()) {
            System.out.println("\n¡Ha habido un empate!");
        } else if (user1.isAlive()) {
            System.out.println("\n¡El ganador es el Usuario 1!");
        } else {
            System.out.println("\n¡El ganador es el Usuario 2!");
        }
    }
}

