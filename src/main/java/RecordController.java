import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class RecordController {

    ArrayList<Record> list = new ArrayList<>();

    public ArrayList<Record> GetRecords(BST tree){
        ArrayList<Record> tmp = new ArrayList<>();
        for (Record myrecord: list) {
            if(myrecord.isCompatible(tree)) tmp.add(myrecord);
        }
        return tmp;
    }

    public void loadRecords(){

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

        ArrayList<Record> records = new ArrayList<>();
        records.add(r1);
        records.add(r2);
        records.add(r3);

        for (Record myrecord: records) {
            for (int i = 97; i<97+myrecord.getRecords().size(); i++){
                System.out.print(myrecord.getValue((char)i).toString() + " ");
            }
            System.out.println();
        }

        setList(records);

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

    }
}
