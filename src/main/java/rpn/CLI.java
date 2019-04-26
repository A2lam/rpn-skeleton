package rpn;

import java.lang.reflect.Array;
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
        String[] expr = expression.split(" ");
        long result = 0;

        for (int i = 0; i < expr.length; i++)
        {
            if (expr[i].equals("+"))
            {
                result += (Long.valueOf(expr[i - 1]) + Long.valueOf(expr[i - 2]));
            }
        }

        if (expr.length == 1)
            return Long.valueOf(expression);
        else
            return result;
    }
}
