import java.util.Stack;
import java.util.Scanner;

public class PostFixCalculator{
    public static double calculate(String expression){
        Stack <Double> st = new Stack <Double>();
        st.push(0.0); // for if the first number is a negative number
        String postFix = InfixToPostfix.toPostfix(expression);
        //System.out.println("Original Expression: " + expression);
        //System.out.println("Postfix Expression: " + postFix);
        Scanner in = new Scanner(postFix);
        // while there is still something in the postfix string
        while(in.hasNext()){ 
            if(in.hasNextDouble()){
                // if the next part of the expression is a number
                st.push(Double.parseDouble(in.next()));
            } else {
                // if the next part shows an operation
                String op = in.next(); // stores what the operation is
                if(op.equals("+")){ // addition
                    st.push(st.pop() + st.pop());
                }
                if(op.equals("-")){ // subtraction
                    double pop1 = st.pop();
                    double pop2 = st.pop();
                    // needs to be stored in variables because the order matters
                    st.push(pop2 - pop1);
                }
                if(op.equals("*")){ // multiplication
                    st.push(st.pop() * st.pop());
                }
                if(op.equals("/")){ // division
                    double pop1 = st.pop();
                    double pop2 = st.pop();
                    st.push(pop2 / pop1);
                }
                if(op.equals("%")){ // percent
                    st.push(st.pop() / 100);
                }
            }
        }
        in.close();
        return st.pop();
    }
}