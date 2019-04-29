package com.redhat.summit2019.model;

public class Insult {

    Adjective adjective1;

    Adjective adjective2;

    Noun noun;

    public Insult(Adjective adjective1, Adjective adjective2, Noun noun) {
        this.adjective1 = adjective1;
        this.adjective2 = adjective2;
        this.noun = noun;
    }

    public String getInsult() {
        StringBuilder builder = new StringBuilder();
        builder.append("Verily, ye be a ");
        builder.append(adjective1.getAdjective());
        builder.append(", ");
        builder.append(adjective2.getAdjective());
        builder.append(" ");
        builder.append(noun.getNoun());
        builder.append("!");
        return builder.toString();
    }

    public Insult() {
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"insult\":\"");
        builder.append(getInsult());
        builder.append("\"");
        builder.append("}");
        return builder.toString();

    }

    public Adjective getAdjective1() {
        return adjective1;
    }

    public void setAdjective1(Adjective adjective1) {
        this.adjective1 = adjective1;
    }

    public Adjective getAdjective2() {
        return adjective2;
    }

    public void setAdjective2(Adjective adjective2) {
        this.adjective2 = adjective2;
    }

    public Noun getNoun() {
        return noun;
    }

    public void setNoun(Noun noun) {
        this.noun = noun;
    }

}