package Tools;

public class ListaEnlazada <T>{
    Nodo head;
    int Size;


    public void add(T valor){
        if (this.head == null){
            this.head = new Nodo(valor);
            this.head.next = null;
            this.Size += 1;
        }else{
            Nodo temp = this.head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Nodo(valor);
            this.Size += 1;
        }
    }

    //Boolean: true=borra todos, false=borra el primero
    public void removeValue(T valor, Boolean todos){
        Nodo temp = this.head;
        if (todos){
            while (temp.next != null) {
                if (this.head.getT().equals(valor)){
                    this.head=this.head.next;
                    this.Size -= 1;
                }else if  (temp.next.next==null && temp.next.getT().equals(valor)){
                    temp.next=null;
                    this.Size -= 1;
                }else if (temp.next.getT().equals(valor)){
                    temp.next = temp.next.next;
                    this.Size -= 1;
                }
                temp=temp.next;
            }
        }else if (!todos){
            while (temp.next != null) {
                if (this.head.getT().equals(valor)) {
                    this.head = this.head.next;
                    this.Size -= 1;
                    break;
                }else if  (temp.next.next==null && temp.next.getT().equals(valor)){
                    temp.next=null;
                    this.Size -= 1;
                    break;
                }else if (temp.next.getT().equals(valor)){
                    temp.next = temp.next.next;
                    this.Size -= 1;
                    break;
                }
                temp=temp.next;
            }
        }
    }


    public void removePos(int i) {
        Nodo temp = this.head;
        int cont = 0;

        while (cont != i){
            temp = temp.next;
            cont += 1;
        }temp.next = temp.next.next;
        temp.next.prev = temp.prev;
    }

    public T get(int i){
        int cont = 0;
        Nodo temp = this.head;

        while (cont!=i){
            temp = temp.next;
            cont += 1;
        }
        //System.out.println(temp.getT());
        return (T) temp.getT();
    }

    public void change(int i, T valor){
        int cont = 0;
        Nodo temp = this.head;

        while (cont!=i){
            temp = temp.next;
            cont += 1;
        }
        temp.value = valor;
    }



    public int getSize() {
        return Size;
    }

    public void show (){
        Nodo temp = this.head;
        while (temp != null){
            System.out.println(temp.getT());
            temp = temp.next;
        }
    }
}
