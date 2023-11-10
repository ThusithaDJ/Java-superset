package threads.cw;

public class ExitGate implements Runnable {

    private Floor floor;
    private Vehicle vehicle;

    public ExitGate(Floor floor, Vehicle vehicle) {
        this.floor = floor;
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        this.floor.removeVehicle(vehicle);
    }
}
