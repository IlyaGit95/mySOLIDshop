package products;

public enum Category {
    FOOD("Продукты питания"),
    ELECTRONICS("Электроника"),
    CLOTHES("Одежда"),
    FURNITURE("Мебель"),
    ABSTRACT("Продукт");

    private final String categoryName;

    Category(String value) {
        this.categoryName = value;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
