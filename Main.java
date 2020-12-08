import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
  static Inventory inventory;

  public static void main(String[] args) throws Exception {

    // Empty inventory
    printInventory();
    // Add flowers to inventory
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "rose"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "rose"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "rose"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 02), "red", 10, "tulip"));
    // Add products to inventory using the flowers
    Inventory.addProduct(new Bouquet("Flowerista", 20, 2, 5));
    Inventory.addProduct(new FlowerPot("Potter", 12, 20));

    printInventory();

    // No orders
    printOrders();
    // Create order with the products
    Order
        .create(new int[] { Inventory.getProducts().get(0).getBarcode(), Inventory.getProducts().get(1).getBarcode() });

    printInventory();
    printOrders();

    // No vehicles
    printVehicles();
    // Add new vehicle
    Vehicle.addVehicle("MYX281", "Mazda 2");
    printVehicles();

    // Assign delivery of order to vehicle
    Vehicle.assignDelivery("MYX281", Order.getOrders().get(0).getOrderID());

    printVehicles();
    printOrders();
  }

  static void printVehicles() {
    System.out.println("\u001B[32m======== VEHICLES ========\u001B[0m");

    if (Vehicle.getVehicles().size() <= 0) {
      System.out.println("No vehicles found.");
    } else {
      for (Vehicle vehicle : Vehicle.getVehicles()) {
        System.out.println("License plate: " + vehicle.getLicensePlate());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Orders: ");
        for (Integer order : vehicle.getOrderIDs()) {
          System.out.println("ID: " + order);
        }
      }
    }

    System.out.println("\u001B[32m========================\u001B[0m");

  }

  static void printOrders() {
    System.out.println("\u001B[32m======== ORDERS ========\u001B[0m");

    if (Order.getOrders().size() <= 0) {
      System.out.println("No orders found.");
    } else {
      for (Order order : Order.getOrders()) {
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Issued: " + order.getIssuedDate());
        System.out.println("Delivery vehicle: " + order.getDeliveryVehicle());
        System.out.println("Order products: ");
        for (Product orderProducts : order.getProducts()) {
          System.out.println("Product name: " + orderProducts.getProductName());
          System.out.println("Unit price: " + orderProducts.getUnitPrice());
          System.out.println("Barcode: " + orderProducts.getBarcode());
        }
        System.out.println("\u001B[36m----------\u001B[0m");
      }
    }

    System.out.println("\u001B[32m========================\u001B[0m");
  }

  static void printInventory() {
    System.out.println("\u001B[32m======== INVENTORY ========\u001B[0m");
    System.out.println("\u001B[33m==== PRODUCTS ====\u001B[0m");

    ArrayList<Product> products = Inventory.getProducts();

    if (products.size() <= 0) {
      System.out.println("No products in the inventory.");
    } else {
      for (Product product : products) {
        System.out.println("Product type: " + product.getClass().getName());
        System.out.println("Product name: " + product.getProductName());
        System.out.println("Barcode: " + product.getBarcode());
        System.out.println("Unit price: " + product.getUnitPrice());
        if (product instanceof Bouquet) {
          Bouquet bouquet = (Bouquet) product;
          System.out.println("Number of roses: " + bouquet.getNumOfRoses());
          System.out.println("Number of tulips: " + bouquet.getNumOfTulips());
        }
        System.out.println("\u001B[33m----------\u001B[0m");
      }
    }

    System.out.println("\u001B[36m==== FLOWERS ====\u001B[0m");
    System.out.println("Roses: " + Inventory.getRoses());
    System.out.println("Tulips: " + Inventory.getTulips());

    Flower[] flowers = Inventory.getFlowers();

    if (flowers.length <= 0) {
      System.out.println("No flowers in the inventory.");
    } else {
      for (Flower flower : flowers) {
        System.out.println("\u001B[36m----------\u001B[0m");
        System.out.println("Flower type: " + flower.getType());
        System.out.println("Flower color: " + flower.getColor());
        System.out.println("Flower exp. date: " + flower.getExpDate());
        System.out.println("Flower length: " + flower.getLength());
      }
    }

    System.out.println("\u001B[32m========================\u001B[0m");
  }
}