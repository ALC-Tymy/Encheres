package fr.eni.encheres.entity;

public class Searching {

    private String category;

    public Searching() {
    }

    public Searching(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Searching{" +
                "category='" + category + '\'' +
                '}';
    }
}
