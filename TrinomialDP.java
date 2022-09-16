/*
below shows a sample array of n = 3, array size is n + 1 rows and 2n + 3 columns
0 0 0 0 1 0 0 0 0  i = 0
0 0 0 1 1 1 0 0 0  i = 1
0 0 1 2 3 2 1 0 0  i = 2
0 1 3 6 7 6 3 1 0  i = 3
the array size is to columns bigger than Trinomial coefficient so that first and last column have value of 0,
so that we can avoid out of bound problem at index k-1 and k+1
 */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // create an array of n + 1 rows and 2n + 3 columns, for larger n, requires long data type.
        // 1 row more than n to make row index align with n.
        // 2 columns more than 2n + 1 to avoid out of bound problem at index k-1 and k+1.
        long[][] T = new long[n + 1][2 * n + 3]; 
        if (k > n || k < -n) return 0;
        T[0][n + 1] = 1; // assign center entry of first row to 1

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 2 * n + 2; j++)
                T[i][j] = T[i - 1][j - 1] + T[i - 1][j] + T[i - 1][j + 1];
        }
        return T[n][n + 1 + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
