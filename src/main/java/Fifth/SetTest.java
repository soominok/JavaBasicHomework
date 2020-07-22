package Fifth;

// 해쉬 셋은 속도는 엄청 빠르지만, 정렬은 못하기 때문에
// 순서가 중요한 것에서는 사용하지 못하는 단점이 있음.

// 해쉬 셋과 Vector, array리스트 모두 비슷함.

// 원소 추가할 때는 해쉬 셋과 array 리스트는 add
// Vector는 insert, set으로 추가할 수 있음.
import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        String[] arr = {"milk", "bread", "cheese", "butter", "ham", "egg", "meat", "beef"};
        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // 집어넣은 순서대로 들어가지 않을 뿐더러, 정렬도 안되어 있음.
        System.out.println(set);
    }
}
