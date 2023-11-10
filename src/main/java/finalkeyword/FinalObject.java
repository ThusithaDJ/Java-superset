package finalkeyword;

public class FinalObject {

    private final String name;
    private final int age;

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
