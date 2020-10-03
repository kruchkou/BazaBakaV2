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

    public void addAll(SeleniumMatchList seleniumMatchList) {
        matchList.addAll(seleniumMatchList.getMatchList());
    }

    public int size() {
        return matchList.size();
    }
}
