
import java.util.Random;

/**
 *
 * @author franc
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        int size = 4;
        Random random = new Random();

        int[][] matrix1 = new int[size][size];
        int[][] matrix2 = new int[size][size];
        int[][] sumMatrix = new int[size][size];
        int[][] productMatrix = new int[size][size];
        System.out.println("Matriz 1 y 2 (y sus resultados):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix1[i][j] = random.nextInt(10);
                matrix2[i][j] = random.nextInt(10);
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                productMatrix[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Matriz 1:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz 2:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz Suma:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz Producto:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(productMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/***
 * Matriz 1 y 2 (y sus resultados):
Matriz 1:
3 9 1 0 
3 3 1 4 
9 1 3 2 
0 0 1 5 

Matriz 2:
7 4 5 2 
1 7 3 2 
3 9 2 6 
0 8 8 6 

Matriz Suma:
10 13 6 2 
4 10 4 6 
12 10 5 8 
0 8 9 11 

Matriz Producto:
21 12 15 6 
21 33 24 12 
63 43 54 38 
0 0 2 36 
BUILD SUCCESSFUL (total time: 0 seconds)
 */