package Sixth;

class Bank3 {
    // Critical Section(크리티컬 섹션)
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    // 3000 * 1000 = 300 0000
    public void saveMoney(int save) {
        int m = this.getMoney();

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.money = m + save;
    }

    // 1000 * 1000 = -100 0000
    public void useMoney(int minus) {
        int m = this.getMoney();

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.money = m - minus;
    }
}



// for문 밖에 synchronized를 를 걸 경우 데이터의 보호가 불완전할 수 있다.
// 그러므로 실질적인 연산을 수행하는 경우에 대해서
// 건 바이 건으로 대응하도록 lock을 걸어 문제를 해결하도록 한다.
class X extends Thread {
    public void run() {
        // for문 안쪽에 synchronized를 넣어주니까 매서드 전체 보호됨.
        for(int i = 0; i < 1000; i++) {
            synchronized (RealSync.myPrivateBank) {
                RealSync.myPrivateBank.saveMoney(3000);
            }
            System.out.println("saveMoney(3000): " +
                    RealSync.myPrivateBank.getMoney());
        }
    }
}

class Y extends Thread {
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // 이 연산만 스레드 락 걸어놓은 것!
            // 쭉 -였다가 적당한 시점에서 +도 하고 있음
            // 로그인 요청이 들어왔을 때 로그인 스레드가 정상적으로 작동
            // synchronize를 적절하게 사용해줘야 적절하게 보호 가능.
            synchronized (RealSync.myPrivateBank) {
                RealSync.myPrivateBank.useMoney(3000);
            }
            System.out.println("saveMoney(3000): " +
                    RealSync.myPrivateBank.getMoney());
        }
    }
}

public class RealSync {
    public static Bank3 myPrivateBank = new Bank3();

    public static void main(String[] args) {
        System.out.println("원금: " +
                myPrivateBank.getMoney());

        X x = new X();
        Y y = new Y();

        x.start();
        y.start();
    }
}

