package fr.eni.encheres.entity;

import java.util.Objects;

public class Searching {

    private String category;
    private String label;

    public Searching() {
    }

    public Searching(String category, String label) {
        this.category = category;
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Searching searching = (Searching) o;
        return Objects.equals(getCategory(), searching.getCategory()) && Objects.equals(getLabel(), searching.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getLabel());
    }

    @Override
    public String toString() {
        return "Searching{" +
                "category='" + category + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
