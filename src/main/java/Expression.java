import lombok.Getter;
import lombok.Setter;


import java.util.Stack;


@Getter
@Setter
public class Expression {
    private String expression;
    private String postexpression;

    public Expression(String expression){
        this.expression = expression; //usuwamy białe znaki ze Stringa
        this.postexpression = "";
    }

    public Integer priority (String s){
        if (s.equals("=") || s.equals("%") || s.equals("<") || s.equals(">") || s.equals("*") || s.equals("^")) return 2;
        else if(s.equals("&") || s.equals("|")) return 1;
        else return 0;
    }
    public String firstreplace(String s){
        return s.replaceAll("and","&").replaceAll("or", "|").replaceAll("!=","%").replaceAll("<=","*").replaceAll(">=","^").replaceAll(" ","");
    }

    public String[] toRPN(){

        String tmp1 = firstreplace(expression);
        System.out.println(tmp1);
        System.out.println();

        String[] tmp2 = tmp1.split("");

        Stack<String> stack = new Stack<>();
        for(int i = 1; i<=tmp2.length; i++){
            String s = tmp2[i-1];

            if(s.equals("(")) stack.push(s);

            else if(s.equals(")")) {
                while(!stack.empty() && !stack.peek().equals("(")) postexpression += stack.pop();
                stack.pop();
            }

            else if(s.equals("&") || s.equals("|") || s.equals("=") || s.equals("%") || s.equals("<") || s.equals(">") || s.equals("*") || s.equals("^")) {
                while(!stack.empty() && priority(stack.peek()) >= priority(s)) postexpression += stack.pop();
                stack.push(s);
            }

            else postexpression += s;
        }
        while(!stack.empty()) postexpression += stack.pop();

        return postexpression.split("");
    }
}
