/**
+---------------------------------------------+
|            CaffeinatedBeverage              |
+---------------------------------------------+
| - name: String                              |
| - ounces: int                               |
| - price: double                             |
+---------------------------------------------+
| + CaffeinatedBeverage(name: String,         |
|   ounces: int, price: double)               |
| + getName(): String                         |
| + setName(name: String): void               |
| + getOunces(): int                          |
| + setOunces(ounces: int): void              |
| + getPrice(): double                        |
| + setPrice(price: double): void             |
| + sip(sipAmount: int): boolean              |
| + equals(o: Object): boolean                |
| + toString(): String                        |
+---------------------------------------------+
 */

public class CaffeinatedBeverage
{
    private String name;
    private int ounces;
    private double price;

    public CaffeinatedBeverage(String name, int ounces, double price) {
        this.name = name;
        this.ounces = Math.max(0,ounces);
        this.price = Math.max(0,price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOunces() {
        return this.ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = Math.max(0,ounces);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = Math.max(0,price);
    }

    public boolean sip(int sipAmount) {
        if (sipAmount >= ounces) {
            ounces = 0; 
            return false;// No liquid left
        } else {
            ounces -= sipAmount;
            return true;//Some liquid left
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 &&
               this.name.equals(that.name);
    }
}