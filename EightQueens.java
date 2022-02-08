public class EightQueens {
    public static void main(String[] args) {
        int[][] map = new int[8][8];
        Test test = new Test();
        test.Answer(map, 0, 0);
    }
}

class Test {
    public boolean Answer(int[][] map, int i, int j) {
        // 标记 0 代表可以走， 1 代表不能得到解 ， 2 代表能得到正确解。
        // 决策 从 零 列 开始 一直向右走。
        if (map[i][j] == 0) {
            map[i][j] = 2;
            // 米字设置为 1 。
            initial(map,i,j);
            // 向上寻找下一行的棋子解。
            if (Answer(map, i + 1, j)) { //向上前进一格
                return true;
            } else if (Answer(map, i + 1, j + 1)) { // 向右上前进一格。
                return true;
            }
        } else {
            // 决策
            Answer(map, i, j + 1);
            return false;
        }
    }

    public void initial(int[][] map, int i, int j) {
        for (int x = -i; x + i < 8; x++) {
            // 米字初始化为一 以传入的当前坐标为例子
            map[i][x] = 1; // 整行
            map[x][j] = 1; // 列
            map[i + x][j + x] = 1; // 右对角线
            map[i + x][j - x] = 1; // 左对角线
        }
    }
}
