package products;

import products.assortment.Product;
import products.assortment.Products;

import java.util.Objects;

public class SoldProduct implements Products {
    private final Product product;
    private int countOfSold;
    private int totalPrise;

    public SoldProduct(Product product, int countOfSold) {
        this.product = product;
        this.countOfSold = countOfSold;
        setTotalPrise();
    }

    public Product getProduct() {
        return product;
    }

    public int getCountOfSold() {
        return countOfSold;
    }

    public void addCountOfSold(int countOfSold) {
        this.countOfSold += countOfSold;
        setTotalPrise();
    }

    public void removeCountOfSold(int countOfSold) {
        this.countOfSold -= countOfSold;
        setTotalPrise();
    }

    public int getTotalPrise() {
        return totalPrise;
    }

    private void setTotalPrise() {
        this.totalPrise = product.getPrise()*countOfSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldProduct that = (SoldProduct) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return product +
                " количество: " + countOfSold +
                ", на сумму: " + totalPrise;
    }
}
