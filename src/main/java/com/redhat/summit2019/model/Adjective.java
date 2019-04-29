package com.redhat.summit2019.model;

import java.util.Objects;

public class Adjective {

    private String adjective;


    public Adjective() {
    }

    public Adjective(String adjective) {
        this.adjective = adjective;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adjective adjective1 = (Adjective) o;
        return Objects.equals(getAdjective(), adjective1.getAdjective());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAdjective());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Adjective{");
        sb.append("adjective='").append(adjective).append('\'');
        sb.append('}');
        return sb.toString();
    }

}