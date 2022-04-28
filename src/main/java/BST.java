import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BST {
    private Node root = null;
    private ArrayList<Node> nodeList = null;

    @Getter
    @Setter
    public class Node {
        int key;
        String value;
        Node left, right, parent;
        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public String getTrueValue() {
            switch (value){
                case "%":
                    return "!=";
                case "*":
                    return "<=";
                case "^":
                    return ">=";
                case "&":
                    return "and";
                case "|":
                    return "or";
                default:
                    return value;
            }
        }
    }

    public void insert(String[] exp) {

        ArrayList<Node> nodelist = new ArrayList<>();
        for (int i = 0; i < exp.length; i++){
            String k = exp[i];
            int n = i;
            if(!k.equals("&") && !k.equals("|") && !k.equals("=") && !k.equals("%") && !k.equals("<") && !k.equals(">") && !k.equals("*") && !k.equals("^")){
                nodelist.add(new Node(i,k));
            } else {
                nodelist.add(new Node(i, k)); //TODO
                while((nodelist.get(i).getLeft()==null || nodelist.get(i).getRight()==null) && !nodelist.isEmpty()) {

                    if(nodelist.get(n-1).getParent() == null && nodelist.get(i).getRight() == null) {
                        nodelist.get(i).setRight(nodelist.get(n-1));
                        nodelist.get(n - 1).setParent(nodelist.get(i));
                    }
                    else if (nodelist.get(n-1).getParent() == null) {
                        nodelist.get(i).setLeft(nodelist.get(n-1));
                        nodelist.get(n - 1).setParent(nodelist.get(i));
                    }
                    n--;
                }
            }
        }
        setRoot(nodelist.get(exp.length-1));
        setNodeList(nodelist);
    }

    public void space(int n){
        for(int i=0; i<n; i++) System.out.printf(" ");
    }

    public void printNodeTree(Node node, int a){
        if(node!=null) {
            printNodeTree(node.getRight(), a+4);
            space(a);
            System.out.println(node.getTrueValue());
            printNodeTree(node.getLeft(), a+4);

        }
        return;
    }

    public void printTree(int a){
        printNodeTree(root, a);
    }

    public void checkTree(Node node){
        if(node!=null) {
            checkTree(node.getRight());
            System.out.println(node.getTrueValue());
            checkTree(node.getLeft());
        }
        return;
    }

}
