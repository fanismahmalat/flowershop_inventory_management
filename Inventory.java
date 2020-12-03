public class Inventory {
  public static Flower[] flowers = new Flower[0];
  public static Product[] products = new Product[0];

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

  public static Product[] getProducts() {
    return products;
  }

  public static Flower[] getFlowers() {
    return flowers;
  }

  public static int productsLength() {
    return products.length;
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

  public static Product[] addProduct(Product product) {
    Product[] newProducts = new Product[products.length + 1];

    for (int i = 0; i < newProducts.length; i++) {
      if (i == newProducts.length - 1) {
        newProducts[i] = product;
      } else {
        newProducts[i] = products[i];
      }
    }

    products = newProducts;

    return products;
  }

  public static Product[] removeProduct(int barcode) throws Exception {
    Product[] newProducts = new Product[products.length - 1];
    boolean indexFound = false;

    // Find the index of the product
    for (int i = 0; i < products.length; i++) {
      if (products[i].getBarcode() == barcode) {
        int index = i;

        for (int j = 0, k = 0; j < products.length; j++) {
          if (j != index) {
            newProducts[k] = products[j];
            k++;
          }
        }

        indexFound = true;
        break;
      }
    }

    if (!indexFound) {
      System.out.println("Cannot find the product with barcode " + barcode);
      throw new Exception();
    }

    products = newProducts;

    return products;
  }

}