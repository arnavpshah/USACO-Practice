import java.io.*;
import java.util.*;

public class Diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("diamond.in"));
        StringTokenizer initial = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(initial.nextToken());
        int k = Integer.parseInt(initial.nextToken());
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            diamonds[i] = Integer.parseInt(read.readLine());
        }
        read.close();

        int most = 0;

        for (int x : diamonds) {
            int fittable = 0;

            for (int y : diamonds) {
                if (x <= y && y <= x + k) { fittable++; }
            }
            most = Math.max(most, fittable);
        }

        PrintWriter written = new PrintWriter("diamond.out");
        written.println(most);
        written.close();
    }
}