package controller.connection.entity;

public class TransferString implements TransferInterface {

    private final String value;

    public TransferString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
