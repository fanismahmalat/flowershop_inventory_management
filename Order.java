import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
  private int orderID;
  private String status;
  private LocalDate issuedDate;
  private double totalPrice = 0;
  private String deliveryVehicle = "None";
  private ArrayList<Product> products = new ArrayList<Product>();

  private static int orderCounter = 0;
  private static ArrayList<Order> orders = new ArrayList<Order>();

  public Order(int[] barcodes) {
    this.orderID = ++Order.orderCounter;
    this.issuedDate = LocalDate.now();
    this.status = "pending"; // pending, readyfordelivery, delivering, completed, cancelled

    // Get products and save them in the order
    for (int barcode : barcodes) {
      for (int i = 0; i < Inventory.getProducts().size(); i++) {
        if (Inventory.getProducts().get(i).getBarcode() == barcode) {
          this.products.add(Inventory.getProducts().get(i));
          this.totalPrice = this.totalPrice + Inventory.getProducts().get(i).getUnitPrice();
          Inventory.getProducts().remove(i);
        }
      }
    }
  }

  // ACCESSORS
  public int getOrderID() {
    return orderID;
  }

  public String getDeliveryVehicle() {
    return deliveryVehicle;
  }

  public String getStatus() {
    return status;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public LocalDate getIssuedDate() {
    return issuedDate;
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public static ArrayList<Order> getOrders() {
    return orders;
  }

  // MODIFIERS
  public static ArrayList<Order> create(int[] barcodes) {
    orders.add(new Order(barcodes));

    return orders;
  }

  public static void assignDeliveryVehicle(int orderID, String vehicle) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderID() == orderID) {
        orders.get(i).deliveryVehicle = vehicle;
      }
    }
  }

  public static void cancel(int orderID) throws Exception {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderID() == orderID) {
        orders.get(i).changeStatus("cancelled");
      }
    }
  }

  public static void readyForDelivery(int orderID) throws Exception {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderID() == orderID) {
        orders.get(i).changeStatus("readyfordelivery");
      }
    }
  }

  private void changeStatus(String status) throws Exception {
    if (status != "pending" && status != "readyfordelivery" && status != "completed" && status != "delivering"
        && status != "cancelled") {
      throw new Exception("Undefined order status");
    }

    this.status = status;
  }

  public static ArrayList<Order> removeOrder(int orderID) throws Exception {
    boolean indexFound = false;

    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).orderID == orderID) {
        orders.remove(i);
        indexFound = true;
      }
    }

    if (!indexFound) {
      System.out.println("Cannot find order with ID " + orderID);
      throw new Exception();
    }

    return orders;
  }
}
