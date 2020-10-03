package controller.connection.entity;

import java.util.ArrayList;
import java.util.List;

public class TransferStringList implements TransferInterface {

    List<String> stringList = new ArrayList<>();

    public TransferStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }
}
