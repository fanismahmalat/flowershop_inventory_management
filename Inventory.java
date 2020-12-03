import java.util.ArrayList;

public class Inventory {
  public static Flower[] flowers = new Flower[0];
  public static ArrayList<Product> products = new ArrayList<Product>();

  // ACCESSORS
  public static int getRoses() {
    int roses = 0;

    for (Flower flower : flowers) {
      if (flower.getType() == "rose") {
        roses++;
      }
    }

    return roses;
  }

  public static int getTulips() {
    int tulips = 0;

    for (Flower flower : flowers) {
      if (flower.getType() == "tulip") {
        tulips++;
      }
    }

    return tulips;
  }

  public static ArrayList<Product> getProducts() {
    return products;
  }

  public static Flower[] getFlowers() {
    return flowers;
  }

  public static int productsLength() {
    return products.size();
  }

  // MODIFIERS
  public static Flower[] addFlower(Flower flower) {
    Flower[] newFlowers = new Flower[flowers.length + 1];

    for (int i = 0; i < newFlowers.length; i++) {
      if (i == newFlowers.length - 1) {
        newFlowers[i] = flower;
      } else {
        newFlowers[i] = flowers[i];
      }
    }

    flowers = newFlowers;

    return flowers;
  }

  public static Flower[] removeFlower(String type) throws Exception {
    Flower[] newFlowers = new Flower[flowers.length - 1];
    boolean indexFound = false;

    for (int i = 0; i < flowers.length; i++) {
      if (flowers[i].getType() == type) {
        int index = i;

        for (int j = 0, k = 0; j < flowers.length; j++) {
          if (j != index) {
            newFlowers[k] = flowers[j];
            k++;
          }
        }

        indexFound = true;
        break;
      }
    }

    if (!indexFound) {
      System.out.println("Cannot find " + type + " in the inventory");
      throw new Exception();
    }

    flowers = newFlowers;

    return flowers;
  }

  public static Product getByBarcode(int barcode) throws Exception {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getBarcode() == barcode) {
        return products.get(i);
      }
    }

    throw new Exception();
  }

  public static ArrayList<Product> addProduct(Product product) {
    products.add(product);

    return products;
  }

  public static ArrayList<Product> removeProduct(int barcode) throws Exception {
    products.removeIf(product -> product.getBarcode() == barcode);

    return products;
  }

}