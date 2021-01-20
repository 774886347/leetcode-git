package week11;

/**
 * @author wings
 * @since day0120
 */
public class Lc240SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length > 300) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length < 1) {
                return false;
            }
            // 找出所有首元素比target小，尾元素比target大的数组
            int lastIndex = matrix[i].length - 1;
            int halfIndex = lastIndex / 2;
            int firstIndex = 0;
            // 用二分法查找数组中的target元素，找到返回true
            while (matrix[i][firstIndex] < target && matrix[i][lastIndex] > target) {
                if (matrix[i][halfIndex] > target) {
                    lastIndex = halfIndex;
                    halfIndex = lastIndex / 2;
                    if (halfIndex < 2) {
                        break;
                    }
                } else if (matrix[i][halfIndex] < target) {
                    firstIndex = halfIndex;
                    halfIndex = (firstIndex + lastIndex) / 2;
                    if (halfIndex < 2) {
                        break;
                    }
                } else if (matrix[i][halfIndex] == target) {
                    return true;
                }
            }
            if (matrix[i][firstIndex] == target || matrix[i][lastIndex] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 5;
//        int[][] matrix = {{1,3,5}};
//        int target = 3;
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        // 失败
        System.err.println(new Lc240SearchMatrix().searchMatrix(matrix, target));
    }
}
