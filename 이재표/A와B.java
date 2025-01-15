import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        StringBuilder sb = new StringBuilder(t);
        while(sb.length()>=s.length()){
            if(sb.toString().equals(s)){
                System.out.println(1);
                return;
            }
            if(sb.charAt(sb.length()-1)=='B'){
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }else if(sb.charAt(sb.length()-1)=='A'){
                sb.deleteCharAt(sb.length() - 1);
            }else{
                break;
            }
        }
        System.out.println(0);
    }
}
