public class BST {

    Nodo raiz;

    public BST() {
        this.raiz = null;
    }

    public boolean existe_nodo_terminal(Nodo x, String busqueda) {
        if (x != null)
            if (x.nombre.equals(busqueda))
                return false;
            else if (busqueda.compareTo(x.nombre) < 0)
                return existe_nodo_terminal(x.hijoIzquierdo, busqueda);
            else
                return existe_nodo_terminal(x.hijoDerecho, busqueda);

        return true;
    }

    // Nodos terminales
    public void nodos_terminales(Nodo x) {
        if (x != null) {
            if(x.hijoDerecho == null && x.hijoIzquierdo == null){
                System.out.println("indice: " + x.llave + " nombre: " + x.nombre);
            }
            nodos_terminales(x.hijoIzquierdo);
            nodos_terminales(x.hijoDerecho);
        }
    }

    // Altura del arbol
    public int altura(Nodo x) {
        if (x != null)
            return 1 + Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho));

        return 0;
    }

    // inorder tree walk
    public void recorrido_in_order(Nodo x) {
        if (x != null) {
            recorrido_in_order(x.hijoIzquierdo);
            System.out.println("indice: " + x.llave + " nombre: " + x.nombre);
            recorrido_in_order(x.hijoDerecho);
        }
    }

    // método recursivo para realizar recorrido preorden
    public void recorrido_pre_order(Nodo x) {
        if (x != null) {
            System.out.println("indice: " + x.llave + " nombre: " + x.nombre);
            recorrido_pre_order(x.hijoIzquierdo);
            recorrido_pre_order(x.hijoDerecho);
        }
    }

    // método recursivo para realizar el recorrido postorden
    public void recorrido_post_orden(Nodo x) {
        if (x != null) {
            recorrido_post_orden(x.hijoIzquierdo);
            recorrido_post_orden(x.hijoDerecho);
            System.out.println("indice: " + x.llave + " nombre: " + x.nombre);
        }

    }

    public void insertar(int key, String valor) {
        Nodo n = new Nodo(key); 
        n.nombre = valor; 

        if (raiz == null) {
            raiz = n;
        } else {
            Nodo temporal = raiz;

            while (temporal != null) { // TODO
                n.p = temporal;
                if (n.llave >= temporal.llave) {
                    temporal = temporal.hijoDerecho;
                } else {
                    temporal = temporal.hijoIzquierdo;
                }
            }
            if (n.llave < n.p.llave) {
                n.p.hijoIzquierdo = n; 
            } else {
                n.p.hijoDerecho = n;
            }
        }
    }

    private class Nodo {
        public Nodo p;
        public Nodo hijoDerecho;
        public Nodo hijoIzquierdo;
        public int llave;
        public String nombre;

        public Nodo(int key) {
            this.llave = key;
            this.hijoDerecho = null;
            this.hijoIzquierdo = null;
            this.p = null;
            this.nombre = null;
        }
    }
}
