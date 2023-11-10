package threads.cw;

import java.util.ArrayList;
import java.util.List;

public class FirstFloor implements Floor {

    private List<Vehicle> vehicleList = new ArrayList<>();
    private final int MAX_SLOTS = 10;

    @Override
    public synchronized void SaveVehicle(Vehicle vehicle) {
        System.out.println("saving vehicle");
        while (vehicleList.size() == MAX_SLOTS) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " saved " + vehicle.getIdPlate());
        vehicleList.add(vehicle);
        notifyAll();
    }

    @Override
    public synchronized void removeVehicle(Vehicle vehicle) {
        System.out.println("removing vehicle");
        System.out.println(Thread.currentThread().getName() + "removed" + vehicle.getIdPlate());
        vehicleList.remove(vehicle);
        notifyAll();
    }
}
