
/**
 *
 * @author franc
 */
import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        inicializarTablero(tablero);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char jugador = 'X';
        char maquina = 'O';

        boolean juegoTerminado = false;
        int movimientos = 0;

        while (!juegoTerminado) {
            imprimirTablero(tablero);

            if (movimientos % 2 == 0) {
                System.out.println("Tu turno (Jugador X)");
                int fila, columna;
                while (true) {
                    System.out.print("Ingrese la fila (0-2): ");
                    fila = scanner.nextInt();
                    System.out.print("Ingrese la columna (0-2): ");
                    columna = scanner.nextInt();

                    if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                        tablero[fila][columna] = jugador;
                        break;
                    }
                    System.out.println("Movimiento inválido. Intente de nuevo.");
                }
            } else {
                System.out.println("Turno de la maquina (Jugador O)");
                int[] movimiento = calcularMovimientoMaquina(tablero, maquina, jugador, random);
                tablero[movimiento[0]][movimiento[1]] = maquina;
            }

            movimientos++;

            if (verificarGanador(tablero, jugador)) {
                imprimirTablero(tablero);
                System.out.println("¡Felicidades! Has ganado.");
                juegoTerminado = true;
            } else if (verificarGanador(tablero, maquina)) {
                imprimirTablero(tablero);
                System.out.println("La máquina ha ganado. ¡Mejor suerte la próxima vez!");
                juegoTerminado = true;
            } else if (movimientos == 9) {
                imprimirTablero(tablero);
                System.out.println("¡Es un empate!");
                juegoTerminado = true;
            }
        }

        scanner.close();
    }
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    public static void imprimirTablero(char[][] tablero) {
        System.out.println("\nTablero:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    public static boolean verificarGanador(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) || 
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }
        return (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) || 
               (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador);
    }

    public static int[] calcularMovimientoMaquina(char[][] tablero, char maquina, char jugador, Random random) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = maquina;
                    if (verificarGanador(tablero, maquina)) {
                        tablero[i][j] = ' ';
                        return new int[]{i, j};
                    }
                    tablero[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = jugador;
                    if (verificarGanador(tablero, jugador)) {
                        tablero[i][j] = ' ';
                        return new int[]{i, j};
                    }
                    tablero[i][j] = ' ';
                }
            }
        }
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (tablero[fila][columna] != ' ');
        return new int[]{fila, columna};
    }
}
/***
 * run:

Tablero:
   |   |  
---+---+---
   |   |  
---+---+---
   |   |  
Tu turno (Jugador X)
Ingrese la fila (0-2): 0
Ingrese la columna (0-2): 0

Tablero:
 X |   |  
---+---+---
   |   |  
---+---+---
   |   |  
Turno de la maquina (Jugador O)

Tablero:
 X |   |  
---+---+---
 O |   |  
---+---+---
   |   |  
Tu turno (Jugador X)
Ingrese la fila (0-2): 2
Ingrese la columna (0-2): 2

Tablero:
 X |   |  
---+---+---
 O |   |  
---+---+---
   |   | X
Turno de la maquina (Jugador O)

Tablero:
 X |   |  
---+---+---
 O | O |  
---+---+---
   |   | X
Tu turno (Jugador X)
Ingrese la fila (0-2): 1
Ingrese la columna (0-2): 2

Tablero:
 X |   |  
---+---+---
 O | O | X
---+---+---
   |   | X
Turno de la maquina (Jugador O)

Tablero:
 X |   | O
---+---+---
 O | O | X
---+---+---
   |   | X
Tu turno (Jugador X)
Ingrese la fila (0-2): 2
Ingrese la columna (0-2): 0

Tablero:
 X |   | O
---+---+---
 O | O | X
---+---+---
 X |   | X
Turno de la maquina (Jugador O)

Tablero:
 X |   | O
---+---+---
 O | O | X
---+---+---
 X | O | X
Tu turno (Jugador X)
Ingrese la fila (0-2): 0
Ingrese la columna (0-2): 1

Tablero:
 X | X | O
---+---+---
 O | O | X
---+---+---
 X | O | X
�Es un empate!
BUILD SUCCESSFUL (total time: 40 seconds)
 */