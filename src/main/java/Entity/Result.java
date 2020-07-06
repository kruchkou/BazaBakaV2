package Entity;

import Entity.DBEntity.ResultEntity;

public class Result {

    private int p1Score;
    private int p2Score;

    private int p1Fora = 0;
    private int p2Fora = 0;

    private int p1Total = 0;
    private int p2Total = 0;

    private int total = 0;

    private final int P1_WINNER_VALUE = 1;
    private final int P2_WINNER_VALUE = 2;


    private int[] splitString(String score) {
        int[] result = new int[2];

        String[] splitedString = score.split(":");
        result[0] = Integer.parseInt(splitedString[0]);
        result[1] = Integer.parseInt(splitedString[1]);

        return result;
    }

    public String score() {
        return p1Score + ":" + p2Score;
    }

    public int winner() {
        if (p1Score > p2Score) {
            return P1_WINNER_VALUE;
        }
        return P2_WINNER_VALUE;
    }

    public void reverse() {
        int tempNum = p1Score;
        p1Score = p2Score;
        p2Score = tempNum;

        tempNum = p1Total;
        p1Total = p2Total;
        p2Total = tempNum;

        tempNum = p1Fora;
        p1Fora = p2Fora;
        p2Fora = tempNum;
    }

    //region GSC

    public Result(ResultEntity result) {
        setScores(splitString(result.getScore()));
        setTotals(result.setsToArrString());
        setForas();
    }

    private void setScores(int[] score) {
        p1Score = score[0];
        p2Score = score[1];
    }

    private void setForas() {
        p1Fora = p1Total - p2Total;
        p2Fora = p2Total - p1Total;
    }


    private void setTotals(String[] sets) {
        for (String set : sets) {

            if (set.equals("null")) {
                continue;
            }

            int[] splitedSet = splitString(set);
            p1Total += splitedSet[0];
            p2Total += splitedSet[1];
            total = p1Total + p2Total;
        }
    }

    public int getP1Score() {
        return p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public int getP1Fora() {
        return p1Fora;
    }

    public int getP2Fora() {
        return p2Fora;
    }

    public int getP1Total() {
        return p1Total;
    }

    public int getP2Total() {
        return p2Total;
    }

    public int getTotal() {
        return total;
    }
    //endregion
}
