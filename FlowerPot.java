public class FlowerPot extends Product {
  public double diameter;

  public FlowerPot(String name, double price, double diameter) throws Exception {
    super(name, price);

    this.diameter = diameter;
  }
}
