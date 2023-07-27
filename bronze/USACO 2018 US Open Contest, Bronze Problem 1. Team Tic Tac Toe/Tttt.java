import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
public class Tttt {

    static char[][] board = new char[3][3];
    static HashSet<String> wins = new HashSet<>();
    static HashSet<String> teamwins = new HashSet<>();

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        for (int i = 0; i < 3; i++) board[i] = reader.readLine().toCharArray();

        TreeSet<Character> elements =  new TreeSet<>();
        for (int i = 0; i < 3; i++) {
            elements = new TreeSet<>();
            for (int j = 0; j < 3; j++) elements.add(board[i][j]);
            update(elements);


            elements = new TreeSet<>();

            for (int j = 0; j < 3; j++) elements.add(board[j][i]);
            update(elements);
        }

        elements = new TreeSet<>();
        for (int i = 0; i < 3; i++) elements.add(board[i][i]);
        update(elements);

        elements = new TreeSet<>();
        for (int i = 0; i < 3; i++) elements.add(board[i][2 - i]);
        update(elements);

        writer.println(wins.size());
        writer.println(teamwins.size());


        writer.close();

    }

    public static void update(TreeSet<Character> elements) {
        if (elements.size() == 1) wins.add("" + elements.first());
        else if (elements.size() == 2) teamwins.add("" + elements.first() + elements.last());
    }
}