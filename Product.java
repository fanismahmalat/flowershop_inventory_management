import java.util.Random;

public class Product {
  private String productName;
  private double unitPrice;
  private int barcode;

  public Product(String name, double price) {
    Random rand = new Random();
    this.barcode = rand.nextInt(100000000);
    // this.barcode = barcode;

    this.productName = name;
    this.unitPrice = price;
  }

  // ACCESSORS
  public int getBarcode() {
    return this.barcode;
  }

  public String getProductName() {
    return this.productName;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }
}
