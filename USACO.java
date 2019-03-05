import java.io.IOException;
import java.util.Scanner;

public class USACO {
    public static void main(String[] args) {

    }

    public static int bronze(String filename) throws IOException {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        String init = s.nextLine();
        String[] args = init.split(" ");
        if (args.length != 4) {
            throw new IllegalArgumentException();
        }
        int r,c,e,n = 0;
        r=Integer.parseInt(args[0]);
        c=Integer.parseInt(args[1]);
        e=Integer.parseInt(args[2]);
        n=Integer.parseInt(args[3]);
        int[][] pasture = new int[r][c];
        for(int i = 0; i < r; i++){
            String line = s.nextLine();
            int j = 0;
            for(String square : line.split(" ")){
                int val = Integer.parseInt(square);
                pasture[i][j]=val;
                j++;
            }
        }
        int[][] instructions = new int[n][3];
        for(int i = 0; i < n; i++){
            String line = s.nextLine();
            int j = 0;
            for(String val : line.split(" ")){
                int x = Integer.parseInt(val);
                instructions[i][j]=x;
            }
        }
        
        return 0;
    }

    public static int silver(String filename) {
        return 0;
    }
}