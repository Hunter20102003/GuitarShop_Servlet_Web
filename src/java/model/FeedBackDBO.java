

package model;
import java.sql.Date;

public class FeedBackDBO {
    private int id;
    private int idProduct;
    private int idUser;
    private int rating;
    private String feedback;
    private Date date;

    public FeedBackDBO() {
    }

    public FeedBackDBO(int id, int idProduct, int idUser, int rating, String feedback, Date date) {
        this.id = id;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.rating = rating;
        this.feedback = feedback;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FeedBackDBO{" + "id=" + id + ", idProduct=" + idProduct + ", idUser=" + idUser + ", rating=" + rating + ", feedback=" + feedback + ", date=" + date + '}';
    }
    
}
