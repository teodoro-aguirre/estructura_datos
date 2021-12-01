/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // Crear arbol
        BST arbol = new BST();

        // a) Crear el árbol binario de cadenas (nombres de personas). Ingresa al menos 7 nodos.

        arbol.insertar(5, "Angel");
        arbol.insertar(2, "Juan");
        arbol.insertar(1, "Rubi");
        arbol.insertar(3, "Jaime");
        arbol.insertar(8, "Bartolomeo");
        arbol.insertar(6, "AMLO");
        arbol.insertar(10, "Miguel");

        // b) Realice los tres recorridos y muestre en pantalla (preorden, enorden y postorden).
        System.out.println("\n<---- Recorrido inorder --->");
        arbol.recorrido_in_order(arbol.raiz);
        System.out.println("\n<---- Recorrido preorder --->");
        arbol.recorrido_pre_order(arbol.raiz);
        System.out.println("\n<---- Recorrido postorder --->");
        arbol.recorrido_post_orden(arbol.raiz);

        // c) Muestre la profundidad o altura del árbol binario.
        System.out.println("\n<---- Profundidad --->");
        System.out.println("Produndidad del arbol: " + arbol.altura(arbol.raiz)); 

        // d) Muestre solo los nodos terminales.
        System.out.println("\n<---- Nodos terminales --->");
        arbol.nodos_terminales(arbol.raiz);

        // Realizar busqueda de un nodo terminal
        System.out.println("\n<---- Busqueda de Nodo Terminal --->");
        String existeAngel = (arbol.existe_nodo_terminal(arbol.raiz, "Angel")) ? "Si" : "No";
        String existeAMLO = (arbol.existe_nodo_terminal(arbol.raiz, "AMLO")) ? "Si" : "No";
        String existeRubi = (arbol.existe_nodo_terminal(arbol.raiz, "Rubi")) ? "Si" : "No" ;

        System.out.println("Existe Angel: " + existeAngel);
        System.out.println("Existe Rubi: " + existeRubi);
        System.out.println("Existe AMLO: " + existeAMLO);
    
    }
}