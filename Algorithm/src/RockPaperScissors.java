/**
 * 문제
 * 가위바위보 게임은 2인 이상의 사람이 동시에 '가위, 바위, 보'를 외치고 동시에 가위, 바위 또는 보 중에서 한 가지를 의미하는 손 모양을 내밀어 승부를 결정짓는 게임입니다. 세 판의 가위바위보 게임을 할 경우, 한 사람은 세 번의 선택(예. 가위, 가위, 보)을 할 수 있습니다. 입력받은 rounds만큼의 선택으로 가능한 모든 경우의 수를 구하는 함수를 작성합니다.
 *
 * 입력
 * int타입의 게임 횟수 rounds
 *
 * 출력
 * ArrayList<String[]>타입을 리턴해야 합니다.
 * ArrayList가 담고있는 배열은 전체 경우의 수 중 한 가지 경우(총 세 번의 선택)를 의미하는 배열입니다.
 * String[]은 'rock', 'paper', 'scissors' 중 한 가지 이상을 요소로 갖는 배열입니다.
 *
 * 주의사항
 * 최종적으로 리턴되는 배열의 순서는 가중치 적용 정렬(Weighted Sort)을 따릅니다.
 * 중요도는 'rock', 'paper', 'scissors' 순으로 높습니다.
 * 쉽게 생각해 올림픽 순위 결정 방식을 참고하면 됩니다.
 * 금메달('rock')이 은메달('paper')보다 우선하고, 은메달('paper')이 동메달('scissors')보다 우선합니다.
 */

import java.util.*;

public class RockPaperScissors {
//    public static ArrayList<String[]> rockPaperScissors(int rounds) {
//
//        ArrayList<String[]> result = new ArrayList<>();
//        String[] rockPaperScissors = {"rock", "paper", "scissors"};
//        permutation(rounds, rockPaperScissors, new ArrayList<String>(), result);
//
//        return result;
//    }
//
//    public static void permutation(int rounds, String[] rockPaperScissors, ArrayList<String> element, ArrayList<String[]> result){
//        if(rounds == 0) {
//            result.add(element.toArray(new String[element.size()]));
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            String cur = rockPaperScissors[i];
//            ArrayList<String> list = new ArrayList<>(element);
//            list.add(cur);
//            permutation(rounds-1, rockPaperScissors, list, result);
//        }
//    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        //결과를 담을 ArrayList를 선언합니다.
        ArrayList<String[]> outcomes = new ArrayList<>();
        // 함수를 실행하여 반환된 결과를 다시 반환합니다.
        return permutation(rounds, new String[]{}, outcomes);
    }

    // 재귀를 사용할 함수 선언
    // rounds를 넣을 변수 roundsToGo, 일회용 배열인 playedSoFar 변수를 선언합니다.

    // 재귀를 사용하는 이유는, 배열의 모든 요소의 경우의 수를 훑기 위한 적절한 방법이기 때문입니다.
    // 간단히 말하자면, 이 함수는 rounds 숫자를 기준으로, 일회용 배열에 rps 요소를 rounds 숫자만큼 넣게 됩니다.
    // 이 로직을 잘 이해할 수 있을 때까지 하단의 함수 로직을 연구해야 합니다.
    public static ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes) {
        // rounds가 0일 경우 outcones 배열에 삽입하고, 재귀에서 빠져나옵니다.
        if(roundsToGo == 0) {
            outcomes.add(playedSoFar);
            return outcomes;
        }

        String[] rps = new String[]{"rock", "paper", "scissors"}; // 가위바위보를 담은 배열 선언

        // rps 배열을 한 번씩 순회합니다.
        for(int i = 0; i < rps.length; i++) {
            // rps의 i번째 요소를 변수에 담아서
            String currentPlay = rps[i];

            // permutate(본인)에 기존 rounds에서 하나 뺀 숫자와, 일회용 배열 playedSoFar에 currentPlay를 삽입하여 재귀를 실행합니다.
            // rounds에서 하나를 빼는 이유는, 일회용 배열의 크기를 rounds만큼 맞춰주기 위함입니다. [rock, rock, rock]
            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);  //배열의 크기를 하나 늘리고, currentPlay를 요소로 넣어줍니다.
            concatArray[concatArray.length - 1] = currentPlay;

            outcomes = permutation(roundsToGo - 1, concatArray, outcomes);
        }

        // outcomes를 반환합니다.
        return outcomes;
    }

    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(5);
        System.out.println(output);
    }
}