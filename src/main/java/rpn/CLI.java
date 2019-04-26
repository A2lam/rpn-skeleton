package rpn;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression) {
        String[] tokens = expression.split(" ");
        ArrayDeque<Long> stack = new ArrayDeque<>();
        long left;
        long right;

        for (String token : tokens) {
            switch (token)
            {
                case "+" :
                    left = stack.pop();
                    right = stack.pop();

                    stack.push(left + right);
                    break;

                case "-" :
                    left = stack.pop();
                    right = stack.pop();

                    stack.push(left - right);
                    break;

                case "*" :
                    left = stack.pop();
                    right = stack.pop();

                    stack.push(left * right);
                    break;

                case "/" :
                    left = stack.pop();
                    right = stack.pop();

                    stack.push(left / right);
                    break;

                default:
                    stack.push(Long.valueOf(token));
                    break;
            }
        }

        return stack.pop();
    }
}
