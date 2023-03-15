package leetcode.array.BinarySearch;

public class sqrt_69 {
    public static void main(String[] args) {
        int res = mySqrt(8);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
        double root;
        if (x == 1 || x == 0) {
            root = x;
        } else {
            root = x / 2;
        }
        double sq = root * root;
        double last = x;
        while (Math.abs(sq - x) > (0.001 * 0.001)) {
            if (sq > x) {
                last = root;
                root = root / 2;
                sq = root * root;
            } else {
                root = (root + last) / 2;
                sq = root * root;
            }
        }
        return (int) Math.round(root);
    }
}
