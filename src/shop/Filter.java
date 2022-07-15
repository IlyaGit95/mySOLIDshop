package shop;

import products.Category;
import products.Manufacturer;
import products.assortment.Product;
import products.assortment.Products;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Filter {
    final Scanner scanner = new Scanner(System.in);
    String userSymbol;

    void startFilter() {
        View.printFilter();
        List<Products> filterList = Shop.getShop().getFilterList();
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("m")) {
                return;
            } else if (userSymbol.equals("i")) {
                filterList = manufactureFilter(filterList);
                break;
            } else if (userSymbol.equals("s")) {
                filterList = keywordFilter(filterList);
                break;
            } else if (userSymbol.equals("p")) {
                filterList = priseFilter(filterList);
                break;
            } else if (userSymbol.equals("c")) {
                filterList = categoriesFilter(filterList);
                break;
            } else {
                View.invalidSymbol();
            }
        }

        Shop.getShop().setFilterList(filterList);
        Shop.getShop().productsForSale();
    }

    List<Products> priseFilter(List<Products> filterList) {
        System.out.println("Выберите действие:\n" +
                "\"u\" -> Отсортировать по возрастанию цен\n" +
                "\"l\" -> Отсортировать по убыванию цен\n");
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("u")) {
                return filterList.stream()
                        .sorted((product1, product2) -> ((Product) product1).getPrise() - ((Product) product2).getPrise())
                        .collect(Collectors.toList());
            } else if (userSymbol.equals("l")) {
                return filterList.stream()
                        .sorted((product1, product2) -> ((Product) product2).getPrise() - ((Product) product1).getPrise())
                        .collect(Collectors.toList());

            } else {
                View.invalidSymbol();
            }
        }
    }

    List<Products> manufactureFilter(List<Products> filterList) {
        View.printManufactureFilter();
        Manufacturer manufacturer;
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("pg")) {
                manufacturer = Manufacturer.PROMTORG;
                break;
            } else if (userSymbol.equals("mg")) {
                manufacturer = Manufacturer.MIRATORG;
                break;
            } else if (userSymbol.equals("sg")) {
                manufacturer = Manufacturer.SAMSUNG;
                break;
            } else if (userSymbol.equals("lg")) {
                manufacturer = Manufacturer.LG;
                break;
            } else if (userSymbol.equals("le")) {
                manufacturer = Manufacturer.LACOSTE;
                break;
            } else if (userSymbol.equals("pr")) {
                manufacturer = Manufacturer.PULLANDBEAR;
                break;
            } else if (userSymbol.equals("ia")) {
                manufacturer = Manufacturer.IKEA;
                break;
            } else if (userSymbol.equals("sa")) {
                manufacturer = Manufacturer.SHATURA;
                break;
            } else {
                View.invalidSymbol();
            }
        }
        return filterList.stream()
                .filter(product -> ((Product) product).getManufacturer().equals(manufacturer))
                .collect(Collectors.toList());
    }


    List<Products> categoriesFilter(List<Products> filterList) {
        View.printCategoriesFilter();
        Category category;
        while (true) {
            userSymbol = scanner.nextLine();
            if (userSymbol.equals("f")) {
                category = Category.FOOD;
                break;
            } else if (userSymbol.equals("e")) {
                category = Category.ELECTRONICS;
                break;
            } else if (userSymbol.equals("c")) {
                category = Category.CLOTHES;
                break;
            } else if (userSymbol.equals("u")) {
                category = Category.FURNITURE;
                break;
            } else {
                View.invalidSymbol();
            }
        }
        return filterList.stream()
                .filter(product -> ((Product) product).getCategory().equals(category))
                .collect(Collectors.toList());
    }

    List<Products> keywordFilter(List<Products> filterList) {
        System.out.println("Введите название желаемого товара:");
        userSymbol = scanner.nextLine();
        return filterList.stream()
                .filter(product ->
                        ((Product) product).getName().toLowerCase().contains(userSymbol.toLowerCase()))
                .collect(Collectors.toList());
    }
}
