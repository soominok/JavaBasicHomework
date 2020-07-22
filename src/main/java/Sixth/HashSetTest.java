package Sixth;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();

        s1.add("A");
        s1.add("B");
        s1.add("C");
        s2.add("A");
        s2.add("D");

        Set<String> union = new HashSet<String>(s1);
        union.addAll(s2);

        Set<String> intersection = new HashSet<String>(s1);
        intersection.retainAll(s2);

        // 백엔드에서 데이터 분류 시 유용한 작업
        // 중복은 제외하고 모든 원소 출력
        System.out.println("합집합: " + union);
        // 중복된 원소 출력
        System.out.println("교집합: " + intersection);
    }
}
