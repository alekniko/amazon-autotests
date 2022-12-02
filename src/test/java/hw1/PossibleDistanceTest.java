package hw1;

import org.junit.jupiter.api.Test;

public class PossibleDistanceTest {
    @Test
    public void possibilityCalculator() {

        Transport volvoCar = new Transport();
        volvoCar.setTankVolume(55);
        volvoCar.setFuelConsumption(8.5);
        volvoCar.setTransportType("Volvo car");

        Transport airBus = new Transport();
        airBus.setTankVolume(310000);
        airBus.setFuelConsumption(3000);
        airBus.setTransportType("Airbus");

        Transport train = new Transport();
        train.setTankVolume(7000);
        train.setFuelConsumption(80);

        Route routeA = new Route();
        routeA.setDepartureCity("Riga");
        routeA.setArrivalCity("Moscow");
        routeA.setDistance(950);

        Calculations calc = new Calculations();

        String calcResultForCar = calc.calculatePossibilityToFinishTrip(volvoCar.getTankVolume(), volvoCar.getFuelConsumption(), routeA.getDistance(), volvoCar.getTransportType());
        String calcResultForAirbus = calc.calculatePossibilityToFinishTrip(airBus.getTankVolume(), airBus.getFuelConsumption(), routeA.getDistance(), airBus.getTransportType());

        System.out.println("Trip from " + routeA.getDepartureCity() + " to " + routeA.getArrivalCity() + ". \n" + calcResultForCar);
        System.out.println("Trip from " + routeA.getDepartureCity() + " to " + routeA.getArrivalCity() + ". \n" + calcResultForAirbus);
    }
}
