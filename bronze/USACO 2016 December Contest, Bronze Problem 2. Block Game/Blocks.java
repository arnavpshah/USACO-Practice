import java.io.*;

public class Blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int n = Integer.parseInt(reader.readLine());
        String[][] words = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            words[i] = new String[]{input[0], input[1]};
        }

        int[] maxBlocks = new int[26];
        for (String[] w : words) {
            int[] freq1 = countFreq(w[0]);
            int[] freq2 = countFreq(w[1]);
            for (int c = 0; c < 26; c++) {
                maxBlocks[c] += Math.max(freq1[c], freq2[c]);
            }
        }

        for (int i : maxBlocks) {
            writer.println(i);
        }

        reader.close();
        writer.close();
    }

    static int[] countFreq(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        return freq;
    }
}
