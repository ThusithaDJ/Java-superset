package enums;

public class WeightTable {

    public static void main(String[] args) {

        double earthWeight = 3d;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        System.out.println(mass);
    }
}
