import java.util.Stack;

public class SortStack {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertSorted(stack, temp);
        }
    }

    private void insertSorted(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, val);
        stack.push(temp);
    }
}
