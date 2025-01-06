
/**
 *
 * @author franc
 */
import java.util.Random;
public class Ejercicio3 {
    public static void main(String[] args) {
        int numEstudiantes = 28;
        Random random = new Random();
        String[] estudiantes = new String[numEstudiantes];
        double[] acdNotas = new double[numEstudiantes];
        double[] apeNotas = new double[numEstudiantes];
        double[] aaNotas = new double[numEstudiantes];
        double[] promedios = new double[numEstudiantes];
        for (int i = 0; i < numEstudiantes; i++) {
            estudiantes[i] = "Estudiante " + (i + 1);
        }
        double sumaPromediosCurso = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            acdNotas[i] = random.nextDouble() * 10;
            apeNotas[i] = random.nextDouble() * 10;
            aaNotas[i] = random.nextDouble() * 10;
            promedios[i] = (acdNotas[i] * 0.35) + (apeNotas[i] * 0.35) + (aaNotas[i] * 0.30);
            sumaPromediosCurso += promedios[i];
        }
        double promedioCurso = sumaPromediosCurso / numEstudiantes;
        System.out.printf("Promedio del curso: %.2f\n", promedioCurso);
        System.out.println("\nEstudiantes con promedio por encima del promedio del curso:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (promedios[i] > promedioCurso) {
                System.out.printf("%s: %.2f\n", estudiantes[i], promedios[i]);
            }
        }
        System.out.println("\nEstudiantes con promedio por debajo del promedio del curso:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (promedios[i] < promedioCurso) {
                System.out.printf("%s: %.2f\n", estudiantes[i], promedios[i]);
            }
        }
        int estudianteMayorPromedio = 0;
        for (int i = 1; i < numEstudiantes; i++) {
            if (promedios[i] > promedios[estudianteMayorPromedio]) {
                estudianteMayorPromedio = i;
            }
        }
        System.out.println("\nEstudiante con mayor promedio:");
        System.out.printf("%s: %.2f\n", estudiantes[estudianteMayorPromedio], promedios[estudianteMayorPromedio]);
        int estudianteMenorPromedio = 0;
        for (int i = 1; i < numEstudiantes; i++) {
            if (promedios[i] < promedios[estudianteMenorPromedio]) {
                estudianteMenorPromedio = i;
            }
        }
        System.out.println("\nEstudiante con menor promedio:");
        System.out.printf("%s: %.2f\n", estudiantes[estudianteMenorPromedio], promedios[estudianteMenorPromedio]);
    }
}
