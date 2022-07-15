package shop;

import products.Category;
import products.Manufacturer;
import products.assortment.Products;

import java.util.List;

public class View {

    static void explanation() {
        System.out.println("############################################################\n" +
                "Введите символ указанный в кавычках что бы выбрать действие:\n");
    }

    static void invalidSymbol() {
        System.out.println("Не верный ввод данных! повторите попытку:");
    }

    static void printMenu() {
        explanation();
        System.out.println("<МЕНЮ>");
        System.out.println("\"a\" -> Список всех товаров\n" +
                "\"f\" -> Фильтр товаров\n" +
                "\"k\" -> Корзина\n" +
                "\"h\" -> История покупок\n" +
                "\"e\" -> завершение программы\n");
    }

    static void printAllProducts(List<Products> filterList) {
        View.explanation();
        System.out.println("<СПИСОК ДОСТУПНЫХ ТОВАРОВ>");
        printFilterList(filterList);
        System.out.println("\n\"<номер товара>\" -> Введите номер товара для покупки\n" +
                "\"f\" -> Применить фильтр к данному списку\n" +
                "\"k\" -> Перейти корзину\n" +
                "\"m\" -> Вернуться в меню\n");
    }

    static void printFilterList(List<Products> filterList) {
        if (filterList.size() == 0) {
            System.out.println("Нет доступных товаров по вашему запросу!");
            return;
        }
        for (int i = 0; i < filterList.size(); i++) {
            System.out.println("\"" + i + "\" " + filterList.get(i));
        }
    }

    static void printCart(List<Products> filterList, int resultPrise) {
        View.explanation();
        System.out.println("<КОРЗИНА>");
        System.out.println("Ваша корзина: ");
        printFilterList(filterList);
        System.out.println("ИТОГОВАЯ СУММА: " + resultPrise);
        System.out.println("\n\"<номер товара>\" -> Введите номер товара для удаления из корзины\n" +
                "\"p\" -> оплатить товары\n" +
                "\"m\" -> Вернуться в меню\n");
    }

    static void printHistory(List<Cart> historyList) {
        View.explanation();
        System.out.println("<ИСТОРИЯ ПОКУПОК>");
        int numberOrder = 0;
        for (Cart cart : historyList) {
            System.out.println("\nЗаказ номер -> " + "\"" + numberOrder++ + "\"");
            for (int i = 0; i < cart.getCartList().size(); i++) {
                System.out.println("\"" + i + "\" " + cart.getCartList().get(i));
            }
            System.out.println("ИТОГОВАЯ СУММА: " + cart.getResultPrise());
        }
        System.out.println("\n\"<номер заказа>\" -> Введите номер заказа для возврата или оценки товара\n" +
                "\"m\" -> Вернуться в меню\n");
    }

    static void printFilter() {
        View.explanation();
        System.out.println("<ФИЛЬТР ТОВАРОВ>");
        System.out.println("Выберите способ фильтрации:");
        System.out.println("\"p\" -> Цена\n" +
                "\"i\" -> Производитель\n" +
                "\"s\" -> Ключевое слово\n" +
                "\"c\" -> Категории\n" +
                "\"m\" -> Вернуться в меню\n");
    }

    static void printManufactureFilter() {
        System.out.println("Выберите производителя:\n" +
                "\"pg\" -> " + Manufacturer.PROMTORG.getManufacturerName() + "\n" +
                "\"mg\" -> " + Manufacturer.MIRATORG.getManufacturerName() + "\n" +
                "\"sg\" -> " + Manufacturer.SAMSUNG.getManufacturerName() + "\n" +
                "\"lg\" -> " + Manufacturer.LG.getManufacturerName() + "\n" +
                "\"le\" -> " + Manufacturer.LACOSTE.getManufacturerName() + "\n" +
                "\"pr\" -> " + Manufacturer.PULLANDBEAR.getManufacturerName() + "\n" +
                "\"ia\" -> " + Manufacturer.IKEA.getManufacturerName() + "\n" +
                "\"sa\" -> " + Manufacturer.SHATURA.getManufacturerName() + "\n");
    }

    static void printCategoriesFilter() {
        System.out.println("Выберите тип продукта:\n" +
                "\"f\" -> " + Category.FOOD.getCategoryName() + "\n" +
                "\"e\" -> " + Category.ELECTRONICS.getCategoryName() + "\n" +
                "\"c\" -> " + Category.CLOTHES.getCategoryName() + "\n" +
                "\"u\" -> " + Category.FURNITURE.getCategoryName() + "\n");
    }
}
