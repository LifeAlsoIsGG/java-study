package dataStructure.SparseArray;

/**
 * @WebName: dataStructure.SparseArray
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/8  14:53
 * “Welcome,my master”
 */
public class SparseArray {
    public static void main(String[] args) {
        /*0：没有棋子，1：表示黑子，2：表示白子*/
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][4] = 2;
        chessArr[3][8] = 10;
//        输出原始为二维数组
        System.out.println("原始二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        将二维数组转为稀疏数组
//        1.先遍历二维数组非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println("非0个数为" + sum);

//        2.创建相应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

//        遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

//        输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        将稀疏数组转换为二维数组
//        声明数组
        int chessArry2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArry2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //        输出转换后的二维数组
        System.out.println("转换后的  二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }

}
