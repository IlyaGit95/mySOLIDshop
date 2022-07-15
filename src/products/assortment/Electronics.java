package products.assortment;

import products.Category;
import products.Manufacturer;
import products.Rating;

public class Electronics extends Product {
    private final Category category = Category.ELECTRONICS;

    public Electronics(String name, int prise, Manufacturer manufacturer, Rating rating) {
        super(name, prise, manufacturer, rating);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Электроника: " + this.getName() +
                " " + this.getManufacturer() +
                ", цена: " + this.getPrise() +
                ", рейтинг: " + this.getRating();
    }
}
