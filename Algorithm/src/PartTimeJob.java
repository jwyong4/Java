/**
문제
편의점에서 아르바이트를 하고 있는 중에, 하필이면 피크 시간대에 손님에게 거스름돈으로 줄 동전이 부족하다는 것을 알게 되었습니다.
현재 가지고 있는 동전은 1원, 5원, 10원, 50원, 100원, 500원으로 오름차순으로 정렬되어 있고, 각 동전들은 서로 배수 관계에 있습니다.
동전 개수를 최소화하여 거스름돈 K를 만들어야 합니다. 이때, 필요한 동전 개수의 최솟값을 구하는 함수를 작성해 주세요.

입력
인자: k
int 타입의 k
1 <= k <= 100,000,000

출력
int 타입의 거스름돈 K원을 만드는데 필요한 동전 개수의 최솟값을 반환해야 합니다.
**/
import java.util.*;
public class PartTimeJob {
    public static int partTimeJob(int k){
        int[] coin = new int[]{500, 100, 50, 10, 5, 1};
        int coinCount = 0;
        // coin 배열을 순회
        for (int i = 0; i < coin.length; i++) {
            // 거슬러 줘야 하는 돈이 남은 경우,
            if (k > 0) {
                // 총액 / coin[i]의 값을 소숫점 반내림하여 sum에 넣어준다.
                int sum = (int)Math.floor((double)k / coin[i]); // ex) 4750 / 500 = 8, 나머지 750

                coinCount += sum; // 사용한 동전 갯수를 카운트에 넣어줌
                // 남은 거스름돈을 다시 계산하는 코드
                k = k - (coin[i] * sum); // ex) 총액
            }
        }
        return coinCount;
    }

    public static void main(String[] args) {
        int output1 = partTimeJob(4000);
        System.out.println(output1);

        int output2 = partTimeJob(4972);
        System.out.println(output2);
    }
}
