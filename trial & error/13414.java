import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> list = new LinkedHashSet<>();

        int k = sc.nextInt();
        int l = sc.nextInt();

        for (int i = 0; i < l; i++) {
            String stu = sc.next();
            if (list.contains(stu)) {  // 대기목록에 학번이 있으면 (가장 위의) 삭제
                list.remove(stu);
            }
            list.add(stu);
        }
        //System.out.println(list);  // [20103324, 20133221, 20140101, 01234567, 20093778, 20103325]
        int cnt = 0;
        for (String i : list) {
            if (cnt == 3) break;
            System.out.println(i);
            cnt++;
        }
    }
}
