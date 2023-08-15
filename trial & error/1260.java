import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] branch;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static int N;
    public static int M;
    public static int V;

    public static void dfs(int start) {  // start → V
        visit[start] = true;
        System.out.println(start + " ");
        for(int i = 1; i <= N; i++) {
            if(branch[start][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);  // 첫 지점
        visit[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            for(int i = 1; i<branch.length; i++) {
                if (branch[tmp][i] == 1 && visit[i] == false) {
                    queue.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 정점
        int M = sc.nextInt();  // 간선
        int V = sc.nextInt();  // start

        branch = new int[1001][1001];
        visit = new boolean[1001];

        /* 인접 행렬 생성 */
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            branch[a][b] = branch[b][a] = 1;
        }

        /* dfs */
        dfs(V);
        System.out.println();

        Arrays.fill(visit, false);

        /* bfs */
        bfs(V);
    }


}
// 이거 dfs 부분에 문제 있어서 디버깅 해봐야됨.
