package controller.connection.entity;

public class TransferBoolean implements TransferInterface {

    private final Boolean value;

    public TransferBoolean(Boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

}
