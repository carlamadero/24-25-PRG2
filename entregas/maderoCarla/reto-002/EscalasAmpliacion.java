import java.util.Scanner;

public class EscalasAmpliacion {
    static String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int opcion = scanner.nextInt();
        
        if (opcion < 1 || opcion > 12) {
            System.out.println("Opción no válida.");
        } else {
            String notaBase = notas[opcion - 1];
            System.out.println("Ha elegido la nota " + notaBase);
            escalasModales(opcion);
            mostrarEscala(nombre, opcion, intervalos);
            mostrarAcorde(tipo, opcion, intervaloTercera, intervaloQuinta);
        }
        
        scanner.close();
    }

    public static void escalasModales(int opcion) {
        String[] nombres = {"Mayor", "Menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Pentatónica Mayor", "Pentatónica Menor", "Por Tonos"};
        int[][] intervalos = {
            {2, 2, 1, 2, 2, 2, 1}, 
            {2, 1, 2, 2, 1, 2, 2}, 
            {2, 1, 2, 2, 2, 1, 2}, 
            {1, 2, 2, 2, 1, 2, 2}, 
            {2, 2, 2, 1, 2, 2, 1}, 
            {2, 2, 1, 2, 2, 1, 2}, 
            {1, 2, 2, 1, 2, 2, 2}, 
            {2, 2, 3, 2, 3},       
            {3, 2, 2, 3, 2},       
            {2, 2, 2, 2, 2, 2}     
        };
        
        for (int i = 0; i < nombres.length; i++) {
            mostrarEscala(nombres[i], opcion, intervalos[i]);
        }
    }

    public static void mostrarEscala(String nombre, int opcion, int[] intervalos) {
        int indice = opcion - 1;
        System.out.print("La escala " + nombre + " de " + notas[indice] + " es: [" + notas[indice] + "]");
    
        for (int i=0; i<notas.length; i++) {
            indice = (indice + i) % 12;
            System.out.print(" / [" + notas[indice] + "]");
        }
        System.out.println();
    }

    public static void mostrarAcorde(String tipo, int opcion, int intervaloTercera, int intervaloQuinta) {
        int tercera = (opcion - 1 + intervaloTercera) % 12;
        int quinta = (opcion - 1 + intervaloQuinta) % 12;
        
        System.out.println("El acorde de " + notas[opcion - 1] + " " + tipo + " está conformado por: [" + notas[opcion - 1] + "] / [" + notas[tercera] + "] / [" + notas[quinta] + "]");
    }
}