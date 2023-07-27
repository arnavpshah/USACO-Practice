import java.util.ArrayList;
import java.util.Scanner;

public class Feb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int mn = 0, mx = 0;

        int curIdx = 0;
        while (curIdx < n) {
            if (s.charAt(curIdx) == 'F') {
                curIdx++;
                continue;
            }

            int nextIdx = curIdx + 1;
            while (nextIdx < n && s.charAt(nextIdx) == 'F') nextIdx++;
            if (nextIdx == n) break;

            int num_F = nextIdx - curIdx - 1;

            if (s.charAt(nextIdx) == s.charAt(curIdx)) {
                // Case 1: Solve something like BFFFFFB
                int length = num_F + 2;

                // First, solve for mn
                if (length % 2 == 0) {
                    // At best we can have something like BEBEBB
                    mn += 1;
                } else {
                    // We can alternate BEBEB
                    mn += 0;
                }

                // Next, solve for mx
                mx += length - 1;
            } else {
                // Case 2: Solve something like BFFFFFE
                int length = num_F + 2;

                // First, solve for mn
                if (length % 2 == 0) {
                    // We can alternate BEBEBE
                    mn += 0;
                } else {
                    // At best we have BEBEE
                    mn += 1;
                }

                // Next, solve for mx
                mx += length - 2;
            }

            curIdx = nextIdx;
        }

        // Special case: beginning / ending F's
        int num_beginning_F = 0;
        while (num_beginning_F < n && s.charAt(num_beginning_F) == 'F') num_beginning_F++;
        int num_ending_F = 0;
        while (num_ending_F < n && s.charAt(n - 1 - num_ending_F) == 'F') num_ending_F++;

        if (num_beginning_F == n) {
            // everything is an F! special case
            mn = 0;
            mx = n - 1;
        } else {
            // mn doesn't change, since we can always alternate the beginning /
            // ending properly
            mx += num_beginning_F;
            mx += num_ending_F;
        }

        ArrayList<Integer> possible_levels = new ArrayList<>();
        if (num_beginning_F == 0 && num_ending_F == 0) {
            // Special case: We can only change in increments of two
            assert (mx - mn) % 2 == 0;
            for (int i = mn; i <= mx; i += 2) possible_levels.add(i);
        } else {
            for (int i = mn; i <= mx; i++) possible_levels.add(i);
        }

        System.out.println(possible_levels.size());
        for (int i : possible_levels) {
            System.out.println(i);
        }
    }
}
