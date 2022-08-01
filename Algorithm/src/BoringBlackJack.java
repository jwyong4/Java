import java.util.*;

public class BoringBlackJack {
    public static int boringBlackJack(int[] cards) {
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(isPrime(sum)) count++;
                }
            }
        }
        return count;
    }
    public static boolean isPrime(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int output = boringBlackJack(new int[]{1, 2, 3, 4});
        System.out.println(output);
        int output2 = boringBlackJack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output2);
    }
}