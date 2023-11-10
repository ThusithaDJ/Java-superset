package core;

public class CoreMain {
    public static int counter = 0;
    public int instanceCount = 0;

    static class CoreInner{
        static {
            System.out.println("======================== core inner static block ========================");
        }

        {
            System.out.println("======================== core inner instance block ========================");
        }

        public static void innerM() {
            System.out.println("============================= core inner static method ====================");
        }

        public CoreInner() {
            System.out.println("============================= core inner constructor ====================");
        }
    }

    static {
        System.out.println("========================= start static block ====================================");
//        new CoreMain();
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
        System.out.println("========================= end static block ====================================");
        System.out.println();
    }

    {
        System.out.println("========================= start instance block ====================================");
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
        System.out.println("Increasing instanceCount variable by 1, value : " + (++this.instanceCount));
        System.out.println("========================= end instance block ====================================");
        System.out.println();
    }

    public static void staticMethod() {
        System.out.println("========================= start static method ====================================");
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
        System.out.println("========================= end static method ====================================");
        System.out.println();
    }

    public void m() {
        System.out.println("========================= start instance method ====================================");
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
        System.out.println("========================= end instance method ====================================");
        System.out.println();
    }

    public CoreMain() {
        System.out.println("========================= start constructor  ====================================");
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
        System.out.println("Increasing instanceCount variable by 1, value : " + (++this.instanceCount));
        System.out.println("========================= end constructor ====================================");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("||||||||||||||||||||||| start main method |||||||||||||||||||||||||||||||");
        System.out.println("Increasing counter variable by 1, value : " + (++CoreMain.counter));
//        CoreMain.staticMethod();
//        new CoreMain().m();
        new CoreMain();

//        new CoreMain.CoreInner();

        System.out.println("||||||||||||||||||||||| end main method |||||||||||||||||||||||||||||||||");
        System.out.println();
    }
}
