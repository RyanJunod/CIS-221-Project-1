public interface StackInterface3<T> {
    public void push(T element, int numStack);
    public void pop(int numStack);
    public T top(int numStack);
    public boolean isFull();
    public boolean isEmpty(int numStack);
}
