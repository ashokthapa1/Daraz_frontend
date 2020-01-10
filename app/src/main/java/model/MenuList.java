package model;

public class MenuList {
    private int cuisine_id, cuisine_price,cuisine_category_id;
    private String cuisine_name, cuisine_description,cuisine_image;

    public MenuList(int cuisine_id, int cuisine_price, int cuisine_category_id, String cuisine_name, String cuisine_description, String cuisine_image) {
        this.cuisine_id = cuisine_id;
        this.cuisine_price = cuisine_price;
        this.cuisine_category_id = cuisine_category_id;
        this.cuisine_name = cuisine_name;
        this.cuisine_description = cuisine_description;
        this.cuisine_image = cuisine_image;
    }

    public int getCuisine_id() {
        return cuisine_id;
    }

    public int getCuisine_price() {
        return cuisine_price;
    }

    public int getCuisine_category_id() {
        return cuisine_category_id;
    }

    public String getCuisine_name() {
        return cuisine_name;
    }

    public String getCuisine_description() {
        return cuisine_description;
    }

    public String getCuisine_image() {
        return cuisine_image;
    }
}
