import java.io.*;
import java.util.*;
public class CircleCross {


    static char[] farm;
    static boolean[] seen;

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        farm = reader.readLine().toCharArray();

        seen = new boolean[26];

        int result = 0;

        for (int i = 0; i < farm.length; i++) {
            if (seen[farm[i] - 'A']) continue;

            seen[farm[i] - 'A'] = true;

            HashSet<Character> crosses = new HashSet<>();
            for (int j = i + 1; j < farm.length; j++) {

                if (farm[i] == farm[j]) break;

                if (!crosses.contains(farm[j])) crosses.add(farm[j]);
                else crosses.remove(farm[j]);
            }

            result += crosses.size();
        }

        result /= 2;

        writer.println(result);
        System.out.println(result);
        reader.close();
        writer.close();
    }
}