// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
class RecordController {

    ArrayList<Record> list = new ArrayList<>();

    public ArrayList<Record> GetList() {
        return list;
    }

    public ArrayList<Record> GetRecords(BST tree){
        ArrayList<Record> tmp = new ArrayList<>();
        for (Record myrecord: list) {
            if(myrecord.isCompatible(tree)) tmp.add(myrecord);
        }
        return tmp;
    }
}
