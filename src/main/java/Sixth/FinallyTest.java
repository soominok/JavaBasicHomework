package Sixth;

public class FinallyTest {
    public static void main(String[] args) {

        int[] arr = new int[10];

        try {
            // 범위는 0~9까지 인데, 11번째 index를 지정해줬으니까
            // 말도 안되는 것!!
            // 그래서 범위 벗어났다는 것을 감지하고 출력해주는 것.
            arr[11] = 100;
            // 배열의 할당된 크기 이상의 작업을 수행하려고 할 때 발생한다.
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("범위 벗어났어.");
        } finally {
            arr = null;
        }

        System.out.println("나온다");
    }
}
