package com.example.myapplication.model.example;

public class Scor {
    private String echipa1;
    private String echipa2;
    private String scor;

    public Scor() {
    }

    public Scor(String echipa1, String echipa2, String scor) {
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
        this.scor = scor;
    }

    public String getEchipa1() {
        return echipa1;
    }

    public void setEchipa1(String echipa1) {
        this.echipa1 = echipa1;
    }

    public String getEchipa2() {
        return echipa2;
    }

    public void setEchipa2(String echipa2) {
        this.echipa2 = echipa2;
    }

    public String getScor() {
        return scor;
    }

    public void setScor(String scor) {
        this.scor = scor;
    }
}
