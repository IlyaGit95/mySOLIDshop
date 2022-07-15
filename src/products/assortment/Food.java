package products.assortment;

import products.Category;
import products.Manufacturer;
import products.Rating;

public class Food extends Product {
    private final Category category = Category.FOOD;

    public Food(String name, int prise, Manufacturer manufacturer, Rating rating) {
        super(name, prise, manufacturer, rating);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Продукт питания: " + this.getName() +
                ", цена: " + this.getPrise() +
                ", изготовитель: " + this.getManufacturer().getManufacturerName() +
                ", рейтинг: " + this.getRating();
    }
}
