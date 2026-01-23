package fr.eni.encheres.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private long idCategory;
    private String name;
    private List<Article> articleCateList = new ArrayList<>();

    public Category() {
    }

    /**
     * @param idCategory
     * @param name
     * @param articleCateList
     */
    public Category(long idCategory, String name, List<Article> articleCateList) {
        this.idCategory = idCategory;
        this.name = name;
        this.articleCateList = articleCateList;
    }

    /**
     * @param name
     * @param articleCateList
     */
    public Category(String name, List<Article> articleCateList) {
        this.name = name;
        this.articleCateList = articleCateList;
    }

    /**
     * @param idCategory
     * @param name
     */
    public Category(long idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    /**
     * @param name
     */
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

    public List<Article> getArticleCateList() {
        return articleCateList;
    }

    public void setArticleCateList(List<Article> articleCateList) {
        this.articleCateList = articleCateList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("idCategory=").append(idCategory);
        sb.append(", name='").append(name).append('\'');
        sb.append(", articleCateList=").append(articleCateList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return idCategory == category.idCategory && name.equals(category.name) && articleCateList.equals(category.articleCateList);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idCategory);
        result = 31 * result + name.hashCode();
        result = 31 * result + articleCateList.hashCode();
        return result;
    }
}
