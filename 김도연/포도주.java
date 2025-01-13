import java.util.Scanner;

public class Main {

    public int solution(int[] drinks) {
        if (drinks.length == 1) return drinks[0];
        int[][] arr = new int[drinks.length][2];
        arr[0][0] = drinks[0];
        arr[0][1] = drinks[0];
        arr[1][0] = drinks[1];
        arr[1][1] = drinks[1] + arr[0][0];

        int max = arr[1][1];
        for (int i = 2; i < drinks.length; i++) {
            arr[i][0] = drinks[i] + arr[i - 2][1];
            arr[i][1] = drinks[i] + arr[i - 1][0];
            max = Math.max(max, Math.max(arr[i][0], arr[i][1]));
        }

        return max;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        int solution = T.solution(arr);
        System.out.println(solution);
    }
}
