import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem1260 {
    public static int[][] branch;
    public static boolean[] visit; // 초기값 null
    public static Queue<Integer> queue;
    public static int N;
    public static int M;
    public static int V;

    public static void dfs(int start) {  // start → V
        visit[start] = true;  // 방문한 정점을 한 번 더 가면 안됨
        //System.out.print(start);
        System.out.print(start + " ");
        for(int i = 1; i <= N; i++) {
            //System.out.print(start);
            if(branch[start][i] == 1 && visit[i] == false) { // 방문하지 않은 정점인 경우,
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
            branch[a][b] = branch[b][a] = 1;  // 무방향 그래프
        }

        /* dfs */
        dfs(V);
        System.out.println();

        Arrays.fill(visit, false);  // visit을 false로 초기화

        /* bfs */
        bfs(V);
    }


}
/*
0 1 2 3 4
1 0 1 1 1
2 1 0 0 1
3 1 0 0 1
4 1 1 1 0
from(행) to(열)
start = 1 : 1-> 2 -> 4 -> 3
 */

// 이거 dfs 부분에서 start만 출력되고 dfs(i)를 실행하지 못하는거 같음
