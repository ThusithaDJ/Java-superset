package java8features.lambdaexp;

public class Employee {

    private RelationshipStatus status;

    public Employee(RelationshipStatus status) {
        this.status = status;
    }

    public String getRelationshipStatusAsString() {
        return status.getStatus();
    }

    public Employee(ExceptionTest ex) throws Exception {
        ex.theMethod();
    }
}
