package Test;

public class Clothing extends Product{
    private String size;

    public Clothing(int productId, String productName, double price, String size) {
        super(productId, productName, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return switch (size) {
            case "xs" -> 0.20;
            case "m" -> 0.10;
            case "l" -> 0.05;
            default -> 0.0;
        };
    }
}
