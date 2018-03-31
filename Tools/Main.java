package Tools;

public class Main {
    public static void main(String[] args){

        ListaDoble lista = new ListaDoble();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.show();
        lista.get(3);
        System.out.println("Borra uno");
        lista.removeValue(0,true);
        lista.show();
    }
}
