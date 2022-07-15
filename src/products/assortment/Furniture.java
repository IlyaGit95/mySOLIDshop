package products.assortment;

import products.Category;
import products.Manufacturer;
import products.Rating;

public class Furniture extends Product{
    private final Category category = Category.FURNITURE;

    public Furniture(String name, int prise, Manufacturer manufacturer, Rating rating) {
        super(name, prise, manufacturer, rating);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Мебель: " + this.getName() +
                " " + this.getManufacturer() +
                ", цена: " + this.getPrise() +
                ", рейтинг: " + this.getRating();
    }
}
