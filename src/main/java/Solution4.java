import java.util.*;
import java.util.stream.Collectors;

public class Solution4 {
    private static List<Integer> convertArrToArrInt(String[] arr) {
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void find2(String[] arr, int n) {
        List<Integer> integerList = new ArrayList<>();
        int indexLeft = 0;
        int indexRight = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> numberConverted = convertArrToArrInt(arr);
        map.put(numberConverted.get(0), 1);
        int count = 1;
        for (int i = 1; i < n; i++) {
            int item = numberConverted.get(i);
            if (map.containsKey(item)) {
                indexRight++;
                if (i == n - 1) {
                    int a = indexRight - indexLeft - count + 1;
                    if (a > 0) {
                        integerList.add(a);
                    }
                }

            } else {
                map.put(item, 1);
                count++;
                if (i+1 < n) {
                    int itemNext = numberConverted.get(i + 1);
                    if (item != itemNext) {
                        if(map.containsKey(itemNext)) {
                            indexRight++;
                        } else {
                            int a = indexRight - indexLeft - count;
                            if (a > 0) {
                                integerList.add(a);
                            }
                            indexLeft = i;
                            indexRight = i;
                            count = 1;
                        }
                    } else {
                        indexRight++;
                    }
                }
                if (i == n-1 && count > 1) {
                    indexRight++;
                }
            }
        }

        if (integerList.isEmpty()) {
            System.out.println(0);
        } else {
            int min = integerList.stream().min(Integer::compare).get();
            System.out.println(min);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String inputFirst = scanner.nextLine();
        int n = Integer.parseInt(inputFirst);
        String inputSecond = scanner.nextLine();
        String[] arr = inputSecond.split(" ");
        Solution4 challenge = new Solution4();
        challenge.find2(arr, n);
    }
}