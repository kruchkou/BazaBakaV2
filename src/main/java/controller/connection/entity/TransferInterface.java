package controller.connection.entity;

import entity.MatchList;

import java.io.Serializable;

public interface TransferInterface extends Serializable {

    default MatchList getAsMatchList() {
        return (MatchList) this;
    }

    default TransferBoolean getAsAccess() {
        return (TransferBoolean) this;
    }

    default TransferString getAsTransferString() {
        return (TransferString) this;
    }

    default TransferStringList getAsTransferStringList() {
        return (TransferStringList) this;
    }

}
