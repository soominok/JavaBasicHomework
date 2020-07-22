package Sixth;

// 산술 연산에 대한 예외를 처리할 위임 클래스
class DBZException extends ArithmeticException {
    public DBZException() {
        super("0으로 나누면 안돼!");
    }

}

public class ThrowExceptionTest {
    // 매서드 자체에서 직접 핸들링하기 어려우니까
    // DBZException이 처리할 것이라고 지정해준 것.
    public static double quo(int n, int d)
            // 사전에 위의 위임 클래스가 예외를 처리할 것임을 알려
            throws DBZException {
        if (d == 0) {
            // throw = return new DBZException();을 한 것과 같음!
            // throw를 사용하는 것은 예외처리를 수행할 수 있는
            // Exception 계열들을 배치하는 것이 좋다.줌
            // 여기서 DBZException()이 만들어지는 것.
            throw new DBZException();
        }

        System.out.println("How ?");
        return (double) n / d;
    }
    public static void main(String[] args) {
        double result;

        try {
            result = quo(1, 0);
        // 실제로 DBZExcepiton 객체가 생
        } catch (DBZException e) {
            System.out.println(e.toString());
        }

        System.out.println("Finish it!");
    }
}
