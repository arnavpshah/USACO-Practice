import java.io.*;
import java.util.*;


public class Mowing {

    static int n;
    static int[][] placements = new int[2001][2001];
    static char[] dirs;
    static int[] steps;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        n = Integer.parseInt(reader.readLine());

        dirs = new char[n];
        steps = new int[n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            dirs[i] = st.nextToken().charAt(0);
            steps[i] = Integer.parseInt(st.nextToken());
        }

        int t = 1;

        int x = 1000, y = 1000;

        placements[y][x] = t;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int dx = 0, dy = 0;

            switch (dirs[i]) {
                case 'N' : dy = -1; break;
                case 'S' : dy = 1; break;
                case 'W' : dx = -1; break;
                case 'E' : dx = 1; break;
            }

            for (int j = 0; j < steps[i]; j++) {
                t++;
                x += dx;
                y += dy;

                if (placements[y][x] != 0) {
                    result = Math.min(result, t - placements[y][x]);
                }

                placements[y][x] = t;
            }
        }

        if (result == Integer.MAX_VALUE) result = -1;

        writer.println(result);
        writer.close();
    }
}