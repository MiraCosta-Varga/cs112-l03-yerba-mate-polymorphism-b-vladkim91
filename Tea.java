public class Tea extends CaffeinatedBeverage {
  private int brewTemp;

  public Tea(String name, int ounces, double price, int brewTemp) {
    super(name, ounces, price);
    this.brewTemp = Math.max(0, brewTemp); //Error check
  }

  public int getBrewTemp() {
    return brewTemp;
  }

  public void setBrewTemp(int brewTemp) {
    this.brewTemp = Math.max(0, brewTemp); //Error check
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) return false; 
    Tea tea = (Tea) o;
    return this.brewTemp == tea.brewTemp;
  }

  @Override
  public String toString() {
    return "Tea: " + getName() + ", " + getOunces() + " ounces, brewed @ " + brewTemp + "°C, $" + String.format("%.2f", getPrice());
  }
}