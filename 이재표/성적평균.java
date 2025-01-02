
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]in=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N=in[0];
        int K=in[1];
        int[]score=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[]cum=new int[N+1];
        cum[0]=0;
        for(int i=1;i<=N;i++){
            cum[i]=cum[i-1]+score[i-1];
        }
        for(int i=0;i<K;i++){
            int[]range=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double c=((double)cum[range[1]]-(double)cum[range[0]-1])/(range[1]-range[0]+1);
            System.out.printf("%.2f\n",Math.round(c*100)/100.0);
        }
    }
}
