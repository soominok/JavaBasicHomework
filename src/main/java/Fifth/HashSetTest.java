package Fifth;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


// 문제 3번 해쉬 셋으로 풀어보기

public class HashSetTest {
    public static void main(String[] args) {
        // integer 집합을 다루겠다.
        // 집합의 특성 : 원소의 중복을 허용하지 않겠다.
        Set<Integer> s = new HashSet<Integer>();
        Random rand = new Random();

        // 변수선언에서 final은 한번 입력받고 더이상 값을 변경할 필요가 없는 경우에
        // final을 넣어 더이상 변경하지 못하도록 하는 것이다.
        final int MAX = 200;
        final int RANGE = 51;
        final int BIAS = 10;
        int cnt = 0;

        int[] arr = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            arr[i] = rand.nextInt(RANGE) + BIAS;
        }


        // Java의 새로운 foreach 구문
        // 파이썬에서 for i in range와 비슷한 구문
        // arr에 있는 값을 땡겨와서 value에 넣는다. (그 타입이 Integer 임을 명시)
        // arr에는 랜덤한 정수 형태 integer가 들어 있는 것.
        for(Integer value: arr) {
            cnt++;
            // s는 집합이므로 중복을 혀용하지 않으며
            // s.add()의 결과는 중복이라면 0을 리턴하고
            // 중복이 아니라면 1을 리턴하게 된다.
            // 즉 중복된 녀석이 출력이 되고
            // 중복이 아닌 경우엔 출력이 되지 않는다.
            if(!s.add(value)) {
                System.out.println(cnt + "루프-중복된 녀석: " + value);
            }
        }

        // 마지막은 중복없는 값들이 순서대로 출력되고 있음.
        System.out.println("중복되지 않은 녀석: " + s);

    }
}
