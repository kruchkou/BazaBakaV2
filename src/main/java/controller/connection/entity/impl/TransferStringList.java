package controller.connection.entity.impl;

import java.util.ArrayList;
import java.util.List;

public class TransferStringList extends TransferElement {

    List<String> stringList = new ArrayList<>();

    public TransferStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }
}
