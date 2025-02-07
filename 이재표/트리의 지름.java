
import java.io.*;
import java.util.*;

public class Main {
    static int max =0;
    static Map<Integer, List<int[]>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.putIfAbsent(in[0], new ArrayList<>());
            map.get(in[0]).add(new int[]{in[1], in[2]});
        }
        search(1);
        System.out.println(max);
    }

    private static int search(int start) {
        List<int[]> nodes = map.getOrDefault(start, new ArrayList<>());
        List<Integer> values = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nodes.size(); i++) {
            int search = nodes.get(i)[1] + search(nodes.get(i)[0]);
            values.add(search);
        }
        if(values.isEmpty()){
            return 0;
        }
        Collections.sort(values,Collections.reverseOrder());
        sum+=values.get(0);
        if(values.size() >1){
            sum+=values.get(1);
        }
        max = Math.max(max, sum);
        return values.get(0);
    }
}

