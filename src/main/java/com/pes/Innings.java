package com.pes;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;


public class Innings {

    @JsonProperty("1st innings")
    private DeepInnings first;

    @JsonProperty("2nd innings")
    private DeepInnings second;
    
    //private List<Map<String, DeepInnings>> innings;

    public static class Extra {
        private Integer legbyes;
        private Integer wides;
        private Integer noballs;
        private Integer byes;

        public Integer getLegbyes() {
            return legbyes;
        }

        public void setLegbyes(Integer b) {
            legbyes = b;
        }

        public Integer getWides() {
            return wides;
        }

        public void setWides(Integer w) {
            wides = w;
        }

        public Integer getNoballs() {
            return noballs;
        }

        public void setNoballs(Integer n) {
            noballs = n;
        }

        public void setByes(Integer n) {
            byes = n;
        }

        public Integer getByes() {
            return byes;
        }
    }

    public static class Role
    {
        List<Map<String, String>> role;

        public List<Map<String, String>> getRole()
        {
            return role;
        }

        public void setRole(List<Map<String,String>> v) {
            role = v;
        }
    }

    public static class Delivery {
        private String batsman;
        private String bowler;
        private String non_striker;
        private Runs runs;
        private Wicket wicket;
        private Extra extras;
        private Role replacements;

        public Role getReplacements()
        {
            return replacements;
        }

        public void setReplacements(Role r) {
            replacements = r;
        }

        public String getBatsman() {
            return batsman;
        }

        public void setBatsman(String b) {
            batsman = b;
        }

        public String getBowler() {
            return bowler;
        }

        public void setBowler(String b) {
            bowler = b;
        }

        public String getNon_striker() {
            return non_striker;
        }

        public void setNon_striker(String s) {
            non_striker = s;
        }

        public Runs getRuns() {
            return runs;
        }

        public void setRuns(Runs r) {
            runs = r;
        }

        public Wicket getWicket() {
            return wicket;
        }

        public void setWicket(Wicket w) {
            wicket = w;
        }

        public Extra getExtras() {
            return extras;
        }

        public void setExtras(Extra e) {
            extras = e;
        }
    }

    public static class Runs {
        private Integer batsman;
        private Integer extras;
        private Integer total;
        private Integer non_boundary;

        public Integer getBatsman() {
            return batsman;
        }

        public void setBatsman(Integer b) {
            batsman = b;
        }

        public Integer getExtras() {
            return extras;
        }

        public void setExtras(Integer e) {
            extras = e;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer t) {
            total = t;
        }

        public Integer getNon_boundary() {
            return non_boundary;
        }

        public void setNon_boundary(Integer n) {
            non_boundary = n;
        }
    }

    public static class Wicket {
        private List<String> fielders;
        private String kind;
        private String player_out;

        public List<String> getFielders() {
            return fielders;
        }

        public void setFielders(List<String> fl) {
            fielders = fl;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String k) {
            kind = k;
        }

        public String getPlayer_out() {
            return player_out;
        }

        public void setPlayer_out(String p) {
            player_out = p;
        }
    }

    public static class DeepInnings {
        private String team;
        private List<Map<String, Delivery>> deliveries;

        public String getTeam() {
            return team;
        }

        public void setTeam(String t) {
            team = t;
        }

        public List<Map<String, Delivery>> getDeliveries() {
            return deliveries;
        }

        public void setDeliveries(List<Map<String, Delivery>> d) {
            deliveries = d;
        }
    }

    public DeepInnings getFirst() {
        return first;
    }

    public void setFirst(DeepInnings d) {
        first = d;
    }

    public DeepInnings getSecond() {
        return second;
    }

    public void setSecond(DeepInnings d) {
        second = d;
    }

    /*
    public List<Map<String, DeepInnings>> getInnings() {
        return innings;
    }

    public void setInnings(List<Map<String, DeepInnings>> i) {
        innings = i;
    }
    */
}
