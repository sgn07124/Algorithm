import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void problem12933() throws IOException {
        final char[] WORD = {'q','u','a','c','k'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] duck = br.readLine().toCharArray();

        int cnt = 0;  // 오리 마리 수
        int length = duck.length;


        while(length>0){
            if ( length % 5 != 0) {
                break;
            }
//            printCharArr(duck);

            int index[] = new int[5]; // quack 소리가 각각 담긴 위치를 담는 배열
            int loc = 0; // WORD 어레이 가리키는 인덱스
            for(int i=0; i<duck.length; i++){
                if(WORD[loc] == duck[i]){
                    index[loc] = i;
                    loc++;
                }

                if(loc==5){
                    length -= 5;
                    for(int j=0;j<5;j++){ // 한마리 확인
                        duck[index[j]] = 'z';
                    }
                    loc=0;
                }
            }
            // 그대로 일시 한마리도 확인이 안됨 = 녹음에 오류가 있었음.
            if(loc != 0){
                cnt = 0;
                break;
            }
            cnt++; // 오리 한마리 추가
//            printArr(index);

        }

        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
  public static void main(String[] args) throws IOException {
        problem12933();
    }
}
