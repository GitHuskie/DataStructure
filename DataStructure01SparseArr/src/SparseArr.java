/**
 * @author Yunmeng Zhang
 * @version 2022.1
 * @date 2022/8/31 18:27
 */

/*
= = = = = = = = = = = 数据结构 Day01 = = = = = = = = = =
【代码】  实现二维数组与稀疏数组的转换
         1.创建一个原始的二维数组(8*8)
         2.0表示没有棋子,1表示黑子,2表示蓝子
【思路】
        【1】二维数组 --> 稀疏数组
         1.遍历二维数组,得到非0数据的个数
         2.创建对应稀疏数组
         3.给稀疏数组赋值(遍历二维数组,将非0的值存放到sparseArr中)
         4.输出稀疏数组
        【2】二维数组 <-- 稀疏数组
         1.先读取稀疏数组第一行:根据第一行的数据,创建原始二维数组
         2.再读取稀疏数组后几行的数据,并赋给原始的二维数组
= = = = = = = = = = = = = = = = = = = = = = = = = = = =
 */
public class SparseArr {
    public static void main(String[] args) {
        //二维数组 --> 稀疏数组
        //【注意】心中要有稀疏数组的列表的那张图
        //创建一个原始的二维数组(8*8)
        //0表示没有棋子,1表示黑子,2表示蓝子
        int chessArr1[][] = new int[8][8];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][2] = 2;
        System.out.println("=======初始化二维数组输出如下=======");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.print(chessArr1[i][j] + "  ");
            }
            System.out.println();
        }

        //1.遍历二维数组,得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum= " + sum);

        //2.创建对应稀疏数组
        int sparseArr[][] = new int[sum + 1][3];//总结规律(二维数组因此得到压缩)
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1.length;
        sparseArr[0][2] = sum;

        //3.给稀疏数组赋值(遍历二维数组,将非0的值存放到sparseArr中)
        int count = 0;//用于记录是第几个非0数组,因为之后赋值时会递增
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    //【对应关系】稀疏数组表中的值 是 二维数组的下标
                    // 【注意】注意思考对应关系,用对应关系来赋值(赋值符号前后内容)
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 4.输出稀疏数组
        System.out.println("=======稀疏数组输出如下=======");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "  ");
            }
            System.out.println();
        }
        //稀疏数组 --> 二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //1.先读取稀疏数组第一行:根据第一行的数据,创建原始二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            //【注意】注意思考对应关系,用对应关系来赋值(赋值符号前后内容)
            //【对应关系】二维数组的下标 与 稀疏数组的下标
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出二维数组
        System.out.println("=======还原二维数组输出如下=======");
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.print(chessArr2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
