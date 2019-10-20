package notacionpostfijainfija;

public class Nodo {
    private Object elemento;
    private Nodo sgteNodo;

    public Nodo() {
        this.elemento=null;
        this.sgteNodo= null;
    }

    public Nodo(Object elemento, Nodo sgteNodo) {
        this.elemento = elemento;
        this.sgteNodo = sgteNodo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Nodo getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(Nodo sgteNodo) {
        this.sgteNodo = sgteNodo;
    }
    

    
}
