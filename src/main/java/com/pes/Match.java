package com.pes;

import java.util.List;
import java.util.Map;


public class Match {
    private Meta meta;
    private MatchInfo info;
    // private Map<String, List<Innings>> innings;
    private List<Innings> innings;

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public MatchInfo getInfo() {
        return this.info;
    }

    public void setInfo(MatchInfo info) {
        this.info = info;
    }

    public List<Innings> getInnings() {
        return this.innings;
    }

    public void setInnings(List<Innings> innings) {
        this.innings = innings;
    }
}