/**
 *
 * @author Francis Tapia
 */
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int tamañoMatriz = 0;
        System.out.println("Deme el limite");
        tamañoMatriz = tcl.nextInt();
        int matriz[][] = new int[tamañoMatriz][tamañoMatriz];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("DIAGONAL PRINCIPAL OBVIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nDIAGONAL PRINCIPAL EFICIENTE");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + "\t");
        }
        System.out.println("\nDIAGONAL SECUNDARIA OBVIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if ((i + j) == matriz.length - 1) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nDIAGONAL SECUNDARIA EFICIENTE");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - 1 - i] + "\t");
        }
        System.out.println("\nELEMENTOS BAJO LA DIAGONAL PRINCIPAL OBVIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i > j) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nELEMENTOS BAJO LA DIAGONAL PRINCIPAL EFICIENTE");
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nELEMENTOS SOBRE LA DIAGONAL PRINCIPAL");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
                    
        }
        System.out.println("\nELEMENTOS BAJO LA DIAGONAL SECUNDARIA");
        for (int i = 1; i < matriz.length; i++) {
            for (int j = matriz.length - i; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nELEMTOS SOBRE LA DIAGONAL SECUNDARIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length - i - 1; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
    }
}
/***
 * Deme el limite
3
1	3	5	
9	7	5	
5	8	0	
DIAGONAL PRINCIPAL OBVIA
1	7	0	
DIAGONAL PRINCIPAL EFICIENTE
1	7	0	
DIAGONAL SECUNDARIA OBVIA
5	7	5	
DIAGONAL SECUNDARIA EFICIENTE
5	7	5	
ELEMENTOS BAJO LA DIAGONAL PRINCIPAL OBVIA
9	5	8	
ELEMENTOS BAJO LA DIAGONAL PRINCIPAL EFICIENTE
9	5	8	
ELEMENTOS SOBRE LA DIAGONAL PRINCIPAL
3	5	5	
ELEMENTOS BAJO LA DIAGONAL SECUNDARIA
5	8	0	
ELEMTOS SOBRE LA DIAGONAL SECUNDARIA
1	3	9	BUILD SUCCESSFUL (total time: 1 second)

 */
