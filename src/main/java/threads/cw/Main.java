package threads.cw;

public class Main {

    public static void main(String[] args) {

        Floor firstFloor = new FirstFloor();

        Vehicle v1 = new Car("EE-"+121,"Toyota","Corolla");
        Thread entranceGate = new EntranceGate(firstFloor, v1);
        entranceGate.start();
    }
}
