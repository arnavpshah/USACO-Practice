import java.io.*;
import java.util.*;
public class BackForth {

    static int[] side = new int[20];
    static int[] volume = new int[20];

    static HashSet<Integer> levels = new HashSet<>();

    public static void main(String args[]) throws Exception {
        Scanner reader = new Scanner(new FileReader("backforth.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));


        for (int i = 0; i < 20; i++) {
            volume[i] = reader.nextInt();
            side[i] = i/10;
        }

        simulate(0, 1000);
        writer.println(levels.size());
        System.out.println(levels.size());

        writer.close();
    }

    public static void simulate(int day, int lvl) {
        if (day == 4) {
            levels.add(lvl);
            return;
        }

        int b = day % 2;

        for (int i = 0; i < 20; i++) {
            if (side[i] != b) continue;

            side[i] ^= 1;

            int delta = side[i] == 0 ? -volume[i] : volume[i];


            simulate(day + 1, lvl + delta);

            side[i] ^= 1;

        }
    }
}