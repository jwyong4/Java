/**
문제
김코딩과 박해커는 사무실 이사를 위해 짐을 미리 싸 둔 뒤, 짐을 넣을 박스를 사왔다.
박스를 사오고 보니 각 이사짐의 무게는 들쭉날쭉한 반면,
박스는 너무 작아서 한번에 최대 2개의 짐 밖에 넣을 수 없었고 무게 제한도 있었다.

예를 들어, 짐의 무게가 [70kg, 50kg, 80kg, 50kg]이고 박스의 무게 제한이 100kg이라면
2번째 짐과 4번째 짐은 같이 넣을 수 있지만 1번째 짐과 3번째 짐의 무게의 합은 150kg이므로 박스의 무게 제한을 초과하여 같이 넣을 수 없다.

박스를 최대한 적게 사용하여 모든 짐을 옮기려고 합니다.

짐의 무게를 담은 배열 stuff와 박스의 무게 제한 limit가 매개변수로 주어질 때,
 모든 짐을 옮기기 위해 필요한 박스 개수의 최소값을 return 하도록 movingStuff 함수를 작성하세요.

입력
인자 1: stuff
int 타입의 40 이상 240 이하의 자연수를 담은 배열
ex) [70, 50, 80, 50]
인자 2: limited
int 타입의 40 이상 240 이하의 자연수

출력
int 타입을 리턴해야 합니다.
모든 짐을 옮기기 위해 필요한 박스 개수의 최솟값을 숫자로 반환합니다.
**/

import java.util.*;

public class MovingStuff {
    public static int movingStuff(int[] stuff, int limit) {

        Arrays.sort(stuff); // stuff를 오름차순으로 정렬
        int leftIdx = 0; // 가장 가벼운 짐
        int rightIdx = stuff.length - 1; // 가장 무거운 짐

        int twoStuff = 0; // 두개의 짐을 넣은 박스 갯수

        // 가장 가벼운 짐이 가장 무거운 짐보다 작을때 반복 (left와 right가 만나지 않았을 때)
        while(leftIdx < rightIdx) {
            // 가벼운 짐과 무거운짐을 더한 무게가 limit보다 작을때,
            if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
                leftIdx++; // 왼쪽인덱스를 +1
                rightIdx--; // 오른쪽인덱스를 -1
                twoStuff++; // 두개의 짐을 넣은 박스 +1
            }
            else { // 가벼운 짐과 무거운짐을 더한 무게가 limit보다 클때,
                rightIdx--; // 오른쪽인덱스 -1
            }
        }
        return stuff.length - twoStuff; // 전체 짐의 갯수 - 두개의 짐을 넣은 박스 = 필요한 박스
    }

    public static void main(String[] args) {
        int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output);

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2);
    }
}