import java.io.*;
import java.util.*;
public class Paint {

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("paint.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[] a = new int[2];
        int[] b = new int[2];

        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());

        if (a[0] > b[0]) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int result = Math.max(a[1], b[1]) - Math.min(a[0], b[0]);

        if (a[1] < b[0]) result -= b[0] - a[1];

        writer.println(result);

        System.out.println(result);

        writer.close();

    }
}