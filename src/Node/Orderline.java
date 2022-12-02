package Node;

public class Orderline {

  private int drink_amount;
  private int dessert_amount;
  private int pizza_amount;

  public Orderline() {
      super();
	}

  public int getDrink_amount() {
    return this.drink_amount;
  }

  public void setDrink_amount(int drink_amount) {
    this.drink_amount = drink_amount;
  }

  public int getDessert_amount() {
    return this.dessert_amount;
  }

  public void setDessert_amount(int dessert_amount) {
    this.dessert_amount = dessert_amount;
  }

  public int getPizza_amount() {
	  return this.pizza_amount;
  }
  
  public void setPizza_amount(int pizza_amount) {
	  this.pizza_amount = pizza_amount;
  }
}
