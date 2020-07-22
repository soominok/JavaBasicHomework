package Sixth;

class Bank2 {
    // Critical Section(크리티컬 섹션) = money
    // money라는 정보가 A,B가 공유하고 있었음 - 동기화 문제 발
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    // synchronized를 추가하면 알아서 동기화된 처리해줌
    // 3000 * 1000 = 3000000
    public synchronized void saveMoney(int save) {
        for (int i = 0; i < 1000; i++) {
            int m = this.getMoney();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.money = m + save;
            System.out.println("현재금액(Save): " + this.money);
        }
    }

    // lock이 전체 구간에 걸려 있음.
    // 1000 * 1000 = -100 0000
    // synchronized를 for문 밖에다 써주니까 매서드 자체가 보호가 안됨. for 문 자체는 보호가 됐는데.
    public synchronized void useMoney(int minus) {
        for (int i = 0; i < 1000; i++) {
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

class C extends Thread {
    public void run() {
        NoSyncTest.myPrivateBank.saveMoney(3000);
        System.out.println("saveMoney(3000): " + NoSyncTest.myPrivateBank.getMoney());
    }
}

class D extends Thread {
    public void run() {
        NoSyncTest.myPrivateBank.useMoney(1000);
        System.out.println("useMoney(1000): " + NoSyncTest.myPrivateBank.getMoney());
    }
}

// 동기화가 없다
public class Synctest {
    public static Bank2 myPrivateBank = new Bank2();

    public static void main(String[] args) {
        System.out.println("원금: " + myPrivateBank.getMoney());

        C c = new C();
        D d = new D();

        c.start();
        d.start();

    }
}