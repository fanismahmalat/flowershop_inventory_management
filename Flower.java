import java.time.LocalDate;

public class Flower {
  private LocalDate exp_date; // LocalDate.of(2021, 01, 01)
  private String color;
  private double length;
  private String type;

  // CONSTRUCTOR
  public Flower(LocalDate exp, String c, double l, String type) {
    this.exp_date = exp;
    this.color = c;
    this.length = l;
    this.type = type;
  }

  // ACCESSORS
  public LocalDate getExpDate() {
    return exp_date;
  }

  public String getColor() {
    return color;
  }

  public double getLength() {
    return length;
  }

  public String getType() {
    return type;
  }

}
