package Tools;

public class ListaCircular<T> extends ListaEnlazada<T> implements Lista<T>{

    Nodo<T> head;
    Nodo<T> tail;
    int size;



    public boolean isEmpty(){
        return head==null;
    }


    public void change(int i, T valor){
        int cont = 0;
        Nodo<T> temp = this.head;

        while (cont!=i){
            temp = temp.next;
            cont += 1;
        }
        temp.value = valor;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void add(T value){
        Nodo<T> node = new Nodo(value);
        if (isEmpty()){
            this.head = node;
            this.tail = head;
            this.tail.next = head;
        }else{
            this.tail.next = node;
            node.next = head;
            this.tail = node;
        }
        size++;
    }

    @Override
    public T get(int pos)/* throws Exception */{
        if (pos>=0 && pos<size){
            if (pos == 0){
                return head.getT();
            }else{
                Nodo<T> aux = head;
                for (int i = 0; i < pos; i++){
                    aux = aux.next;
                }
                return aux.getT();
            }
        }else{
            return null;
        }

    }

    @Override
    public void removePos(int pos){
        if(pos>=0 && pos<size){
            if(pos == 0){
                head = head.next;
                tail.next = head;
            }
            else{
                Nodo<T> aux = head;
                for (int i = 0; i < pos-1; i++) {
                    aux = aux.next;
                }
                if (aux.next == head) {
                    aux.next = head;
                    tail = aux;
                } else {
                    Nodo<T> next = aux.next;
                    aux.next = next.next;
                }
            }
            size--;
        }
    }


    public void removeValue(T value, Boolean todos){
            if (head.getT() == value) {
                head = head.next;
                tail.next = head;
            } else{
                Nodo aux = head;
                while(aux.next.getT() != value){
                    aux = aux.next;
                }
                if (aux.next == tail) {
                    aux.next = head;
                    tail = aux;
                } else {
                    Nodo next = aux.next;
                    aux.next = next.next;
                }
            }
            size--;
        }


    public void show (){
        Nodo<T> temp = this.head;
        for (int i = 0; i<this.getSize();i++){
            System.out.println(temp.getT());
            temp = temp.next;
        }
    }



}
