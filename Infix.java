import java.util.Stack;

public class Infix {
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; // Exponentiation (^) has higher precedence
        }
        return -1;
    }

    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // pop '('
                } else {
                    return "Invalid Expression"; // Unbalanced parentheses
                }
            } else { // Operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                return "Invalid Expression"; // Unbalanced parentheses
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

        static String infixToPrefix(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (isOperand(current)) {
                operands.push(Character.toString(current));
            } else if (isOperator(current)) {
                while (!operators.empty() && precedence(operators.peek()) >= precedence(current)) {
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    String newOperand = operators.pop() + operand1 + operand2;
                    operands.push(newOperand);
                }
                operators.push(current);
            } else if (current == '(' || current == ')') {
            }
        }

        while (!operators.empty()) {
            String operand2 = operands.pop();
            String operand1 = operands.pop();
            String newOperand = operators.pop() + operand1 + operand2;
            operands.push(newOperand);
        }

        return operands.pop();
    }


    public static void main(String[] args) {
        String infixExpression = "A+B*(C-D)-E";
        String postfixExpression = infixToPostfix(infixExpression);
        String prefixExpression = infixToPrefix(infixExpression);
        
        System.out.println("Infix   : " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
