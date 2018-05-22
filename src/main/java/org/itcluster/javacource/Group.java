package org.itcluster.javacource;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private Student prefect;
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String name, Student prefect, List<Student> students) {
        this.name = name;
        this.prefect = prefect;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Student getPrefect() {
        return prefect;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", prefect=" + prefect +
                ", students=" + students +
                '}';
    }
}
