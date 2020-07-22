package Sixth;

public class DBZExptionTest {
    public static void main(String[] args) {
        int x = 1;
        int y = 0;

        try {
            // 오류가 발생하는 원인은 아래 코드 때문이다!
            // 이 오류를 해결하기 위해서 try {} catch()가 들어감.
            // try를 사용하는 녀석들은 잠재적 오류를 내포한 녀석들
            // (DB도 잠재적 오류 내포! - 사용자가 갑자기 꺼버리는 경우는 비정상 종료이기 때문에 DB 세션이 정리되지 않았기 때문에 Exception 발생 가능)
            // 이 녀석이 오류를 유발할 수도 있겠는데? (잘 동작 할 수도 있는데, 오동작할 수도 있는 경우)
            // 하는 경우 try에 넣으면 된다.
            int result = x / y;

            // 실제 divide by zero 오류는 CPU에서 감지하는 HW 오류다.
            // 운영체제의 동작 메커니즘 상 이것은 원래 kernel이라는 OS가 처리한다.
            // 하지만 catch 구문을 사용해서 내가 대신 처리할게라고
            // OS에게 요청을 하여 실질적으로 해당 오류가 발생하면
            // 운영체제가 처리 작업을 catch 쪽으로 위임하게 된다.
        } catch(ArithmeticException e) {
            System.out.println("0으로 나누지 좀 마!");
        }
        // 어떤 숫자든 0으로 나눌 수 없음. -> 그래서 CPU(하드웨어)에서 오류를 내는 것.
        // Exception 발생하면 보통 프로그램을 멈춰버리는데,
        // cathch(ArithmeticException e) {}를 통해 이 부분에서 받아와서 처리해주는 것.

        System.out.println("왓 더");
    }
}
