package controller.connection.entity.impl;

public class TransferBoolean extends TransferElement {

    private final Boolean value;

    public TransferBoolean(Boolean value) {
        this.value = value;
    }

    public boolean getAccess() {
        return value;
    }

}
