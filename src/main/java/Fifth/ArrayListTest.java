package Fifth;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        // String 타입의 리스트 생성
        // 파이썬에서는 list = [] 와 같은 것
        ArrayList<String> list = new ArrayList<String>();

        // list.add()는 Python의 append와 동일하다.
        list.add("Milk");
        list.add("grape");
        list.add("apple");
        // 특정 위치에 요소를 넣고 있음
        // 원래 있던 녀석들은 뒤쪽으로 밀려남
        list.add(1, "butter");
        list.add(2, "strawberry");
        // 특정 위치에 있는 요소를 제거한다.
        // grape이 지워짐.
        list.remove(3);



        for(int i = 0 ; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}


