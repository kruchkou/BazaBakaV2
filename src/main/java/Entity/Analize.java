package Entity;

public class Analize {

    private int winResult;
    private int foraResult;
    private int totalResult;

    //region GSC

    public Analize(int winResult, int foraResult, int totalResult) {
        this.winResult = winResult;
        this.foraResult = foraResult;
        this.totalResult = totalResult;
    }

    public int getWinResult() {
        return winResult;
    }

    public int getForaResult() {
        return foraResult;
    }

    public int getTotalResult() {
        return totalResult;
    }
    //endregion
}
