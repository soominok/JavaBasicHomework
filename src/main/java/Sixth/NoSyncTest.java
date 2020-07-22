package Sixth;

class Bank {
    // Critical Section(크리티컬 섹션)
    // money라는 정보가 A,B가 공유하고 있었음 - 동기화 문제 발
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    // 3000 * 1000 = 3000000
    public void saveMoney(int save) {
        for (int i = 0; i < 100; i++) {
            int m = this.getMoney();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.money = m + save;
            System.out.println("현재금액(Save): " + this.money);
        }
    }

    // 1000 * 1000 = -100 0000
    public void useMoney(int minus) {
        for (int i = 0; i < 100; i++) {
            int m = this.getMoney();

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.money = m - minus;
            System.out.println("현재금액(use): " + this.money);
        }
    }

}

class A extends Thread {
    public void run() {
        NoSyncTest.myPrivateBank.saveMoney(3000);
        System.out.println("saveMoney(3000): " + NoSyncTest.myPrivateBank.getMoney());
    }
}

class B extends Thread {
    public void run() {
        NoSyncTest.myPrivateBank.useMoney(1000);
        System.out.println("useMoney(1000): " + NoSyncTest.myPrivateBank.getMoney());
    }
}

// 동기화가 없다
public class NoSyncTest {
    public static Bank myPrivateBank = new Bank();

    public static void main(String[] args) {
        System.out.println("원금: " + myPrivateBank.getMoney());

        A a = new A();
        B b = new B();

        a.start();
        b.start();

    }

}
