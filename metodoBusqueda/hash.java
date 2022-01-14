import java.lang.reflect.Array;
import java.util.Arrays;

public class hash{
    
    String[] arreglo;
    int tamanio, contador;

    public hash(int tamanio){
        this.tamanio = tamanio;
        this.arreglo = new String[tamanio];
        Arrays.fill(arreglo, "-1");
    }

    public void funcionHash(String[] cadenaArreglo, String[] arreglo){
        int i; // (1) Declaracion
        for(i = 0; i < cadenaArreglo.length; i++){ // (3n + 2) 1 declaracion ; n comparacion ; 2n i = i + 1 suma y asignacion
            String elemento = cadenaArreglo[i]; // (3n) n llamada a valor del arreglo, n asignacion, n declaracion
            int indiceArreglo = Integer.parseInt(elemento) % 7; // (4n) operacion Parse, division, asignacion, declaracion
            System.out.println("El índice es: " + indiceArreglo + 
            " Para el valor: " + elemento); // 1
            while(arreglo[indiceArreglo] != "-1"){ // (n + 1)
                indiceArreglo++; // 3
                System.out.println("Ocurrió una Colusión en el índice " +
                 (indiceArreglo-1) + " Cambiará al indice " + indiceArreglo); // (1)
                 indiceArreglo %= tamanio; // (2) operacion y asignacion
            }
            arreglo[indiceArreglo] = elemento; // (1) asignacion
        }
    }

    public void mostrar(){
        int incremento = 0; // (2) Declaracion y asignacion
        int i, j; // (2) 2 declaraciones

        for(i = 0; i < 1; i++){ // (3n + 1)
            incremento += 8; // n
            for(j = 0; j < 71; j++){ // 3n + 1
                System.out.print("-"); // n
            }
            System.out.println(); // 1
            for(j = incremento - 8; j < incremento; j++){ // 3n + 1
                System.out.format("| %3s " + " ", j); // n
            }
            System.out.println("|"); // 1
            for(int n = 0; n < 71; n++){ // 3n +1
                System.out.print("-");
            }
            System.out.println();

            for(j = incremento - 8; j < incremento; j++){
                if(arreglo[j].equals("-1")){
                    System.out.println("|      ");
                } else {
                    System.out.print(String.format("| %3s " + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for(j = 0; j < 71; j++){
                System.out.print("-");
            }
        }
    }

    // Método para buscar Clave
    public String buscar_clave(String elemento){
        int indiceArreglo = Integer.parseInt(elemento) % 7; //(4) operacaion parse, operacion %, declaracion y asignacion
        int contador = 0; // (2) Asignacion y declaracion
        while(arreglo[indiceArreglo] != "-1"){ // (n + 1) n comparacion + 1 comparacion al final
            if(arreglo[indiceArreglo] == elemento){ // 3n
                System.out.println("El valor " + elemento + " fue encontrado en el índice: "
                + indiceArreglo ); // 1

                return arreglo[indiceArreglo]; // 1
            }
            indiceArreglo++; // n
            indiceArreglo %= tamanio; // n
            contador++; // n
            if(contador>7){ // 3n
                break; // 1
            }
        }
        
        return null; // 1
    }

    public static void main(String[] args) {
        hash hash = new hash(8);
        String[] elementos = {"20", "33", "21", "10", "12", "14", "56", "100"};
        hash.funcionHash(elementos, hash.arreglo);
        hash.mostrar();
        long inicio = System.nanoTime();
        String busqueda = hash.buscar_clave("14");
        long fin = System.nanoTime();
        long total = fin - inicio;
        System.out.println("Tomó " + total + "ns en realizar la busqueda");
        if(busqueda == null){
            System.out.println("Elemento 33 no encontrado");
        }
    }
}