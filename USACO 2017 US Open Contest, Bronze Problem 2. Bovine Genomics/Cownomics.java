import java.io.*;
import java.util.*;

public class Cownomics {

    static int n, m;

    static char[][] sGenome;
    static char[][] pGenome;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sGenome = new char[n][m];
        for (int i = 0; i < n; i++) {
            sGenome[i] = reader.readLine().toCharArray();
        }

        pGenome = new char[n][m];
        for (int i = 0; i < n; i++) {
            pGenome[i] = reader.readLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            if (possible(i)) result++;
        }

        writer.println(result);
        writer.close();
    }

    static boolean possible(int idx) {

        boolean[] inS = new boolean[4];
        boolean[] inP = new boolean[4];

        for (int i = 0; i < n; i++) {
            if (sGenome[i][idx] == 'A') inS[0] = true;
            if (sGenome[i][idx] == 'C') inS[1] = true;
            if (sGenome[i][idx] == 'G') inS[2] = true;
            if (sGenome[i][idx] == 'T') inS[3] = true;

            if (pGenome[i][idx] == 'A') inP[0] = true;
            if (pGenome[i][idx] == 'C') inP[1] = true;
            if (pGenome[i][idx] == 'G') inP[2] = true;
            if (pGenome[i][idx] == 'T') inP[3] = true;
        }

        for (int i = 0; i < 4; i++) {
            if (inS[i] && inP[i]) return false;
        }

        return true;
    }

}