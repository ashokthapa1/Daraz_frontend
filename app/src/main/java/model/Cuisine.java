package model;

public class Cuisine {
    private String cuisine_name,
    cuisine_description, cuisine_image;
    private int cuisine_category_id, cuisine_price;

    public Cuisine(String cuisine_name, String cuisine_description, String cuisine_image, int cuisine_category_id, int cuisine_price) {
        this.cuisine_name = cuisine_name;
        this.cuisine_description = cuisine_description;
        this.cuisine_image = cuisine_image;
        this.cuisine_category_id = cuisine_category_id;
        this.cuisine_price = cuisine_price;
    }

    public String getCuisine_name() {
        return cuisine_name;
    }

    public void setCuisine_name(String cuisine_name) {
        this.cuisine_name = cuisine_name;
    }

    public String getCuisine_description() {
        return cuisine_description;
    }

    public void setCuisine_description(String cuisine_description) {
        this.cuisine_description = cuisine_description;
    }

    public String getCuisine_image() {
        return cuisine_image;
    }

    public void setCuisine_image(String cuisine_image) {
        this.cuisine_image = cuisine_image;
    }

    public int getCuisine_category_id() {
        return cuisine_category_id;
    }

    public void setCuisine_category_id(int cuisine_category_id) {
        this.cuisine_category_id = cuisine_category_id;
    }

    public int getCuisine_price() {
        return cuisine_price;
    }

    public void setCuisine_price(int cuisine_price) {
        this.cuisine_price = cuisine_price;
    }
}
