package Tools;

import Game.Textures;

import java.awt.image.BufferedImage;

public class ListaDoble<T> extends ListaEnlazada<T>{
    public Nodo<T> tail;
    private int i;


    //PROBLEMA, no puedo hacer override, no permite, cambie add por addDb
    public void add(T valor) {
        if (this.head == null) {
            this.head = new Nodo(valor);
            this.tail = this.head;
        } else {
            Nodo<T> tmp = this.tail;
            tmp.next = new Nodo(valor);
            this.tail = tmp.next;
            this.tail.next = null;
            this.tail.prev = tmp;
        }
        this.Size += 1;
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
        this.Size--;
    }


    @Override
    public T get(int i){
        Nodo<T> temp;
        T result = null;
        if ((this.getSize() / 2) > i){
            result = super.get(i);
        }
        else {
            int cont = (this.getSize()-1);
            temp = this.tail;
            result = temp.getT();
            while (cont != i) {
                temp = temp.prev;
                cont -= 1;
                result = temp.getT();
            }
        }
        //System.out.println(result);
        return result;
    }

    public void changePos(int a, int b){
        if (a==b){
            return;
        }
        T tempa = this.get(b);
        T tempb = this.get(a);

        Nodo<T> first = this.head;
        Nodo<T> last = this.tail;

        int half = (this.getSize())/2;

        for (int i = 0; i < this.getSize(); i++){
            if (a>half){
                if (a==i){
                    last.value = tempa;
                    //last = this.tail;
                    break;
                } else {
                    last = last.prev;
                }
            }
            else{
                if (a==i){
                    first.value = tempa;
                    //first = this.head;
                    break;
                } else {
                    first = first.next;
                }
            }
        }
        last = this.tail;
        first = this.head;
        for (int j = 0; j < this.getSize(); j++){
            if (b>half){
                if (b==j){
                    last.value = tempb;
                    //last = this.tail;
                    break;
                } else {
                    last = last.prev;
                }
            }
            else{
                if (b==j){
                    first.value = tempb;
                    //first = this.head;
                    break;
                } else {
                    first = first.next;
                }
            }
        }

    }

    public void changeValue (double a, double b){
        double tempa = a;
        double tempb = b;
        double tempc = tempa;
        tempa = tempb;
        tempb = tempc;
    }

    public void changeValue (int a, int b){
        int tempa = a;
        int tempb = b;
        int tempc = tempa;
        tempa = tempb;
        tempb = tempc;
    }

    public void changeValue (BufferedImage a, BufferedImage b){
        BufferedImage tempa = a;
        BufferedImage tempb = b;
        BufferedImage tempc = tempa;
        tempa = tempb;
        tempb = tempc;
    }

}
