import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        RecordController recordcontroller = new RecordController();
        recordcontroller.loadRecords();

        Scanner input = new Scanner(System.in);
        System.out.println("Podaj wyrazenie:");
        String text = input.nextLine();
        Expression exp = new Expression(text);
        System.out.println();
        System.out.println();

        BST bst = new BST();
        bst.insert(exp.toRPN());
        bst.printTree(2);
        System.out.println("Czy kontynuowac ? (y/n)");
        String text2 = input.nextLine();
        if(text2.equals("y")){
            recordcontroller.GetRecords(bst);
        }

    }
}