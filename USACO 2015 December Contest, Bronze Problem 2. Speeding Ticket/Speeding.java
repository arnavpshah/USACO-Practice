import java.io.*;
import java.util.*;
public class Speeding {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        StringTokenizer  st = new StringTokenizer((reader.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] limits = new int[100];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int dist = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            for (int j = 0; j < dist; j++) {
                limits[curr] = limit;
                curr++;
            }
        }


        int[] speeds = new int[100];
        curr = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = 0; j < dist; j++) {
                speeds[curr] = speed;
                curr++;
            }
        }

        int result = 0;

        for (int i = 0; i < 100; i++){
            result = Math.max(result, speeds[i] - limits[i]);
        }


        writer.println(result);

        System.out.println(result);

        writer.close();

    }

}
