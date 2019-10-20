
package notacionpostfijainfija;

public class PilaEnlazada {
    

    Nodo Cima;

    public void apilar(Object d) {
        Nodo nuevo = new Nodo();
        nuevo.setElemento(d);
        if (Cima == null) {
            Cima = nuevo;
        } else {
            if (d != null) {
                nuevo.setSgteNodo(Cima); 
                Cima = nuevo;
            }
        }
    }

    public Object desapilar() {
        Nodo aux = Cima;
        Cima = Cima.getSgteNodo();
        return aux.getElemento();
    }

    public void imprimir() {
        Nodo aux = Cima;
        while (aux != null) {
            System.out.print(aux.getElemento() + "->");
            aux = aux.getSgteNodo();
        }
    }
    public int pos(Object o){
        Nodo aux = Cima;
        for (int i = 1; aux != null ; i++) {
            if (aux.getElemento() == o) {
                return i;
            }
            aux = aux.getSgteNodo();
        }
        return -1;
    
    }
    public Object cima() {
        return Cima.getElemento();
    }
   
    public int buscar(Object o){
        Nodo aux = Cima;
        while (aux != null) {
            if (aux.getElemento() == o) {
                return 1;
            }
            aux = aux.getSgteNodo();
        }
        return 0;
    }
    
    boolean esVacia() {
        return Cima == null;
    }

    @Override
    public String toString() { //retorna todos los getElemento()s de la pila en un solo string
        Nodo aux = Cima;
        String salida = "";
        while (aux != null) {
            salida += aux.getElemento();
            aux = aux.getSgteNodo();
        }
        return salida;
    }
    
}


