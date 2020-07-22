package Fifth;

import java.util.Vector;

// 제네릭
// 다양한 데이터 형태를 설정할 수 있음.
// 그것이 object임!!
// 자바의 모든 객체를 관장하는 것은 가상 머신
// 모든 것을 총괄하는 가상 머신 위에 올라가는 것이 object (모든 정보 수용 가능)
public class GenVectorTest {
    public static void main(String[] args) {
        Vector<Object> v = new Vector<Object>();
        v.addElement(new Character('A'));
        v.addElement(new String("Hello"));
        v.addElement(new Integer(100));
        v.addElement(new Float(33.3f));

        System.out.println("size of Vector: " + v.size());
        // ElementAt 사용하면 특정한 값을 설정해줄 수 있음.
        // insert는
        v.insertElementAt(new Double(3.141592), 1);
        System.out.println("size of Vector: " + v.size());
        // 값을 바꿔치기 함.
        v.setElementAt("Hi", 3);
        // arry리스트와 차이점이 있음.
        // Vector 사이즈가 그대로 인걸 보면 값을 바꿔준 것.
        // 원래 3번째 인덱스는 Integer(100)였지만 이 값이 사라지고
        // Hi 값이 들어간 것
        System.out.println("size of Vector: " + v.size());

        System.out.println("0번째: " + (Character)v.elementAt(0));
        System.out.println("1번째: " + (Double)v.elementAt(1));
        System.out.println("2번째: " + (String)v.elementAt(2));
        System.out.println("3번째: " + (String) v.elementAt(3));
        System.out.println("4번째: " + (Float)v.elementAt(4));

        // 기존에 array 리스트를 썼을 때는 add할 때 기존의 정보가 뒤로 밀려났음.
        // 그런데 Vector같은 경우는 insert하면 그 자리에 원하는 값이 들어가고 원래 값은 뒤로 밀리지만,
        // setElementAt을 해주면 원래 있던 값에 새로운 값을 대체시켜서 들어가기 때문에 Vector 사이즈는 늘어나지 않고 그대로 임!
    }
}

