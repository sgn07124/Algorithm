import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 3kg, 5kg 봉지가 있고, 19kg을 옮긴다고 할 때의 봉지의 최소 개수
        // 5kg * 2 + 3kg * 3 => 5봉지
        // 만약 4kg 처럼 정확하게 안 떨어지면 -1 출력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        cnt = n/5;  // cnt == 3
        n %= 5;

        if (n % 3 != 0) {  // 나머지가 4로 3이 아닌 경우,
            for (int i = 1; i <= cnt; i++) {
                cnt--;  // cnt를 1빼면 나머지는 4+5가 됨...
                n += 5;
                if (n % 3 == 0) {
                    cnt += n / 3;  // cnt = 2 + 3
                    break;
                }
            }
        } else {  // 나머지가 3으로 떨어지는 경우
            cnt += n/3;
        }
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
}
