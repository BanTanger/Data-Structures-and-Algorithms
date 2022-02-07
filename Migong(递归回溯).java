public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for(int i = 0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for(int i = 0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("=====生成地图=====");
        for(int i = 0;i<8;i++){
            for(int j = 0;j<7;j++){
//                print 不带有换行属性， println带有换行属性
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        T way = new T();
        way.findway(map,1,1);
        System.out.println("=====寻路分析=====");
        for(int i = 0;i<8;i++){
            for(int j = 0;j<7;j++){
//                print 不带有换行属性， println带有换行属性
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class T{
//    回溯思想
//    findway()方法
//    设置属性：
//        0 代表可以走，1 代表障碍物，2 代表能走通，3 代表死路
//    找到返回 true 找不到返回false
//    map为二维数组，i，j为当前坐标，用来判断是否能走通。
//    寻路决策 --> 下，右，上，左。
    public boolean findway(int[][] map,int i,int j){
//        先定好最终确定坐标。
        if(map[6][5] == 2){
            return true; // 寻路成功。
        }else{
            if(map[i][j] == 0){
                // 当前位置为0 说明可以走动。
                // 关键 -- 设置这个点为 2 代表假定这个点是能够走向终点的一个必经点。
                map[i][j] = 2;
                // 使用寻路决策，递归处理之后的情况。
                if(findway(map,i + 1,j)){ // 下
                    return true;
                }else if(findway(map,i , j + 1)){ // 右
                    return true;
                }else if(findway(map,i - 1,j)){ // 上
                    return true;
                }else if(findway(map,i,j-1)){ // 左
                    return true;
                }else{
                    //上下左右都不能执行
                    // 设置 当前点为 3 代表死路。
                    map[i][j] = 3;
                    return false;
                }
            }else{ // 只需要对没有走过并且不为死路的点进行分析，所以这里直接返回错误。
                // map[i][j] = 1,2,3
                return false;
            }
        }
    }
}
