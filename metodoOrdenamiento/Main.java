public class Main {
    public static void main(String[] args) {
        int arreglo[] = {345, 721, 425, 572, 836, 431, 467, 236, 891, 834, 672};
        System.out.println("Arreglo original");
        mostrarArreglo(arreglo);
        System.out.println("Arreglo ordenado");
        radix(arreglo);

    }

    public static void radix(int[] arreglo) {
        long startTime = System.nanoTime();
        int x, i, j;    // 3 declaraciones
        for (x = Integer.SIZE - 1; x >= 0; x--) {   // (3n + 4) llamada, operacion y asignación ; n comparacion ; x = x - 1  2n operacion y asignación; 
            int auxiliar[] = new int[arreglo.length]; // (4) llamada, declaración, asignacion, declaracion
            j = 0; // 1 asignación
            for (i = 0; i < arreglo.length; i++) { // (3n + 1) 1 asignacion ; n comparacion ; 2n operacion y asignacion
                boolean mover = arreglo[i] << x >= 0;   // (3n + 2) llamada a valor, asignacion, comparacion, declaracion, asignacion
                if (x == 0 ? !mover : mover) { // (n + 1) comparacion
                    auxiliar[j] = arreglo[i]; // (2n) Llamada a valor del arreglo y asignacion
                    j++; // (2n) operacion y asignacion
                } else {
                    arreglo[i - j] = arreglo[i]; // 3n operacion, llamada a valor, asignacion
                }
            }

            for(i = j; i < auxiliar.length; i++){ //(5n + 1) n asignacion ; 2n llamada a valor, comparacion ; 2n operacion y asignacion 
                auxiliar[i] = arreglo[i-j];
            }

            arreglo = auxiliar; // asignacion
        }
        long endTime = System.nanoTime();
        long finalTime = endTime - startTime;
        mostrarArreglo(arreglo);
        System.out.println("\nTomó: " + finalTime + " ns ejecutar el ordenamiento");
    }

    public static void mostrarArreglo(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            System.out.println("Posicion " + i + " del arreglo: " + arreglo[i]);
        }
    }
}