package com.school.score;

import java.util.Scanner;

/**
 * 主程序入口与菜单模块
 * 作者：杨洋
 * 功能：提供系统菜单、调用学生与成绩模块
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StudentDao studentDao = new StudentDao();
    private static ScoreService scoreService = new ScoreService();

    public static void main(String[] args) {
        System.out.println("===== 学生成绩管理系统 =====");
        while (true) {
            printMenu();
            int choice = getChoice();
            handleChoice(choice);
        }
    }

    /**
     * 打印主菜单
     */
    private static void printMenu() {
        System.out.println("\n1. 添加学生信息");
        System.out.println("2. 查询所有学生");
        System.out.println("3. 根据学号查询学生");
        System.out.println("4. 删除学生");
        System.out.println("5. 计算平均分");
        System.out.println("6. 显示成绩排名");
        System.out.println("0. 退出系统");
        System.out.print("请输入您的选择：");
    }

    /**
     * 获取用户输入选项
     */
    private static int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("输入错误，请输入数字！");
        }
        return choice;
    }

    /**
     * 根据选项执行功能
     */
    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                studentDao.addStudent();
                break;
            case 2:
                studentDao.showAll();
                break;
            case 3:
                studentDao.searchById();
                break;
            case 4:
                studentDao.deleteById();
                break;
            case 5:
                scoreService.calcAvg(studentDao.getList());
                break;
            case 6:
                scoreService.sortScore(studentDao.getList());
                break;
            case 0:
                System.out.println("退出系统，感谢使用！");
                System.exit(0);
                break;
            default:
                System.out.println("选项不存在，请重新选择！");
        }
    }
}
