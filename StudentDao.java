public class StudentDao {
    private List<Student> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public List<Student> getList() {
        return list;
    }

    /**
     * 添加学生
     */
    public void addStudent() {
        System.out.print("请输入学号：");
        String id = sc.nextLine();
        System.out.print("请输入姓名：");
        String name = sc.nextLine();
        int age = inputAge();
        double score = inputScore();
        Student s = new Student(id, name, age, score);
        list.add(s);
        System.out.println("学生添加成功！");
    }

    /**
     * 输入年龄并校验
     */
    private int inputAge() {
        int age = 0;
        while (true) {
            try {
                System.out.print("请输入年龄：");
                age = Integer.parseInt(sc.nextLine());
                if (age > 0 && age < 100) {
                    break;
                } else {
                    System.out.println("年龄范围不合理，请重新输入！");
                }
            } catch (NumberFormatException e) {
                System.out.println("年龄必须是数字！");
            }
        }
        return age;
    }

    /**
     * 输入成绩并校验
     */
    private double inputScore() {
        double score = 0;
        while (true) {
            try {
                System.out.print("请输入成绩：");
                score = Double.parseDouble(sc.nextLine());
                if (score >= 0 && score <= 100) {
                    break;
                } else {
                    System.out.println("成绩必须在0-100之间！");
                }
            } catch (NumberFormatException e) {
                System.out.println("成绩必须是数字！");
            }
        }
        return score;
    }

    /**
     * 显示所有学生
     */
    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    /**
     * 按学号查询
     */
    public void searchById() {
        System.out.print("请输入要查询的学号：");
        String id = sc.nextLine();
        for (Student s : list) {
            if (s.getId().equals(id)) {
                System.out.println("查询结果：" + s);
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    /**
     * 按学号删除
     */
    public void deleteById() {
        System.out.print("请输入要删除的学号：");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("未找到该学生，删除失败！");
    }
}
