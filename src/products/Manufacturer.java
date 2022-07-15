package products;

public enum Manufacturer {
    MIRATORG("\"OOO МИРАТОРГ\""),
    PROMTORG("\"OOO ПРОМТОРГ\""),
    SAMSUNG("SAMSUNG"),
    LG("LG"),
    LACOSTE("LACOSTE"),
    PULLANDBEAR("PULL&BEAR"),
    IKEA("IKEA"),
    SHATURA("\"АО ШАТУРА\"");

    private final String manufacturerName;

    Manufacturer(String value) {
        this.manufacturerName = value;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}
