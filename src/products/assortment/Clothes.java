package products.assortment;

import products.Category;
import products.Manufacturer;
import products.Rating;

public class Clothes extends Product{
    private final Category category = Category.CLOTHES;

    public Clothes(String name, int prise, Manufacturer manufacturer, Rating rating) {
        super(name, prise, manufacturer, rating);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Одежда: " + this.getName() +
                " " + this.getManufacturer() +
                ", цена: " + this.getPrise() +
                ", рейтинг: " + this.getRating();
    }
}
