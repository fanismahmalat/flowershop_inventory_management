import java.time.LocalDate;

public class Main {
  static Inventory inventory;

  public static void main(String[] args) throws Exception {

    printInventory();
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 01), "red", 10, "rose"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 01), "yellow", 10, "rose"));
    Inventory.addFlower(new Flower(LocalDate.of(2021, 01, 01), "purple", 8, "tulip"));
    printInventory();
    Inventory.addProduct(new Buket("Buket", 25, 1, 0));
    Inventory.addProduct(new Buket("Buket", 25, 0, 1));
    // Inventory.addProduct(new FlowerPot("Pot", 25, 20));
    printInventory();
    // System.out.println(x.);
  }

  static void printInventory() {
    System.out.println("\u001B[33m==================\u001B[0m");
    System.out.println("Roses: " + Inventory.getRoses());
    System.out.println("Tulips: " + Inventory.getTulips());

    Product[] products = Inventory.getProducts();

    if (products.length <= 0) {
      System.out.println("No products in the inventory.");
    } else {
      for (Product product : products) {
        System.out.println("\u001B[33m----------\u001B[0m");
        System.out.println("Product type: " + product.getClass());
        System.out.println("Product name: " + product.getProductName());
        System.out.println("Barcode: " + product.getBarcode());
        System.out.println("Unit price: " + product.getUnitPrice());
        System.out.println("Number of roses: " + product.getNumOfRoses());
        System.out.println("Number of tulips: " + product.getNumOfTulips());
      }
    }

    Flower[] flowers = Inventory.getFlowers();

    if (flowers.length <= 0) {
      System.out.println("No flowers in the inventory.");
    } else {
      for (Flower flower : flowers) {
        System.out.println("\u001B[31m----------\u001B[0m");
        System.out.println("Flower type: " + flower.getType());
        System.out.println("Flower color: " + flower.getColor());
        System.out.println("Flower exp. date: " + flower.getExpDate());
        System.out.println("Flower length: " + flower.getLength());
      }
    }

    System.out.println("\u001B[33m==================\u001B[0m");
  }
}