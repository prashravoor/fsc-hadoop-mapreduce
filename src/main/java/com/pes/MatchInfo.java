package com.pes;

import java.util.List;

class Outcome {
    private static class By {
        private Integer runs;
        private Integer wickets;

        public Integer getRuns() {
            return runs;
        }

        public void setRuns(Integer runs) {
            this.runs = runs;
        }

        public Integer getWickets() {
            return wickets;
        }

        public void setWickets(Integer w) {
            this.wickets = w;
        }

    }

    private By by;
    private String winner;
    private String method;

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String w) {
        this.winner = w;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String m) {
        method = m;
    }
}

class Toss {
    private String decision;
    private String winner;

    public String getDecision() {
        return this.decision;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setDecision(String d) {
        this.decision = d;
    }
}

public class MatchInfo {
    private String city;
    private String competition;
    private List<String> dates;
    private String gender;
    private String match_type;
    private Outcome outcome;
    private Integer overs;
    private List<String> player_of_match;
    private List<String> teams;
    private Toss toss;
    private List<String> umpires;
    private String venue;
    private String neutral_venue;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String c) {
        competition = c;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String g) {
        gender = g;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String type) {
        match_type = type;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome o) {
        outcome = o;
    }

    public Integer getOvers() {
        return overs;
    }

    public void setOvers(Integer i) {
        overs = i;
    }

    public List<String> getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(List<String> l) {
        player_of_match = l;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> t) {
        teams = t;
    }

    public Toss getToss() {
        return toss;
    }

    public void setToss(Toss t) {
        toss = t;
    }

    public List<String> getUmpires() {
        return umpires;
    }

    public void setUmpires(List<String> u) {
        umpires = u;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String v) {
        venue = v;
    }

    public String getNeutral_venue() {
        return neutral_venue;
    }

    public void setNeutral_venue(String v) {
        neutral_venue = v;
    }


}
