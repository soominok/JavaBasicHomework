package Sixth;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// ThirdProb 문제!!
// 빈도수 구하는 문제는 HashMap으로 구하는 것이 제일 보기 좋고 잘 나옴!!
public class HashMapProb {
    public static void main(String[] args) {
        final int START = 0;
        final int MAX = 200;
        final int RANGE = 51;
        final int BIAS = 10;

        Random rand = new Random();
        // 어떤 숫자가 몇 번 반복되었다가 문제였으니까
        // key값과 value값 모두 Integer로 지정!
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        Integer[] samples = new Integer[MAX];

        // 초기화한 상태
        for(int i = START; i < MAX; i++) {
            samples[i] = rand.nextInt(RANGE) + BIAS;
        }

        for(Integer sample: samples) {
            Integer freq = m.get(sample);
            m.put(sample, (freq == null) ? 1: freq + 1);
        }

        System.out.println(m.size() + "개의 샘플이 있다.");
        System.out.println(m.containsKey(17));
        // 비어있느냐
        System.out.println(m.isEmpty());
        System.out.println(m);

    }
}
