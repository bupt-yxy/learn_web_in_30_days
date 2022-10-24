package pufa;

public class HanoiTower {
    //我的算法启蒙，汉诺塔问题
    public static void hanoi(int n, char p1, char p2, char p3) {
        //p1, p2, p3分别代表三个柱子或盘子
        //递归将问题的规模缩小后，解法适合它的子问题，因此递归
        if (n > 0) {
            hanoi(n-1, p1, p3, p2);
            System.out.printf("%c-->%c\n", p1, p3);
            hanoi(n-1, p2, p1, p3);
        }
    }

    public static void main(String[] args) {
        //三个盘子分别命名为A、B、C
        hanoi(3, 'A', 'B', 'C');
    }
}
