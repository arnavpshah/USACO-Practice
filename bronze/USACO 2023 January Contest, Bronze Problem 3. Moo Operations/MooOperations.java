import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MooOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        for (int q = Integer.parseInt(in.readLine()); q > 0; q--) {
            String string = in.readLine();
            int answer = -1;
            if (string.contains("MOO")) {
                answer = string.length() - 3;
            } else if (string.contains("MOM") || string.contains("OOO")) {
                answer = string.length() - 2;
            } else if (string.contains("OOM")) {
                answer = string.length() - 1;
            }
            out.append(answer).append('\n');
        }
        System.out.print(out);
    }
}