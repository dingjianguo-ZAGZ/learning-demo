package Queue;

import java.util.Queue;

public class E02MyStack {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {

        }

        public void push(int x) {
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            queue1.offer(x);
            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            Integer peek = queue1.peek();
            return peek;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
