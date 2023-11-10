package threads.cw;

public class EntranceGate extends Thread {
    Floor floor;
    Vehicle vehicle;

    public EntranceGate(Floor floor, Vehicle vehicle) {
        this.floor = floor;
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        floor.SaveVehicle(this.vehicle);
    }
}
