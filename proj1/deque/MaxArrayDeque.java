package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
        private final Comparator<T> comparator;

        public MaxArrayDeque(Comparator<T> c){
            this.comparator = c;
        }

        public T max(){
            int size = this.size();
            if(isEmpty()){
                return null;
            }
            T max_t = this.get(0);
            for(int i = 1; i < size; i++) {
                T var = get(i);
                if(comparator.compare(max_t, var) < 0){
                    max_t = var;
                }
            }
            return max_t;
        }

        public T max(Comparator<T> c){
            int size = this.size();
            if(size == 0){
                return null;
            }
            T max = this.get(0);

            for(int i = 1;i < size; i++){
                T var = this.get(i);
                if(c.compare(max, var) < 0){
                    max = var;
                }
            }
            return max;
        }

        public static void main(String[] args) {
           MaxArrayDeque<Integer> aa = new MaxArrayDeque<>(Integer::compare);
           aa.addFirst(1);
           aa.addFirst(34);
           aa.addLast(23);
           aa.addFirst(2);
           System.out.println(aa.max(Integer::compare));
        }

}
