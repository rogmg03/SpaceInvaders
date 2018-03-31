package Tools;

public class ListaDoble<T> extends ListaEnlazada<T>{
    public Nodo tail;


    //PROBLEMA, no puedo hacer override, no permite, cambie add por addDb
    public void add(T valor) {
        if (this.head == null) {
            this.head = new Nodo(valor);
            this.head.next = null;
            this.tail = this.head;
            this.Size += 1;
        } else {
            Nodo tmp = this.tail;
            tmp.next = new Nodo(valor);
            this.tail = tmp.next;
            this.tail.prev = tmp;
            this.Size += 1;
        }
    }

    @Override
    public void removePos(int i) {
        if (this.getSize() / 2 > i) {
            Nodo temp = this.head;
            int cont = 0;

            while (cont != i) {
                temp = temp.next;
                cont += 1;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp.prev;
        } else if (this.getSize() / 2 <= i) {
            Nodo temp = this.tail;
            int cont = this.getSize()+1;

            while (cont != i) {
                temp = temp.prev;
                cont -= 1;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp.prev;
        }
    }

    public T get(int i){
        if ((this.getSize() / 2) >= i){
            super.get(i);
        } else{
            int cont = (this.getSize())-1;
            Nodo temp = this.tail;

            while (cont!=i){
                temp = temp.prev;
                cont -= 1;
            }
            System.out.println(temp.getT());
            return (T) temp.getT();
        }
        return null;
    }

}
