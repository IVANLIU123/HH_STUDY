package pack;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Database {
    private static Database database = null;
    private static Set<Student> students = null;

    private Database() {

    }



    public static Database getInstance() {
        if (database == null){
            database = new Database();
            students=new HashSet<>();
        }

        return database;
    }

    public boolean add(Student stu) {

        if (students.contains(stu))
            return false;
        students.add(stu);

        return true;
    }

    public boolean delete(Student stu) {

        if (!students.contains(stu))
            return false;
        students.remove(stu);

        return true;
    }

    public boolean alter(Student stu) {

        if (!students.contains(stu))
            return false;
        students.remove(stu);
        students.add(stu);

        return true;
    }

    public Object get(Student stu) {

        for (Student st : students
        ) {
            if (st.equals(stu))
                return st;
        }
        return null;
    }

    public Set getAll() {

        return students;
    }


}
