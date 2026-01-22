package fr.eni.encheres.bo;

public class Category {

    private long idCategory;
    private String name;

    public Category() {
    }

    public Category(long idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("idCategory=").append(idCategory);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return idCategory == category.idCategory && name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idCategory);
        result = 31 * result + name.hashCode();
        return result;
    }
}
