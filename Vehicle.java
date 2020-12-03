import java.util.ArrayList;

public class Vehicle {
  private String licensePlate;
  private String model;
  private ArrayList<Integer> orderIDs = new ArrayList<Integer>(); // saving the orders that this vehicle did

  private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

  public Vehicle(String plates, String model) {
    this.licensePlate = plates.toUpperCase();
    this.model = model;
  }

  // ACCESSORS
  public String getLicensePlate() {
    return licensePlate;
  }

  public ArrayList<Integer> getOrderIDs() {
    return orderIDs;
  }

  public String getModel() {
    return model;
  }

  public static ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  // MODIFIERS
  public static void addVehicle(String plates, String model) {
    vehicles.add(new Vehicle(plates, model));
  }

  public static void assignDelivery(String vehiclePlates, int orderID) throws Exception {
    for (int i = 0; i < vehicles.size(); i++) {
      if (vehicles.get(i).getLicensePlate() == vehiclePlates) {
        vehicles.get(i).addOrderID(orderID);
        Order.readyForDelivery(orderID);
        Order.assignDeliveryVehicle(orderID, vehiclePlates);
      }
    }
  }

  private void addOrderID(int orderID) {
    this.orderIDs.add(orderID);
  }
}
