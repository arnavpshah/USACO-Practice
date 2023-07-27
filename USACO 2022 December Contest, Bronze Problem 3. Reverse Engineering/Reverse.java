import java.io.*;
import java.util.*;

public class Reverse {

    static int t, n, m;

    static String[] inputs;
    static char[] outputs;

    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            reader.readLine();
            StringTokenizer st = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());



            inputs = new String[m];
            outputs = new char[m];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(reader.readLine());

                inputs[j] = st.nextToken();
                outputs[j] = st.nextToken().charAt(0);
            }

            solve();
        }

    }

    public static void solve() {
        checked = new boolean[n];

        while (true) {
            boolean possible = false;

            for (int j = 0; j < n; j++) {
                if (check(j, '0', '0') || check(j, '0', '1') ||
                        check(j, '1', '0') || check(j, '1', '1')) {

                    possible = true;
                }
            }


            if (!possible) {
                System.out.println("LIE");
                return;
            }

            if (complete('0') || complete('1')) {
                System.out.println("OK");
                return;
            }

        }
    }

    public static boolean check(int pos, char in, char out) {

        if (checked[pos]) return false;

        for (int i = 0; i < m; i++) {
            if (inputs[i] != null && inputs[i].charAt(pos) == in && outputs[i] != out) {
                return false;
            }
        }
        checked[pos] = true;

        for (int i = 0; i < m; i++) {
            if (inputs[i] != null && inputs[i].charAt(pos) == in && outputs[i] == out) {
                inputs[i] = null;
            }
        }

        return true;
    }

    public static boolean complete (char out) {
        for (int i = 0; i < m; i++) {
            if (inputs[i] != null && outputs[i] != out) return false;
        }
        return true;
    }
}
