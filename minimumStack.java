import java.util.Stack;
class MinStack 
{
    Stack<Integer> stack; 
    Stack<Integer> minStack;
    public MinStack() 
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int element) 
    {
        stack.push(element); 
        if (minStack.isEmpty() || element <= minStack.peek()) 
        {
            minStack.push(element);
        }
    }
    public void pop()
    {
        if (!stack.isEmpty()) 
        {
            int poppedElement = stack.pop();
            if (poppedElement == minStack.peek()) 
            {
                minStack.pop();
            }
        }
    }
    public int top() 
    {
        if (!stack.isEmpty()) 
        {
            return stack.peek();
        }
        return -1;
    }
    public int getMin() 
    {
        if (!minStack.isEmpty()) 
        {
            return minStack.peek();
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(1);
        int minElement = stack.getMin();
        System.out.println("Minimum Element: " + minElement); 
        stack.pop();
        int topElement = stack.top();
        System.out.println("Top Element: " + topElement);
        int newMinElement = stack.getMin();
        System.out.println("After Pop New Minimum Element: " + newMinElement);
    }
}

