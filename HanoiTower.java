public class HanoiTower {
    public static void main(String[] args) {
        Tower test = new Tower();
        test.move(64,'A','B','C');
    }
}

class Tower {
    public void move(int nums, char a, char b, char c) {
        // 三种情况分类讨论
        // 1. 只有一个盘
        if (nums == 1) {
            System.out.println(a + "->" + c);
        } else {
            // 2. 有很多盘
            // 先把nums - 1 个盘放到 b 柱
            move(nums - 1, a, c, b);
            // 最下面的一个盘放在 c 柱
            System.out.println(a + "->" + c);
            // 再把 b 柱 所有盘子放在 c 柱
            move(nums - 1, b, a, c);
        }
    }
}