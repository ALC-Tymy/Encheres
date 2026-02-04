package fr.eni.encheres.entity.dto;

public class ProposalLog {
    private long idArticle;
    private long idSeller;
    private long idBuyer;
    private int price;

    public ProposalLog() {
    }

    public ProposalLog(long idArticle, long idSeller, long idBuyer, int price) {
        this.idArticle = idArticle;
        this.idSeller = idSeller;
        this.idBuyer = idBuyer;
        this.price = price;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public long getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(long idSeller) {
        this.idSeller = idSeller;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(long idBuyer) {
        this.idBuyer = idBuyer;
    }

    @Override
    public String toString() {
        return "ProposalLog{" +
                "idArticle=" + idArticle +
                ", idSeller=" + idSeller +
                ", idBuyer=" + idBuyer +
                ", price=" + price +
                '}';
    }
}
