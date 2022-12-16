package deque;


import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable, Deque<T>{
    private T value;
    private int size;
    private ListNode sentinel;
    private ListNode last;

    @Override
    public Iterator iterator() {
        return null;
    }

    private class ListNode{
        public T item;
        public ListNode next;
        public ListNode prev;

        public ListNode(){
            next = null;
            prev = null;
        }

        public ListNode(T i){
            item = i;
            next = null;
            prev = null;
        }
    }

    public LinkedListDeque() {
        sentinel = new ListNode();
        last = new ListNode();
        size = 0;
    }

    public void addFirst(T item){
        ListNode first = new ListNode(item);
//        System.out.println(first.next);
        if(isEmpty()){
            sentinel.next = first;
            first.prev = sentinel;
            first.next = last;
            last.prev = first;
        } else {
            ListNode prevfirst = sentinel.next;
            prevfirst.prev = first;
            first.next = prevfirst;
            first.prev = sentinel;
            sentinel.next = first;
        }
        size += 1;
//        System.out.println(first.next);
    }

    public void addLast(T item){
        ListNode newlast = new ListNode(item);
        if(isEmpty()){
            last.prev = newlast;
            newlast.next = last;
            sentinel.next = newlast;
            newlast.prev = sentinel;
        } else {
            ListNode prevlast = last.prev;
            newlast.next = last;
            newlast.prev = prevlast;
            prevlast.next = newlast;
            last.prev = newlast;
        }
        size += 1;
    }

    public boolean isEmpty(){
        if(sentinel.next == null || sentinel.next == last){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        ListNode p = sentinel.next;
        while(p.next != null){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            System.out.println("empty list!");
        } else {
            ListNode prevfirst = sentinel.next;
            ListNode newfirst = prevfirst.next;
            T x = prevfirst.item;
            sentinel.next = newfirst;
            newfirst.prev = sentinel;
            prevfirst = null;
            size -= 1;
            return x;
        }
        return null;
    }

    public T removeLast(){
        if(isEmpty()){
            System.out.println("empty list!");
        } else {
            ListNode prevlast = last.prev;
            ListNode newlast = prevlast.prev;
            T x = prevlast.item;
            last.prev = newlast;
            newlast.next = last;
            prevlast = null;
            size -= 1;
            return x;
        }
        return null;
    }

    public T get(int index){
        if(isEmpty() || index>=size){
            return null;
        }
        int i = 0;
        ListNode node = sentinel.next;
        T x = sentinel.next.item;
        while(i < index){
            node = node.next;
            x = node.item;
        }
        return x;
    }

    public boolean equals(Object o){
        o = new LinkedListDequeTest();
//        LinkedListDeque L = new LinkedListDeque();
        return (o instanceof LinkedListDeque<?>);
    }

    public T getRecursive(int index){
        if (index >= size) {
            return null;
        }
        return getRecursive(index, 0, sentinel.next);
    }

    private T getRecursive(int index, int current, ListNode head) {
        if (current == index) {
            return head.item;
        }
        return getRecursive(index, current + 1, head.next);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        Object o = new LinkedListDequeTest();
        System.out.println(L.getRecursive(0));
        L.removeFirst();
//        System.out.println(L.sentinel.next);
        L.equals(o);
        System.out.println(L.isEmpty());
    }
}
