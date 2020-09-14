package entity;

import entity.dbEntity.MatchesLEntity;

public class Match {

    private String date;
    private String player1;
    private String player2;
    private Result result;
    private String league;
    private double winR1;
    private double winR2;

    public void reverse() {
        result.reverse();
        reversePlayers();
        reverseWinR();
    }

    private void reverseWinR() {
        double temp = winR1;
        winR1 = winR2;
        winR2 = temp;
    }

    private void reversePlayers() {
        String tempString = player1;
        player1 = player2;
        player2 = tempString;
    }

    public String toString() {
        return String.format("%s| %s| %d| %d| %d| %d| %d\n", dateByApp(), result.score(), result.getP1Fora(), result.getP1Total(),
                result.getP2Fora(), result.getP2Total(), result.getTotal());
    }

    public String toStringWinR() {
        return String.format("%s| %s| %d| %d| %d| %d| %d| %.0f | %.0f\n", dateByApp(), result.score(), result.getP1Fora(), result.getP1Total(),
                result.getP2Fora(), result.getP2Total(), result.getTotal(), winR1, winR2);
    }

    //region GSC


    public double getWinR1() {
        return winR1;
    }

    public double getWinR2() {
        return winR2;
    }

    public Match(MatchesLEntity match) {
        this.date = match.getDate();
        this.player1 = match.getPlayer1().getName();
        this.player2 = match.getPlayer2().getName();
        this.result = new Result(match.getResult());
        this.league = match.getLeague().getName();
        setWinRs(match);
    }

    private void setWinRs(MatchesLEntity match) {
        final double NULL_WINR_VALUE = 0.123;
        Double matchWinR1 = match.getWinR1();
        Double matchWinR2 = match.getWinR2();
        if(matchWinR1 == null) {
            winR1 = NULL_WINR_VALUE;
        }
        if(matchWinR2 == null) {
            winR2 = NULL_WINR_VALUE;
        }
        else {
            winR1 = matchWinR1;
            winR2 = matchWinR2;
        }
    }

    public String getDate() {
        return DateFormater.getDate(this.date);
    }

    public String dateByApp() {
        return DateFormater.dateByApp(this.date);
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public Result getResult() {
        return result;
    }

    public String getLeague() {
        return league;
    }
    //endregion
}
