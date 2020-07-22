package Sixth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 문자열 정렬
public class SortTest {
    public static void main(String[] args) {
        // 문자열 배열
        String[] sample = {"I", "say", "you", "test"};

        // 배열을 리스트로 변경한 것이다.
        // 파이썬은 그냥 []을 씌워버리면 됨
        // 자바가 조금 더 복잡함.
        List<String> list = Arrays.asList(sample);

        // 자바 자료구조인 Collections에 있는
        // 소팅을 활용하여 정렬을 수행한다.
        Collections.sort(list);

        System.out.println(list);
    }
}
