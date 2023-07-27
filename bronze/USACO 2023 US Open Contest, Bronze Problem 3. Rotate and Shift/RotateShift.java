import java.util.*;
import java.io.*;

public class RotateShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mx = 200005;
        int[] A = new int[mx];
        int[] ans = new int[mx];

        int N, K, T;
        N = scanner.nextInt();
        K = scanner.nextInt();
        T = scanner.nextInt();

        for (int i = 1; i <= K; i++) {
            A[i] = scanner.nextInt();
        }
        A[K + 1] = N;
        for (int i = 1; i <= K; i++) {
            for (int j = A[i]; j < A[i + 1]; j++) {
                // where is j relative to A[i]
                int current_shift = j - A[i];
                // j moves backwards T times
                int new_shift = current_shift - T;
                int diff = A[i + 1] - A[i];
                new_shift = (new_shift % diff + diff) % diff; // take mods to get it back in the range [0, diff-1].

                // A[i] moves new_shift times, then we shift our perspective by T.
                ans[(A[i] + new_shift + T) % N] = j;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i]);
            if (i + 1 < N)
                System.out.print(" ");
        }
        System.out.println();
    }
}
