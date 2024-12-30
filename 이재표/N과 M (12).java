import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static int M;
    static Set<String> set;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<String>();
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        input = br.readLine().split(" ");
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        permutation("", 0, 0);
    }

    private static void permutation(String ans, int startIdx, int cnt) {
        if (cnt == M) {
            if(set.contains(ans)) {
                return;
            }
            System.out.println(ans.trim());
            set.add(ans);
            return;
        }
        for(int i=startIdx; i<N; i++) {
            permutation(ans+input[i]+" ", i, cnt+1);
        }
    }
}
