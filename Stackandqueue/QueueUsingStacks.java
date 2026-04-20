import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int val) {
        s1.push(val);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
