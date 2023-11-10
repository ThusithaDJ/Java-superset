package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortingEx {

    static class Student {
        String name;
        Date date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Student(String name, Date date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", date=" + date +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Student> st = new ArrayList<>();
        st.add(new Student("e", new Date(System.currentTimeMillis() + 500000000)));
        st.add(new Student("b", new Date(System.currentTimeMillis() + 200000000)));
        st.add(new Student("f", new Date(System.currentTimeMillis() + 600000000)));
        st.add(new Student("A", new Date(System.currentTimeMillis() + 100000000)));
        st.add(new Student("c", new Date(System.currentTimeMillis() + 300000000)));
        st.add(new Student("k", new Date(System.currentTimeMillis() + 1000000000)));
        st.add(new Student("d", new Date(System.currentTimeMillis() + 400000000)));
        st.add(new Student("h", new Date(System.currentTimeMillis() + 800000000)));
        st.add(new Student("g", new Date(System.currentTimeMillis() + 700000000)));
        st.add(new Student("j", new Date(System.currentTimeMillis() + 900000000)));

//        st.stream().forEach(value -> System.out.println(value));
        Set<Student> students = new TreeSet<>();

        Set<Student> collect = st.stream().collect(Collectors.toCollection(TreeSet::new));
        collect.forEach(value -> System.out.println(value));
    }
}
