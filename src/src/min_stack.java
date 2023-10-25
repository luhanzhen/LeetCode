import java.util.ArrayList;

public class min_stack {

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(6);
        obj.push(23);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    static class MinStack {
        private ArrayList<Integer> array;
        private int min;
        private int min_idx;

        private int size;

        public MinStack() {
            array = new ArrayList<>();
            min = Integer.MAX_VALUE;
            size = 0;
        }

        public void push(int val) {
            min = Math.min(val,min);

        }

        public void pop() {

        }

        public int top() {
            return -1;
        }

        public int getMin() {
            return -1;
        }
    }

}
