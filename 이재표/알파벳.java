import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static String[] str;
    static int R, C;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = in[0];
        C = in[1];
        str = new String[R];
        for (int i = 0; i < R; i++) {
            str[i] = br.readLine();
        }

        Set<Character> s = new HashSet<>();
        s.add(str[0].charAt(0));
        dfs(0, 0, s, 1);
        System.out.println(max);
    }

    

    private static void dfs(int r, int c, Set<Character> s, int depth) {
        max = Math.max(max, depth); 

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (s.contains(str[nr].charAt(nc))) {
                continue;
            }

            s.add(str[nr].charAt(nc));
            dfs(nr, nc, s, depth + 1);
            s.remove(str[nr].charAt(nc)); 
        }
    }
}
