package products.assortment;

import products.Category;
import products.Manufacturer;
import products.Rating;

import java.util.Objects;

public abstract class Product implements Products {
    private final String name;
    private final int prise;
    private final Manufacturer manufacturer;
    private final Category category = Category.ABSTRACT;
    private final Rating rating;

    public Product(String name, int prise, Manufacturer manufacturer, Rating rating) {
        this.name = name;
        this.prise = prise;
        this.rating = rating;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getPrise() {
        return prise;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public String getRating() {
        return rating.getResultRating() == null ? "нет оценок" : rating.getResultRating();
    }

    public void addRating(int newUsersResponse) {
        rating.addUsersResponse(newUsersResponse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prise == product.prise && Objects.equals(name, product.name) && manufacturer == product.manufacturer && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prise, manufacturer, category);
    }
}
