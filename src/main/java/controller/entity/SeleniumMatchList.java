package controller.entity;

import controller.SeleniumController;

import java.util.ArrayList;
import java.util.List;

public class SeleniumMatchList {

    List<SeleniumMatch> matchList = new ArrayList<>();

    public List<SeleniumMatch> getMatchList() {
        return matchList;
    }

    public void add(SeleniumMatch seleniumMatch) {
        matchList.add(seleniumMatch);
    }

    public String getLastMatchDate() {
        String lastDate = null;

        if (matchList.size() > 0) {
            lastDate = matchList.get(0).getDate();

            for (SeleniumMatch seleniumMatch : matchList) {
                String matchDate = seleniumMatch.getDate();

                if (matchDate.compareTo(lastDate) > 0) {
                    lastDate = matchDate;
                }
            }
        }
        return lastDate;
    }

    public void addAll(SeleniumMatchList seleniumMatchList) {
        matchList.addAll(seleniumMatchList.getMatchList());
    }

    public int size() {
        return matchList.size();
    }
}
