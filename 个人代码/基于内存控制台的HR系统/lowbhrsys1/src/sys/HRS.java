package sys;

import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    private static ArrayList<Resume> resumeArrayList = new ArrayList<>();
    //获取标准输入流
    private static Scanner input = new Scanner(System.in);

    HRS() {
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("添加简历信息请按----1");
            System.out.println("删除简历信息请按----2");
            System.out.println("修改简历信息请按----3");
            System.out.println("查询简历信息请按----4");
            System.out.println("退出请按--------5");


            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    showResume();
                    break;
                case 5:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");

            }
        }
        input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的
        System.out.println("您已经退出HR管理系统");
    }

    public static void addResume() {
        System.out.println("欢迎来到添加简历界面");
        System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                "3:体检通过,4:背调通过,5:已签约,6:已入职)");
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int process = Integer.parseInt(input.nextLine());
        Resume Resume = new Resume(name, id, school, process);
        resumeArrayList.add(Resume);
        System.out.println("您已成功添加简历");
    }

    public static void deleteResume() {
        System.out.println("欢迎来到删除简历界面");
        System.out.println("请输入需要删除的简历姓名");
        String ResumeName = input.nextLine();
        int ResumeCount = resumeArrayList.size();
        for (int i = 0; i < ResumeCount; i++) {
            if (resumeArrayList.get(i).getName().equals(ResumeName)) {
                resumeArrayList.remove(i);
                System.out.println("您已成功删除简历");
                break;
            } else if (i == ResumeCount - 1) {
                System.out.println("没有查找到该简历");
            }
        }
    }


    public static void updateResume() {
        System.out.println("欢迎来到修改简历界面");
        System.out.println("请输入需要修改的简历姓名");
        String ResumeName = input.nextLine();
        int ResumeCount = resumeArrayList.size();
        if(ResumeCount==0){
            System.out.println("没有查找到该简历");
        }
        for (int i = 0; i < ResumeCount; i++) {
            if (resumeArrayList.get(i).getName().equals(ResumeName)) {
                System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                        "3:体检通过,4:背调通过,5:已签约,6:已入职)");
                String name = input.nextLine();
                String id = input.nextLine();
                String school = input.nextLine();
                int process = Integer.parseInt(input.nextLine());
                Resume Resume = new Resume(name, id, school, process);
                resumeArrayList.set(i, Resume);
                System.out.println("您已成功修改简历信息");
            } else if (i == ResumeCount - 1 || ResumeCount == 0) {
                System.out.println("没有查找到该简历");
            }
        }
    }

    public static void showResume() {
        System.out.println("本简历管理系统共有" + resumeArrayList.size() + "简历");
        int ResumeCount = resumeArrayList.size();
        for (int i = 0; i < ResumeCount; i++) {
            System.out.println("第" + (i + 1) + "份" + "---------" + resumeArrayList.get(i).getName() + " " + resumeArrayList.get(i).getId() +
                    " " + resumeArrayList.get(i).getSchool() + " " + resumeArrayList.get(i).getProcess());
        }
    }

    public static void main(String[] args) {
        new HRS();
    }
}
