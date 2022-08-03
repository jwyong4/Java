/**
 * 문제
 * 개업 이래로 항상 승승장구하는 '승승장구 치킨집'의 비결은 소스에 있다. 수많은 타사 브랜드 치킨집들이 승승장구 치킨집의 소스 비결을 알아내려고 했으나 빈번히 포기했다.
 * 그 이유는 5대째 내려오는 '비밀의 승승장구 치킨 소스 비율 레시피'는 70억 인구 중 사장님만 알고 있기 때문이다. 최근, 누리꾼 사이에서 이 레시피의 일부분을 발췌했다는 소문을 듣게 되었다.
 * 그 소문은 다음과 같다.
 *
 * N 가지의 재료 중에 단 M 가지만을 사용하여 조합한 모든 경우의 수 중 하나이다.
 * 재료는 0과 1로만 이루어진 숫자로 암호화가 되어 있고, 항상 1로 시작하며 복호화를 할 수 없다.
 * 단, 0이 3개 이상인 재료는 상한 재료이기 때문에 제외한다.
 * 재료의 순서에 따라 맛이 달라지기 때문에, 재료를 넣는 순서가 다르다면 다른 레시피이다.
 * 이 소문을 참고하여 '비밀의 승승장구 치킨 소스'가 될 수 있는 경우의 수를 모두 반환하는 함수를 작성하세요.
 *
 * 입력
 * 인자 1: stuffArr
 * int 타입의 재료를 담은 배열
 * 요소는 0과 1로만 이루어진 숫자이며, 항상 1로 시작합니다.
 * 요소는 중복될 수 없습니다.
 * 요소의 길이는 20 이하입니다.
 * 배열의 길이는 2 이상 10 이하입니다.
 * ex) [111, 110, 1010, 10, 10110]
 * 인자 2: choiceNum
 * int 타입의 1 이상 stuffArr 길이 이하의 자연수
 * 재료를 선택할 수 있는 수를 뜻합니다.
 * ex) 2
 *
 * 출력
 * ArrayList<Integer[]> 타입을 반환해야 합니다.
 * stuffArr가 [1, 10, 11000, 1111] 이고, choiceNum은 2라면 사용 가능한 재료는 [1, 10, 1111] 입니다. 조합할 수 있는 경우의 수는 6 가지입니다.
 *
 * 주의사항
 * 만약, 주어진 재료 모두 사용할 수 없다면 null을 반환해야 합니다.
 * 만약, 사용할 수 있는 재료가 choiceNum보다 작다면 null을 반환해야 합니다.
 * 조합 및 요소는 작은 숫자 -> 큰 숫자로 정렬합니다.
 * 예시로 [1, 10, 11000, 1111]이 요소로 들어왔다면, 0이 세 개인 11000을 제외하고 [1, 10, 1111] 순서가 되어야 하며,
 * [ [1, 10], [1, 1111], [10, 1], [10, 1111], [1111, 1], [1111, 10] ]을 반환해야 합니다.
 */

import java.util.*;

public class NewChickenRecipe {
    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {

        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<Integer> stuffList = new ArrayList<>();
        for(int i = 0 ; i < stuffArr.length; i++ ) {
            int mod = 0;
            int cnt = 0;
            int curStuff = stuffArr[i];
            while (curStuff > 0) {
                mod = curStuff % 10;
                if (mod == 0)
                    cnt++;
                curStuff /= 10;
            }
            if (cnt < 3)
                stuffList.add(stuffArr[i]);
        }
        if(stuffList.size() == 0 || stuffList.size() < choiceNum) return null;

        Collections.sort(stuffList);
        permutation(choiceNum, stuffList, new ArrayList<Integer>(), result);

        return result;
    }

    public static void permutation(int choiceNum, ArrayList<Integer> stuffList, ArrayList<Integer> beforeRecipe, ArrayList<Integer[]> result){
        if(choiceNum == 0){
            result.add(beforeRecipe.toArray(new Integer[0]));
            return;
        }

        for(int i = 0; i < stuffList.size(); i++){
            Integer cur = stuffList.get(i);
            ArrayList<Integer> recipe = new ArrayList<>(beforeRecipe);
            if(!recipe.contains(cur)) {
                recipe.add(cur);
                permutation(choiceNum - 1, stuffList, recipe, result);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        System.out.println(output1);
    }
}