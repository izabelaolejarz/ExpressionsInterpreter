import com.sun.jdi.IntegerValue;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Setter
@Getter
public class Record {
    private final Map<Object, Integer> records = new HashMap<>();

    public Record(ArrayList<Integer> list){
        int i = 97;
        for (Integer tmp: list) {
            this.records.put((char)i, tmp);
            i++;
        }
    }

    public Integer getValue(char k) {
        return records.get(k);
    }

    public boolean isCompatible(BST tree){
        BST.Node node = tree.getRoot();
        Stack operators = new Stack<>();
        Stack factors = new Stack<>();
        checkNodes(node, operators, factors);
        /*if(exp.getRoot()!=null) {
            printNodeTree(node.getRight());
            System.out.println(node.getTrueValue());
            printNodeTree(node.getLeft());

        }*/
        return true;
    }
    public void checkNodes(BST.Node node, Stack operators, Stack factors){
        if(node!=null) {
            checkNodes(node.getRight(), operators, factors);
            if(node.getValue().equals("&") || node.getValue().equals("|") || node.getValue().equals("=") || node.getValue().equals("%") || node.getValue().equals("<") || node.getValue().equals(">") || node.getValue().equals("*") || node.getValue().equals("^")) {
                operators.push(node.getValue());
                switch (node.getValue()){
                    case "%":
                        factors.push((records.get(factors.pop())) != Integer.valueOf(factors.pop().toString()));
                    case "*":
                        factors.push((records.get(factors.pop())) <= Integer.valueOf(factors.pop().toString()));
                    case "^":
                        factors.push((records.get(factors.pop())) >= Integer.valueOf(factors.pop().toString()));
                    case ">":
                        factors.push((records.get(factors.pop())) > Integer.valueOf(factors.pop().toString()));
                    case "<":
                        factors.push((records.get(factors.pop())) < Integer.valueOf(factors.pop().toString()));
                    case "&":
                        //factors.push(factors.pop() && factors.pop());  //TODO
                    case "|":
                        ;

                }
            }
            factors.push(node.getTrueValue());


            System.out.println(node.getTrueValue());
            checkNodes(node.getLeft(), operators, factors);
        }
        return;
    }
}
