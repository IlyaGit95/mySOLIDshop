package shop;

import products.SoldProduct;
import products.assortment.Product;
import products.assortment.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    static Cart cart;
    private int resultPrise;
    final Scanner scanner = new Scanner(System.in);
    String userSymbol;
    private List<Products> cartList = new ArrayList<>();

    public List<Products> getCartList() {
        return cartList;
    }

    private Cart() {
    }

    private Cart(int resultPrise, List<Products> cartList) {
        this.resultPrise = resultPrise;
        this.cartList = cartList;
    }

    public static Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public int getResultPrise() {
        return resultPrise;
    }

    void startCart() {
        View.printCart(cartList, resultPrise);
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("m")) {
                return;
            } else if (Shop.isInvalidInt(userSymbol, cartList.size() - 1)) {
                removeInCart(userSymbol);
                if (cart.cartList.size() == 0) {
                    cart = null;
                    return;
                }
                View.printCart(cartList, resultPrise);
            } else if (userSymbol.equals("p")) {
                Shop.getShop().getHistory().addOrder(pay());
                System.out.println("Заказ оплачен! Вы можете его посмотреть в истории покупок\n");
                return;
            } else {
                View.invalidSymbol();
            }
        }
    }

    static boolean isCartEmpty() {
        if (cart == null) {
            System.out.println("Корина пуста! выберете другое действие:");
            return false;
        }
        return true;
    }

    void putInCart(List<Products> productsList, String userSymbol) {
        int intUserSymbol = Integer.parseInt(userSymbol);
        System.out.println("Вы выбрали " + productsList.get(intUserSymbol));
        System.out.println("Введите желаемое количество: ");
        int countOfProduct;
        while (true) {
            userSymbol = scanner.nextLine();
            if (Shop.isInvalidInt(userSymbol)) {
                countOfProduct = Integer.parseInt(userSymbol);
                SoldProduct soldProduct = new SoldProduct((Product) productsList.get(intUserSymbol), countOfProduct);
                if (cartList.contains(soldProduct)) {
                    soldProduct = (SoldProduct) cartList.get(cartList.indexOf(soldProduct));
                    soldProduct.addCountOfSold(countOfProduct);
                } else {
                    cartList.add(soldProduct);
                }
                resultPrise += soldProduct.getProduct().getPrise() * countOfProduct;
                System.out.println(soldProduct + ", в корзине!");
                return;
            } else {
                View.invalidSymbol();
            }
        }
    }

    void removeInCart(String userSymbol) {
        int intUserSymbol = Integer.parseInt(userSymbol);
        SoldProduct addedSoldProduct = (SoldProduct) cartList.get(intUserSymbol);
        System.out.println("Вы выбрали " + addedSoldProduct);
        System.out.println("Введите количество: ");
        int countOfRemoveProduct;
        while (true) {
            userSymbol = scanner.nextLine();
            if (Shop.isInvalidInt(userSymbol, addedSoldProduct.getCountOfSold())) {
                countOfRemoveProduct = Integer.parseInt(userSymbol);
                addedSoldProduct.removeCountOfSold(countOfRemoveProduct);
                resultPrise -= addedSoldProduct.getProduct().getPrise() * countOfRemoveProduct;
                if (addedSoldProduct.getCountOfSold() <= 0) {
                    cartList.remove(addedSoldProduct);
                }
                System.out.println(addedSoldProduct.getProduct() + ", в количестве " + countOfRemoveProduct + ", возвращён!");
                return;
            } else {
                View.invalidSymbol();
            }
        }
    }

    Cart pay() {
        Cart order = new Cart(cart.resultPrise,new ArrayList<>(cartList));
        cart = null;
        return order;
    }
}
