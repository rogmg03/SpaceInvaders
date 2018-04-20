package Tools;

public class Nodo<T>{
    T value;
    Nodo<T> next;
    Nodo<T> prev;

    Nodo(T valor){
        this.value = valor;
    }

    public T getT(){
        return this.value;
    }
}
