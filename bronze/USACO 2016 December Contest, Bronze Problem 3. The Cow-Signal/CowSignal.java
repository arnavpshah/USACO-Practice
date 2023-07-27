import java.io.*;
import java.util.*;

public class CowSignal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cowsignal.in"));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String[] signal = new String[h];
        for (int r = 0; r < h; r++) { signal[r] = reader.readLine(); }

        PrintWriter writter = new PrintWriter("cowsignal.out");
        for (int i = 0; i < s * h; i++) {
            for (int j = 0; j < s * w; j++) {
                writter.print(signal[i / s].charAt(j / s));
            }
            writter.println();
        }
        writter.close();
    }
}