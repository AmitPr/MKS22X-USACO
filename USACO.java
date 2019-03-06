import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class USACO {
    public static void main(String[] args) {
        try {
            //System.out.println(bronze("TestCases/makelake.5.in"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int bronze(String filename) throws IOException {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        String init = s.nextLine();
        String[] args = init.split(" ");
        if (args.length != 4) {
            throw new IllegalArgumentException();
        }
        int r, c, e, n = 0;
        r = Integer.parseInt(args[0]);
        c = Integer.parseInt(args[1]);
        e = Integer.parseInt(args[2]);
        n = Integer.parseInt(args[3]);
        int[][] pasture = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = s.nextLine();
            int j = 0;
            for (String square : line.split(" ")) {
                int val = Integer.parseInt(square);
                pasture[i][j] = val;
                j++;
            }
        }
        int[][] instructions = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            int j = 0;
            for (String val : line.split(" ")) {
                int x = Integer.parseInt(val);
                instructions[i][j] = x;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            int r_s = instructions[i][0];
            int c_s = instructions[i][1];
            int d_s = instructions[i][2];
            int max = 0;
            for (int y = r_s - 1; y < r_s + 2; y++) {
                for (int x = c_s - 1; x < c_s + 2; x++) {
                    if (pasture[y][x] > max) {
                        max = pasture[y][x];
                    }
                }
            }
            max -= d_s;
            for (int y = r_s - 1; y < r_s + 2; y++) {
                for (int x = c_s - 1; x < c_s + 2; x++) {
                    pasture[y][x] = pasture[y][x] > max ? max : pasture[y][x];
                }
            }
        }
        int total = 0;
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (pasture[y][x] < e) {
                    pasture[y][x] = e - pasture[y][x];
                    total+=pasture[y][x];
                } else {
                    pasture[y][x] = 0;
                }
            }
        }
        return total*72*72;
    }

    public static String arrToString(int[][] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                s += arr[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static int silver(String filename) {
        return 0;
    }
}