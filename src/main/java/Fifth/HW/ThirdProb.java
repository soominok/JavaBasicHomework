package Fifth.HW;

/* 문제 3.
 * 10 ~ 60까지의 난수를 200개 생성한다.
 * 생성한 정보들에 대한 빈도수를 판정하라.
 */

import java.util.ArrayList;
import java.util.Random;

// 10 ~ 60까지 난수 200개 생성함.
public class ThirdProb {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> freq = new ArrayList<Integer>();

        Random rand = new Random();
        final int MAX = 200;
        final int RANGE = 51;

        for (int i = 0; i < MAX; i++) {
            // 10 ~ 60 사이의 숫자가 나올 것.
            list.add(rand.nextInt(RANGE) + 10);
        }

        for(int i = 0; i < MAX; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 51개만큼 빈도수 리스트 생성 됨.
        // 빈도수 리스트 0번째는 10의 숫자가 몇 개 나왔는지
        for(int i =0; i < RANGE; i++) {
            freq.add(i, 0);
        }

        for(int i = 0; i < MAX; i++) {
            int idx = list.get(i) - 10;
            // System.out.println("idx: " + idx);
            // 1번에 어떤 값이 나왔다하면, 한 값에 tmp++가 셋팅되는 것
            int tmp = freq.get(idx);
            freq.add(idx, ++tmp);
            // 뒤에 있는 것이 하나씩 밀리기 때문에 뒤에 있는 값을 지워줘야 함.
            freq.remove(idx + 1);

            // 현재 가지고 있는 리스트에서 어떤 값이 나왔는가?
            // 해당 값을 빈도수 배열의 인덱스로 사용한다.

            // 이렇게 쓰면 문제점은
            // 처음할 때 값이 있는지 없는지 모름!
            // freq.add(list.get(i) - 1, )

            // 따라서 현재 가져온 값이 기존에 이미 있는지 없는지를 판정해야 함.
            // 값이 존재한다면 해당값 +1을 넣고 뒤로 밀린값은 삭제
            // 이렇게 하면 안정적인 빈도수 값을 얻을 수 있음.
            // System.out.println(freq.size());
            // 0이 나오고 있는 것으로 보아 freq.add를 아직 쓸 수 없음.

        }

        for(int i = 0; i < RANGE; i++) {
            System.out.print(freq.get(i) + " ");
        }

        System.out.println();
    }
}
