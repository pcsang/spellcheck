import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solutions {

    protected Map<Integer, Integer> mapCount = new HashMap<>();

    public int[] computerArr(String[] c, int n) {
        int[] arrComputered = new int[n];

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(c[i]);
            arrComputered[i] = key;
            if (mapCount.containsKey(key)) {
                int nc = mapCount.get(key);
                mapCount.put(key, nc + 1);
            } else {
                mapCount.put(key, 1);
            }
        }
        Arrays.sort(arrComputered);

        return arrComputered;
    }

    public int countMax(int[] arrs, int n, boolean flag) {
        int countM = 0;
        int countm = 0;
        float min = arrs[0] * 2;
        int m = n - 1;
        float max = (float) arrs[m] / 2;
        if (arrs[m] <= min) {
            return 0;
        }
        int kM = 0;
        int km = 0;

        for (Integer key : mapCount.keySet()) {
            if (mapCount.containsKey(key)) {
                if (key > min) {
                    int value = mapCount.get(key);
                    countM += value;
                    kM = key;
                }

                if (key < max) {
                    int value = mapCount.get(key);
                    countm += value;
                    km = key;
                }
            }
        }
        int t = countM;
        int kk = kM;
        if (countM > countm) {
           t = countm;
           kk = km;
        }
        if(flag) {
            mapCount.remove(kk);
        }


        return t;
    }

    public int  find(int[] arr, int n) {
        int a = countMax(arr, n, true);
        if(a ==0) {
            return a;
        }
        return a + find(arr, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFirst = scanner.nextLine();
        int n = Integer.parseInt(inputFirst);

        String inputSecond = scanner.nextLine();
        String[] second = inputSecond.split(" ");
        Solutions challenge = new Solutions();
        int[] arrs = challenge.computerArr(second, n);
        int count2 = challenge.countMax(arrs, n, false);
        int count = challenge.find(arrs, n);
        int a = Math.min(count, count2);
        System.out.println(a);
    }
}
