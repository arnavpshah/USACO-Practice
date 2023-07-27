import java.io.*;
import java.util.*;


public class LostCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int direction = 1;
        int totalDistance = 0;
        int directionDistance = 1;

        while (true) {
            // found bessie
            if ((direction == 1 && x <= y && y <= (x + directionDistance)) ||
                    (direction == -1 && y <= x && (x - directionDistance <= y))) {

                totalDistance += Math.abs(y - x); // distance to bessie from original position
                pw.println(totalDistance);
                break;
            } else { // did not find bessie yet
                totalDistance += (directionDistance * 2); // add to the distance count
                directionDistance *= 2; // double the distance
                direction *= -1; // switch directions
            }
        }

        pw.close();
    }
}
