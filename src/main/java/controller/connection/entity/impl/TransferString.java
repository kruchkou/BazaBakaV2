package controller.connection.entity.impl;

public class TransferString extends TransferElement {

    private final String value;

    public TransferString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
