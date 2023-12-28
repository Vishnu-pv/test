package Test;

/*
Question:

You are tasked with implementing a simple inventory management system for a retail store. Design and implement the following classes:

Product:
Create an abstract class called Product with the following attributes:

productId (int): representing the unique identifier of the product.
productName (String): representing the name of the product.
price (double): representing the price of the product.
Implement a parameterized constructor to initialize these attributes.

Include getter methods for each attribute.

Implement an abstract method called calculateDiscount() that should be overridden by subclasses.

Electronics:

Create a subclass called Electronics that extends Product.

Add an additional attribute:

warrantyPeriod (int): representing the warranty period in months.
Implement a parameterized constructor to initialize the attributes.

Override the calculateDiscount() method to apply a discount based on the warranty period.

Clothing:

Create another subclass called Clothing that extends Product.

Add an additional attribute:

size (String): representing the size of the clothing item.
Implement a parameterized constructor to initialize the attributes.

Override the calculateDiscount() method to apply a discount based on the size (e.g., small size gets a higher discount).




Inventory:

Create a class called Inventory that manages a collection of Product objects.
Include methods to add a product to the inventory, remove a product, and display the current inventory.

Main:

Create a Main class with a main method to test your implementation.
Create instances of Electronics and Clothing, add them to the Inventory, and display the current inventory.
Demonstrate the use of polymorphism by calling the calculateDiscount method on different types of products.
Ensure that your implementation demonstrates the use of various Java concepts, such as inheritance, abstract classes, interfaces, and the Java Collections Framework for managing the inventory.


 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("---Inventory Management---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : " );
            option = sc.nextInt();

            switch (option){
                case 1 : addProduct(sc,inventory);
                         break;
                case 2 : removeProduct(sc,inventory);
                         break;
                case 3 : inventory.displayInventory();
                         break;
                case 4 : break;
                default:
                    System.out.println("Invalid Choice. Please Enter a valid choice");
                    break;
            }

        }while (option != 4);

    }

    private static void removeProduct(Scanner sc, Inventory inventory) {
        System.out.println("Enter Product ID to Remove : ");
        int productId = sc.nextInt();
        inventory.removeProduct(productId);
    }

    private static void addProduct(Scanner sc, Inventory inventory) {
        System.out.println("-- Choose Product Type -- ");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("Your Choice : ");
        int productType = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Product ID : ");
        int productId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter product name : ");
        String productName = sc.nextLine();

        System.out.println("Enter Product Price : ");
        double productPrice = sc.nextDouble();
        sc.nextLine();



        if(productType == 1){
            System.out.println("Enter warranty period : ");
            int warrantyPeriod = sc.nextInt();
            Electronics electronics = new Electronics(productId, productName, productPrice, warrantyPeriod);
            inventory.addProduct(electronics);
        } else if (productType == 2) {
            System.out.println("Enter size : ");
            String size = sc.nextLine();
            Clothing clothing = new Clothing(productId, productName, productPrice, size);
            inventory.addProduct(clothing);

        }else{
            System.out.println("Invalid Choice! Please Try Again.");
        }




    }
}
