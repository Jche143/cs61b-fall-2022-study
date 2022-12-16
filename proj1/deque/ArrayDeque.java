package deque;
public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;

    public ArrayDeque(){
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize_f(int capacity) {
        T[] a = (T[])new Object[capacity];
        System.arraycopy(items, 0, a, 1, size);
        items = a;
    }

    private void resize_l(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item){
        resize_f(size+1);
        items[0] = item;
        size += 1;
    }

    public void addLast(T item){
//        size += 1;
        resize_l((int)(size+1));
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T x = items[0];
        for(int i = 1; i < size; i++){
            items[i-1] = items[i];
        }
        items[size-1] = null;
        size -= 1;
        return x;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T x = items[size-1];
        items[size-1] = null;
        size -= 1;
        return x;
    }

    public T get(int index){
        return items[index];
    }

    public boolean equals(Object o){
        o = new ArrayDeque<>();
        return o instanceof ArrayDeque<?>;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer>  A = new ArrayDeque<>();
        A.addFirst(1);
        A.addFirst(2);
        A.removeFirst();
        A.printDeque();
        A.removeLast();
        System.out.println(A.isEmpty());
        A.printDeque();
        System.out.println((int)(101*1.01));
    }
}
