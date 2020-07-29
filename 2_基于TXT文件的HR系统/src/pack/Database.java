package pack;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Database {
    private static Database database = null;
    private Set<Student> students = null;

    private Database() {

    }

    private void read() {
        byte[] temp = new byte[4 * 1024 * 1024];
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("data"));
            bis.read(temp, 0, 4 * 1024 * 1024);
            Object ob = toObject(temp);
            if (ob == null)//首次使用时数据文件为空
                students = new HashSet<>();
            else
                students = (Set) ob;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void write() {
        BufferedOutputStream bos =null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream("data"));
            bos.write(toByteArray(students), 0, 4 * 1024 * 1024);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    public static Database getInstance() {
        if (database == null)
            database = new Database();
        return database;
    }

    public boolean add(Student stu) {
        read();
        if (students.contains(stu))
            return false;
        students.add(stu);
        write();
        return true;
    }

    public boolean delete(Student stu) {
        read();
        if (!students.contains(stu))
            return false;
        students.remove(stu);
        write();
        return true;
    }

    public boolean alter(Student stu) {
        read();
        if (!students.contains(stu))
            return false;
        students.remove(stu);
        students.add(stu);
        write();
        return true;
    }

    public Object get(Student stu) {
        read();
        for (Student st : students
        ) {
            if (st.equals(stu))
                return st;
        }
        return null;
    }

    public Set getAll() {
        read();
        return students;
    }


}
