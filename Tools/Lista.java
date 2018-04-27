package Tools;

public interface Lista<T> {
    public void add(T value);
    public void removePos(int pos);
    public T get(int i);
    public int getSize();
    public void removeValue(T valor, Boolean todos);




}
