package Tools;

public class Nodo<T>{
    T value;
    Nodo next;
    Nodo prev;

    Nodo(T valor){
        this.value = valor;
        this.next = null;
        this.prev = null;
    }

    public Nodo() {
    }

    public T getT(){
        return this.value;
    }
}
