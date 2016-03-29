package ru.mephi.goedosa.entity;

/**
 * Created by artemsamsonov on 16.03.16.
 */
public class Entry extends Entity {

    private String termin;
    private String definition;
    //TODO specialities


    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "definition='" + definition + '\'' +
                ", termin='" + termin + '\'' +
                '}';
    }
}
