package app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String youtubeUrl;
    private double size;
    private BigDecimal price;
    private String thumbnailUrl;
    private String description;
    private Date realeseDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        char[] word=title.toCharArray();
        if(Character.isUpperCase(word[0]) && word.length>=3 && word.length<=100){
            this.title = title;
        }else{
            throw new IllegalArgumentException("Invalid title");
        }
    }
    public String getYoutubeUrl() {
        return youtubeUrl;
    }
    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        if(size>=0){
            this.size = size;
        }else{
            throw new IllegalArgumentException("Price is invalid");
        }
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        if(price.compareTo(new BigDecimal(-1))>0){
            this.price=price;
        }else{
            throw new IllegalArgumentException("Price is invalid");
        }
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if(description.length()>=20){
            this.description = description;
        }else{
            throw new IllegalArgumentException("Must be at least 20 symbols");
        }
    }
    public Date getRealeseDate() {
        return realeseDate;
    }
    public void setRealeseDate(Date realeseDate) {
        this.realeseDate = realeseDate;
    }
}
