import java.io.*;
import java.util.*;


public class Feeding {

    static int t, n, k;

    static char[] cows;

    static int patches;

    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(reader.readLine());


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            cows = reader.readLine().toCharArray();

            char[] result = new char[n];
            Arrays.fill(result, '.');

            patches = 0;

            int prevG = -k - 1, prevH = -k - 1;
            for (int j = 0; j < n; j++) {
                if (cows[j] == 'G' && j - prevG > k) {
                    if (j + k < n) {
                        prevG = j + k;
                    } else {
                        if (result[j] == 'H') {
                            prevG = j - 1;
                        } else {
                            prevG = j;
                        }

                    }
                    patches++;
                    result[prevG] = 'G';

                }
                else if (cows[j] == 'H' && j - prevH > k) {
                    if (j + k < n) {
                        prevH = j + k;
                    } else {
                        if (result[j] == 'G') {
                            prevH = j - 1;
                        } else {
                            prevH = j;
                        }

                    }
                    patches++;
                    result[prevH] = 'H';
                }
            }

        System.out.println(patches);
        System.out.println(String.valueOf(result));
        }

    }
}