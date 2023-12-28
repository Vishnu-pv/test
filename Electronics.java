package Test;

public class Electronics extends Product{

    private int warrantyPeriod;

    public Electronics(int productId, String productName, double price, int warrantyPeriod) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        if(warrantyPeriod > 12){
            return 0.2;
        }
        return 0.1;
    }
}
