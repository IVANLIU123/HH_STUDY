package pack;

import java.util.Objects;

public class Student {
    private String name;
    private String age;
    private String addr;
    private String school;
    private String phoneNum;

    public Student(String name, String age, String addr, String school, String phoneNum) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.school = school;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    /*
    将电话号码视为unique来区分不同学生
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return phoneNum.equals(student.phoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNum);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", school='" + school + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
