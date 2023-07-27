import java.io.*;
import java.util.*;

public class Pails {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer input = new StringTokenizer(read.readLine());
        read.close();

        int buck1 = Integer.parseInt(input.nextToken());
        int buck2 = Integer.parseInt(input.nextToken());
        int order = Integer.parseInt(input.nextToken());

        int closest = 0;
        // Try all possible combinations of the first & second bucket.
        for (int first = 0; first <= order; first++) {
            if (buck1 * first > order) { break; }
            for (int second = 0; second <= order; second++) {
                int n = (buck1 * first) + (buck2 * second);
                if (n > order) { break; }
                closest = Math.max(closest, n);
            }
        }

        PrintWriter written = new PrintWriter("pails.out");
        written.println(closest);
        written.close();
    }
}