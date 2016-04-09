package picture.business;

import java.text.NumberFormat;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture implements Serializable {

    @Id
    private Long pictureId;
    private String artist;
    private String description;
    private String location;
    private boolean sale;
    private int percentage;
    private float price;

    public Picture() {
    }

    /**
     * @return the pictureId
     */
    public Long getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId the pictureId to set
     */
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    /**
     * @return the sale
     */
    public boolean isSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * @return the percentage
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
}
