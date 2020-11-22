package genericStack;

/**
 * ジェネリクス
 */
public class Sample {
    public static void main(String[] args) {
        NumberStack<Integer> stack = new NumberStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer num1 = stack.pop();
        if (num1 != null) {
            System.out.println(num1);
        }
        Integer num2 = stack.pop();
        if (num2 != null) {
            System.out.println(num2);
        }
    }

}
