package finalkeyword;

public final class FinalObject {

    private final String name;
    private final int age;

    /**
     * Default constructor is not allowed here, since name and age varaibles are final.
     * So those variables need to initialized when object is created.
     */
//    public FinalObject() {
//
//    }

    public FinalObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "FinalObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
