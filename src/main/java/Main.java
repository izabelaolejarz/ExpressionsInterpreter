import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> record1 = new ArrayList<>();
        ArrayList<Integer> record2 = new ArrayList<>();
        ArrayList<Integer> record3 = new ArrayList<>();
        record1.add(3);
        record1.add(2);
        record1.add(1);
        record1.add(0);
        record1.add(5);
        record1.add(6);
        record1.add(4);
        record1.add(8);
        record2.add(4);
        record2.add(2);
        record2.add(2);
        record2.add(7);
        record2.add(5);
        record2.add(6);
        record2.add(3);
        record2.add(0);
        record3.add(6);
        record3.add(1);
        record3.add(4);
        record3.add(7);
        record3.add(9);
        record3.add(2);
        record3.add(3);
        record3.add(0);

        Record r1 = new Record(record1);
        Record r2 = new Record(record2);
        Record r3 = new Record(record3);

        ArrayList<Record> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);

        for (Record myrecord: list) {
            for (int i = 97; i<97+myrecord.getRecords().size(); i++){
                System.out.print(myrecord.getValue((char)i).toString() + " ");
            }
            System.out.println();
        }

        String s1 = "(a = 3 and b = 2) or (f = 6 and e = 5)";
        String s2 = "(a > 3 and b > 2) or (f < 6 and g = 5)";
        String s3 = "(d >= 7 and e <= 5) or (d != 7 and h != 0)";

        ArrayList<String> expressions = new ArrayList<>();
        expressions.add(s1);
        expressions.add(s2);
        expressions.add(s3);
        System.out.println();

        for (String myexpr: expressions) {
            System.out.println(myexpr);
        }
        System.out.println();

        RecordController recordcontroller = new RecordController(list);
        /*ArrayList<Record> compatible = tmp.GetRecords(s1);

        for (Record myrecord: compatible) {
            for (int i = 97; i<97+8; i++){
                System.out.print(myrecord.getValue((char)i).toString() + " ");
            }
            System.out.println();
        }
        */

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



        /*ArrayList<Integer>[] records = new ArrayList[3];
        for (int i = 0; i<3; i++) {
            records[i] = new ArrayList<Integer>();
        }

        records[0].add(3);
        records[0].add(2);
        records[0].add(1);
        records[0].add(0);
        records[0].add(5);
        records[0].add(6);
        records[0].add(4);
        records[0].add(8);

        records[1].add(4);
        records[1].add(2);
        records[1].add(2);
        records[1].add(7);
        records[1].add(5);
        records[1].add(6);
        records[1].add(3);
        records[1].add(0);

        records[2].add(6);
        records[2].add(1);
        records[2].add(4);
        records[2].add(7);
        records[2].add(9);
        records[2].add(2);
        records[2].add(3);
        records[2].add(0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < records[i].size(); j++) {
                System.out.print(records[i].get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        */

    }
}