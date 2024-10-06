
public class YerbaMate extends Tea {

    private int numPasses;

    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        this.numPasses = Math.max(0, numPasses);
    }

    public int getNumPasses() {
        return numPasses;
    }

    public void passMate() {
        numPasses++;
        System.out.println("Mate was passes. Total passes: " + numPasses);
    }

    public void refill(int ouncesToAdd) {
        setOunces(getOunces() + ouncesToAdd);
        System.out.println("Mate refilled. Current ounces: " + getOunces());
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false; // Call parent class equals

        }
        YerbaMate mate = (YerbaMate) o;
        return this.numPasses == mate.numPasses;
    }

    @Override
    public String toString() {
        return "Yerba Mate: " + getName() + ", " + getOunces() + " ounces, brewed @ " + getBrewTemp() + "°C, $" + String.format("%.2f", getPrice()) + ", " + numPasses + " passes so far";
    }
}
