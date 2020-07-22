package Fifth.HW;

import java.util.ArrayList;
import java.util.Random;


public class ThirdProb_arr {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> freq = new ArrayList<Integer>();

        Random rand = new Random();
        int [] arr;
        final int MAX = 200;
        final int RANGE = 51;

        for (int i = 0; i < MAX; i++) {
            list.add(rand.nextInt(RANGE) + 10);
        }

        for(int i = 0; i < MAX; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        for(int i =0; i < RANGE; i++) {
            freq.add(i, 0);
        }

        for(int i = 0; i < MAX; i++) {
            int idx = list.get(i) - 10;

            int tmp = freq.get(idx);
            freq.add(idx, ++tmp);

            freq.remove(idx + 1);

        }

        for(int i = 0; i < RANGE; i++) {
            System.out.print(freq.get(i) + " ");
        }

        System.out.println();

        arr = new int[RANGE];

        for(int i =0; i < MAX; i++) {
            arr[list.get(i) - 10]++;
        }

        for(int i = 0; i < RANGE; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
