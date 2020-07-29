package pack;

import java.util.Scanner;
import java.util.Set;

public class Manager {
    private Database database=Database.getInstance();
    public boolean add(){
        String name;
        String age;
        String addr;
        String school;
        String phoneNum;
        Scanner sc=new Scanner(System.in);
        System.out.println("姓名:");
        name=sc.nextLine();
        System.out.println("年龄:");
        age=sc.nextLine();
        System.out.println("地址:");
        addr=sc.nextLine();
        System.out.println("学校:");
        school=sc.nextLine();
        System.out.println("手机:");
        phoneNum=sc.nextLine();
        Student stu=new Student(name,age,addr,school,phoneNum);
        if(database.add(stu)){
            System.out.println("添加成功");
            return true;
        }
        else
        {
            System.out.println("添加失败");
            return false;
        }
    }

    public boolean delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入需要删除人员的手机以查找删除:");
        String phoneNum=sc.nextLine();
        Student stu=new Student("","","","",phoneNum);
        if(database.delete(stu)){
            System.out.println("删除成功");
            return true;
        }
        else
        {
            System.out.println("删除失败");
            return false;
        }
    }

    public boolean alter() {
        String name;
        int age;
        String addr;
        String school;
        String phoneNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要修改的人员手机以查找:");
        phoneNum = sc.nextLine();
        Student stu = new Student("", "", "", "", phoneNum);
        Student temp = (Student) database.get(stu);
        if (temp == null) {
            System.out.println("未找到");
            return false;
        } else {
            database.delete(temp);
            System.out.println("选择");
            System.out.println("1.修改姓名");
            System.out.println("2.修改年龄");
            System.out.println("3.修改地址");
            System.out.println("4.修改学校");
            System.out.println("5.修改手机");
            int op = sc.nextInt();
            switch (op) {
                case 1: {
                    System.out.println("新姓名:");
                    temp.setName(sc.nextLine());
                }
                case 2: {
                    System.out.println("新年龄:");
                    temp.setAge(sc.nextLine());
                }
                case 3: {
                    System.out.println("新地址:");
                    temp.setAddr(sc.nextLine());
                }
                case 4: {
                    System.out.println("新学校:");
                    temp.setSchool(sc.nextLine());
                }
                case 5: {
                    System.out.println("新手机:");
                    temp.setPhoneNum(sc.nextLine());
                }

            }

        }
        return true;

    }

    public void printAll(){
        Set<Student> students=database.getAll();
        if(students==null){
            System.out.println("结果为空");
            return;
        }

        for (Student stu:students
        ) {
            System.out.println(stu);
        }
    }
}
