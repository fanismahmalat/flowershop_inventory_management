public class Bouquet extends Product {
  public int numOfRoses;
  public int numOfTulips;

  public Bouquet(String name, double price, int roses, int tulips) throws Exception {
    super(name, price);

    // Check if enough flowers in inventory
    if (Inventory.getRoses() < roses) {
      System.out.println("Not enough roses in stock to make this bucket.");
      throw new Exception();
    }

    if (Inventory.getTulips() < tulips) {
      System.out.println("Not enough tulips in stock to make this bucket.");
      throw new Exception();
    }

    // Reduce flowers in inventory
    for (int i = 0; i < roses; i++) {
      Inventory.removeFlower("rose");
    }

    for (int i = 0; i < tulips; i++) {
      Inventory.removeFlower("tulip");
    }

    this.numOfRoses = roses;
    this.numOfTulips = tulips;
  }

  // ACCESSORS
  public int getNumOfRoses() {
    return this.numOfRoses;
  }

  public int getNumOfTulips() {
    return this.numOfTulips;
  }
}
