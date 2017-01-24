package _227;


import java.util.Stack;


/**
 * Created by vinit on 1/23/17.
 */
public class Solution {


    enum Operator {
        PLUS('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/'),;

        char op;

        Operator(char c) {

            op = c;
        }

        Character operator() {
            return op;
        }

        static Operator getOperatorConst(Character op) {


            switch (op) {
                case '+':
                    return Operator.PLUS;
                case '-':
                    return Operator.MINUS;
                case '*':
                    return Operator.MULTIPLY;
                case '/':
                    return Operator.DIVIDE;
                default:
                    return Operator.PLUS;
            }
        }
    }

    public int priority(Operator op) {

        switch (op) {


            case PLUS:
                return 1;
            case MINUS:
                return 1;
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 2;
            default:
                return -1;
        }


    }

    public int operate(Integer op1, Integer op2, Operator op) {


        switch (op) {


            case PLUS:
                return op1 + op2;
            case MINUS:
                return op1 - op2;
            case MULTIPLY:
                return op1 * op2;
            case DIVIDE:
                return op1 / op2;
            default:
                return -1;
        }
    }

    public int calculate(String s) {

        s = s.replace(" ", "");

        int ans = 0;
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        Boolean prevDigit = false;

        for (int i = 0; i <= s.length(); i++) {

            if (i != s.length() && Character.isDigit(s.charAt(i))) {

                if (prevDigit == false)
                    operandStack.push(Integer.valueOf(String.valueOf(s.charAt(i))));
                else {
                    Integer operand = Integer.valueOf(String.valueOf(operandStack.pop()) + s.charAt(i));
                    operandStack.push(operand);
                }
                prevDigit = true;
            } else if (i != s.length()) {


                if (!operatorStack.empty() && priority(Operator.getOperatorConst(operatorStack.peek())) >= priority(Operator.getOperatorConst(s.charAt(i)))) {


                    Integer op2 = operandStack.pop();
                    Integer op1 = operandStack.pop();

                    operandStack.push(operate(op1, op2, Operator.getOperatorConst(operatorStack.pop())));
                    operatorStack.push(s.charAt(i));


                } else {
                    operatorStack.push(s.charAt(i));
                }
                prevDigit = false;
            } else {
                while (!operatorStack.empty()) {
                    Integer op2 = operandStack.pop();
                    Integer op1 = operandStack.pop();

                    operandStack.push(operate(op1, op2, Operator.getOperatorConst(operatorStack.pop())));
                }
            }

        }


        return operandStack.peek();
    }


    public static void main(String args[]) {

        Solution solution = new Solution();

        System.out.println(solution.calculate("1*2-3/4+5*6-7*8+9/10"));

    }


}
