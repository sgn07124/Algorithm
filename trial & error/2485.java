import java.util.Scanner;

public class Main {  // 현재 가로수 사이의 거리 구하고 거리들이 처ㅣ대공약수 구하고 배치
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tree = new int[n];  // 1 3 7 13
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int[] dis = new int[n - 1];  // 가로수 사이의 거리
        for (int i = 0; i < n - 1; i++) {
            dis[i] = tree[i + 1] - tree[i];
        }

        int gcd = 0;
        gcd = GCD(dis[0], dis[1]);  // 최대공약수 구하고
        for (int i = 2; i < n - 2; i++) {
            gcd = GCD(gcd, dis[i]);
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++) {  // 가로수 사이의 거리 / gcd -1
            total += ((dis[i] / gcd) - 1);
        }
        System.out.println(total);
    }
}
