package controller.entity;

import entity.Result;
import entity.StringResult;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumMatchBuilder {

    public List<SeleniumMatch> getSeleniumMatch(List<WebElement> matchList, String league) {
        List<SeleniumMatch> seleniumMatchList = new ArrayList<>();

        for (WebElement elements : matchList) {
            String getInput = elements.getAttribute("innerText");
            String[] input = getInput.split("\\r?\\n");

            if (!validation(input)) {
                continue;
            }

            SeleniumMatch seleniumMatch = new SeleniumMatch();

            seleniumMatch.setDate(dateToDB(input[0]));

            String[] players = playersToDBForm(input[1]);
            seleniumMatch.setPlayer1(players[0]);
            seleniumMatch.setPlayer2(players[1]);

            seleniumMatch.setResult(scoreToDBForm(input[2]));

            seleniumMatch.setLeague(league);

            seleniumMatchList.add(seleniumMatch);
        }

        return seleniumMatchList;
    }

    private boolean validation(String[] matchDetails) {
        if (matchDetails[1].contains("/")) {
            return false;
        }
        if (matchDetails[1].contains("0:0")) {
            return false;
        }

        return true;
    }

    private String dateToDB(String string) {
        String[] result = string.split(" ");
        String[] tempString = result[0].split("\\.");
        return "2020-" + tempString[1] + '-' + tempString[0] + " " + result[1];
    }

    private String[] playersToDBForm(String players) {
        String[] listOfPlayers;
        listOfPlayers = players.split(" - ");

        listOfPlayers[0] = deleteCommentsFromName(listOfPlayers[0]);
        listOfPlayers[1] = deleteCommentsFromName(listOfPlayers[1]);

        return listOfPlayers;
    }

    private String deleteCommentsFromName(String playerName) {
        int deleteAfterIndex = playerName.lastIndexOf(" ");
        if (deleteAfterIndex != -1) {
            playerName = playerName.substring(0, deleteAfterIndex);
        }

        return playerName;
    }

    private StringResult scoreToDBForm(String score) {
        StringResult stringResult = new StringResult();
        String clearScore = "";
        String[] listOfScores;
        score = score.replaceFirst(" ", ",");
        for (char ch : score.toCharArray()) {
            if (ch != '(' && ch != ')') {
                clearScore += ch;
            }
        }
        listOfScores = clearScore.split(",");
        stringResult.setScore(listOfScores[0]);
        for (int i = 0; i < listOfScores.length; i++) {
            stringResult.setSet(i, listOfScores[i]);
        }
        return stringResult;
    }

}
