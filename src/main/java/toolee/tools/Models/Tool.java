package toolee.tools.Models;

import toolee.tools.Enums.Category;
import toolee.tools.Enums.Status;

import javax.persistence.*;

@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String imageUrl;
    private double price;
    private Status status;
    private String description;
    private Category category;

    @ManyToOne
    private AppUser appUser;

    public Tool(){
    }

    public Tool(String name, String imageUrl, double price, Status status, String description, Category category,AppUser appUser) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.status = status;
        this.description = description;
        this.category = category;
        this.setAppUser(appUser);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
