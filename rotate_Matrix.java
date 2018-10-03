package LeetCode;
//[i,j]-->[j,n-i-1]
//如果是翻转的话要翻转两次
//第一次按照对称轴y=x进行翻转
//第二次按照y轴中线左右翻转
public class rotate_Matrix {
    public void rotate(int[][] matrix) {

        for(int i =0;i<matrix.length;i++)
            for (int j =0;j<=i;j++){
                swap(matrix,i,j,j,i);
            }
            //(i,j)->(j,i)
        for(int j =0;j<matrix.length;j++)
            for (int i =0;i<matrix[0].length/2;i++){
                swap(matrix,j,i,j,matrix.length-i-1);
            }//(j,i)->(j,n-i-1)
        for(int i =0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    //下面这个函数只是输出，并没有改变matrix的值
    public void rotate2(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[matrix.length - j - 1][i] + " ");
            }
            System.out.println();
        }
    }
    public void swap(int[][]matrix,int i,int j,int m,int n){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = tmp;
    }
    public static void main(String[]args){
        int[][]matrix ={{1,2,3},{4,5,6},{7,8,9}};
        rotate_Matrix it = new rotate_Matrix();
        it.rotate2(matrix);

    }
}
