import java.io.*;
import java.util.*;
public class Cbarn {

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int n = Integer.parseInt(reader.readLine());

        int[] barn = new int[n];    

        for (int i = 0; i < n; i++){
            barn[i] = Integer.parseInt(reader.readLine());
        }

        int result = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            int dist = 0;
            for (int i = start; i < start + n; i++) {
                dist += barn[i % n] * (i - start);
            }

            result = Math.min(result, dist);
        }

        writer.println(result);
        System.out.println(result);

        writer.close();
    }
}
