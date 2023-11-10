package core;

public class CoreMain2 {

    static {
        System.out.println("++++++++++++++++++++++ core main 2 static block start ++++++++++++++++++++++++++");
//        int counter = CoreMain.counter;
//        System.out.println(counter);
        System.out.println("++++++++++++++++++++++ core main 2 static block end ++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        new CoreMain();
    }
}
