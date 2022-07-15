package shop;

import products.SoldProduct;
import products.assortment.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History {
    List<Cart> historyList;
    final Scanner scanner = new Scanner(System.in);
    String userSymbol;

    boolean isHistoryEmpty() {
        if (historyList == null || historyList.size() == 0) {
            System.out.println("История покупок пуста! выберете другой пункт:");
            return true;
        }
        return false;
    }

    void startHistory() {
        if (isHistoryEmpty()) {
            return;
        }
        View.printHistory(historyList);
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("m")) {
                return;
            } else if (Shop.isInvalidInt(userSymbol, historyList.size() - 1)) {
                raringOrReturn(userSymbol);
                if (isHistoryEmpty()) {
                    return;
                }
                View.printHistory(historyList);
            } else {
                View.invalidSymbol();
            }
        }
    }

    void raringOrReturn(String userSymbol) {
        int numberOfOrder = Integer.parseInt(userSymbol);
        Cart order = historyList.get(numberOfOrder);
        System.out.println("Введите номер позиции товара в заказе:");
        while (true) {
            userSymbol = scanner.nextLine();
            if (Shop.isInvalidInt(userSymbol, order.getCartList().size() - 1)) {
                int intUserSymbol = Integer.parseInt(userSymbol);
                SoldProduct soldProduct = (SoldProduct) order.getCartList().get(intUserSymbol);
                System.out.println("Вы выбрали: " + soldProduct);
                System.out.println("Выберете действие:");
                System.out.println("\"r\" -> Оценить товар\n" +
                        "\"b\" -> Вернуть товар\n" +
                        "\"h\" -> Отмена действия\n");
                while (true) {
                    userSymbol = scanner.nextLine();
                    if (userSymbol.equals("r")) {
                        addUserRating(soldProduct.getProduct());
                        return;
                    } else if (userSymbol.equals("b")) {
                        order.removeInCart(String.valueOf(order.getCartList().indexOf(soldProduct)));
                        if (order.getCartList().size() == 0) {
                            historyList.remove(numberOfOrder);
                        }
                        return;
                    } else if (userSymbol.equals("h")) {
                        return;
                    } else {
                        View.invalidSymbol();
                    }
                }
            } else {
                View.invalidSymbol();
            }
        }
    }

    void addUserRating(Product product) {
        System.out.println("Введите вашу оценку (от 1 до 5 включительно) товара : " + product);
        while (true) {
            userSymbol = scanner.nextLine();
            if (Shop.isInvalidInt(userSymbol)) {
                int intUserSymbol = Integer.parseInt(userSymbol);
                if (intUserSymbol >= 1 && intUserSymbol <= 5) {
                    product.addRating(intUserSymbol);
                    System.out.println("Спасибо за вашу оценку!");
                    return;
                } else {
                    View.invalidSymbol();
                }
            } else {
                View.invalidSymbol();
            }
        }
    }

    void addOrder(Cart order) {
        if (historyList == null) {
            historyList = new ArrayList<>();
        }
        historyList.add(order);
    }
}
