package shop;

import products.Manufacturer;
import products.Rating;
import products.assortment.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shop {

    private static Shop shop = null;
    final Scanner scanner = new Scanner(System.in);
    String userSymbol;
    private Cart cart;
    private final History history = new History();
    Filter filter = new Filter();

    private final List<Products> allProductsList = Arrays.asList(
            new Food("Хлеб-нарезной", 30, Manufacturer.PROMTORG, new Rating(new Integer[]{3, 4, 4})),
            new Food("Молоко 2.5%", 90, Manufacturer.PROMTORG, new Rating()),
            new Food("Хлеб с отрубями", 45, Manufacturer.MIRATORG, new Rating(new Integer[]{3, 5, 4})),
            new Food("Молоко 3.2%", 130, Manufacturer.MIRATORG, new Rating()),
            new Food("Яйца-куриные 10 шт", 150, Manufacturer.MIRATORG, new Rating(new Integer[]{5, 4, 5})),
            new Electronics("Телевизор UE32T5300 Full HD", 26390, Manufacturer.SAMSUNG, new Rating(new Integer[]{3, 2, 4})),
            new Electronics("Микроволновая печь MS23K3614AK", 14115, Manufacturer.SAMSUNG, new Rating(new Integer[]{1, 4, 5})),
            new Electronics("Телевизор 32LM577BPLA HD", 26990, Manufacturer.LG, new Rating()),
            new Electronics("Микроволновая печь MS2042DB", 9430, Manufacturer.LG, new Rating(new Integer[]{5, 4, 4, 3})),
            new Electronics("Холодильник GA-B419SDJL", 62489, Manufacturer.LG, new Rating()),
            new Clothes("Поло", 13986, Manufacturer.LACOSTE, new Rating()),
            new Clothes("Толстовка", 15480, Manufacturer.LACOSTE, new Rating(new Integer[]{4, 4})),
            new Clothes("Джинсы", 18480, Manufacturer.LACOSTE, new Rating()),
            new Clothes("Толстовка", 3299, Manufacturer.PULLANDBEAR, new Rating(new Integer[]{3, 4, 4, 5})),
            new Clothes("Джинсы", 4000, Manufacturer.PULLANDBEAR, new Rating(new Integer[]{2, 4, 4})),
            new Furniture("Стул", 5890, Manufacturer.IKEA, new Rating()),
            new Furniture("Письменный стол", 26300, Manufacturer.IKEA, new Rating(new Integer[]{1, 4, 4})),
            new Furniture("Кровать", 16890, Manufacturer.IKEA, new Rating(new Integer[]{3, 5, 5})),
            new Furniture("Стул", 3999, Manufacturer.SHATURA, new Rating(new Integer[]{3, 4, 4, 5})),
            new Furniture("Письменный стол", 12140, Manufacturer.SHATURA, new Rating())
    );

    List<Products> filterList = allProductsList;

    private Shop() {
    }

    public List<Products> getAllProductsList() {
        return allProductsList;
    }

    public List<Products> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Products> filterList) {
        this.filterList = filterList;
    }

    public Cart getCart() {
        return cart;
    }

    public History getHistory() {
        return history;
    }

    public static Shop getShop() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }

    public void startShop() {
        shopMenu();
    }

    private void shopMenu() {
        View.printMenu();

        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("e")) {
                return;
            } else if (userSymbol.equals("a")) {
                filterList = allProductsList;
                productsForSale();
                View.printMenu();
            } else if (userSymbol.equals("f")) {
                filterList = allProductsList;
                filter.startFilter();
                View.printMenu();
            } else if (userSymbol.equals("k")) {
                if (Cart.isCartEmpty()) {
                    cart.startCart();
                }
                View.printMenu();
            } else if (userSymbol.equals("h")) {
                history.startHistory();
                View.printMenu();
            } else {
                View.invalidSymbol();
            }
        }
    }

    protected void productsForSale() {
        View.printAllProducts(filterList);

        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("m")) {
                return;
            } else if (userSymbol.equals("k")) {
                if (Cart.isCartEmpty()) {
                    cart.startCart();
                    return;
                }
            } else if (userSymbol.equals("f")) {
                filter.startFilter();
                return;
            } else if (isInvalidInt(userSymbol, filterList.size() - 1)) {
                cart = Cart.getCart();
                cart.putInCart(filterList, userSymbol);
                View.printAllProducts(filterList);
            } else {
                View.invalidSymbol();
            }
        }
    }


    static boolean isInvalidInt(String symbol, int maxCount) {
        try {
            int intUserSymbol = Integer.parseInt(symbol);
            if (intUserSymbol >= 0 && intUserSymbol <= maxCount) {
                return true;
            }
        } catch (RuntimeException e) {
            return false;
        }
        return false;
    }

    static boolean isInvalidInt(String symbol) {
        try {
            int intUserSymbol = Integer.parseInt(symbol);
            if (intUserSymbol > 0) {
                return true;
            }
        } catch (RuntimeException e) {
            return false;
        }
        return false;
    }


}
