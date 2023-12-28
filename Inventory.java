package Test;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;
    public Inventory(){
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product){
        System.out.println("Adding product with ID --> "+product.getProductId());
        if(products.stream().anyMatch(p -> p.getProductId() == product.getProductId())){
            System.out.println("Error! Product with ID: "+product.getProductId()+" already Exists!");
        }else{
            products.add(product);
        }


    }
    public void removeProduct(int productId){
        System.out.println("Removing product - "+productId);
        if(products.stream().anyMatch(product -> product.getProductId() == productId)){
            products.removeIf(p -> p.getProductId() == productId);
        }else {
            System.out.println("Product with ID "+productId+" doesn't Exists");
        }

    }

    public void displayInventory(){
        if(products.isEmpty()){
            System.out.println("Inventory is Empty!");
            return;
        }
        System.out.println("---- Current Inventory ---- " );
        products.forEach(product -> {
            System.out.println("Product Id  :"+product.getProductId());
            System.out.println("Product name  :"+product.getProductName());
            System.out.println("Price :"+product.getPrice());
            System.out.println("Discount  :"+product.calculateDiscount());
            System.out.println("-------------------");
        });

    }
}
