package pack;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        while(true){
        System.out.println("请选择功能：");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
            System.out.println("4.输出全部学生");
        System.out.println("5.退出");
        Scanner sc=new Scanner(System.in);
        int op=sc.nextInt();
        Manager manager=new Manager();
        switch (op) {
            case 1:
                manager.add();
                break;
            case 2:
                manager.delete();
                break;
            case 3:
                manager.alter();
                break;
            case 4:manager.printAll();
                break;
            case 5:
                exit(0);
                break;
            default:

        }
    }
    }
}
