import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Pos> chicken;
    static int N, M;
    static int[][] map;
    static ArrayList<Pos> houses;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = in[0];
        M = in[1];

        map = new int[N][N];
        chicken = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    houses.add(new Pos(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Pos(i, j));
                }
            }
        }

        combination(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    static int findChickenDistance(List<Pos> select) {
        int sum = 0;
        for (Pos h : houses) {
            int min = Integer.MAX_VALUE;
            for (Pos p : select) {
                min = Math.min(min, Math.abs(p.c - h.c) + Math.abs(p.r - h.r));
            }
            sum += min;
        }
        return sum;
    }

    static void combination(int depth, int start, List<Pos> selected) {
        if (depth == M) {
            answer = Math.min(answer, findChickenDistance(selected));
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            combination(depth + 1, i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
