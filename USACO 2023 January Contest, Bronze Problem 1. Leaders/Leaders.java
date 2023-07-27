import java.io.*;
import java.util.*;

public class Leaders {

    static int n;

    static char[] cows;

    static int[] lists;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        n = Integer .parseInt(reader.readLine());
        cows = reader.readLine().toCharArray();

        lists = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            lists[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int firstG = - 1, lastG = - 1;
        int firstH = - 1, lastH = - 1;

        for (int i = 0; i < n; i++) {
            if (cows[i] == 'G') {
                if (firstG == -1) firstG = i;

                lastG = i;
            }
            else if (cows[i] == 'H') {
                if (firstH == -1) firstH = i;

                lastH = i;
            }
        }

        int result = 0;

        if (lists[firstG] >= lastG) {
            for (int i = 0; i < firstG; i++) {
                if (i == firstH) continue;
                if (cows[i] == 'H' && lists[i] >= firstG) result++;
            }
        }

        if (lists[firstH] >= lastH) {
            for (int i = 0; i < firstH; i++) {
                if (i == firstG) continue;
                if (cows[i] == 'G' && lists[i] >= firstH) result++;
            }
        }

        // check it it's possible for both firstG and firstH to be later
        if ((lists[firstG] >= lastG || (firstG <= firstH && lists[firstG] >= firstH)) &&
                ((lists[firstH] >= lastH || (firstH <= firstG && lists[firstH] >= firstG)))) {
            result++;
        }

        System.out.println(result);
    }
}
