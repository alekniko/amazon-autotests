package hw1;

public class Calculations {
    public String calculatePossibilityToFinishTrip(int tankVolume, double fuelConsumption, double distance, String type) {
        String x = "";
        if (tankVolume / fuelConsumption * 100 >= distance) {
            x = "It is possible to get to a final destination with " + type;
        } else {
            x = "It is not possible to make it with " + type;
        }
        return x;
    }
}
