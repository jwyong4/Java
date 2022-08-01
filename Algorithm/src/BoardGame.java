/**
문제
N * N의 크기를 가진 보드판 위에서 게임을 하려고 합니다. 게임의 룰은 다음과 같습니다.

좌표 왼쪽 상단(0, 0)에 말을 놓는다.
말은 상, 하, 좌, 우로 이동할 수 있고, 플레이어가 조작할 수 있다.
조작의 기회는 딱 한 번 주어진다.
조작할 때 U, D, L, R은 각각 상, 하, 좌, 우를 의미하며 한 줄에 띄어쓰기 없이 써야 한다.
예시: UDDLLRRDRR, RRRRR
한 번 움직일 때마다 한 칸씩 움직이게 되며, 그 칸 안의 요소인 숫자를 획득할 수 있다.
방문한 곳을 또 방문해도 숫자를 획득할 수 있다.
보드 밖을 나간 말은 OUT 처리가 된다.
칸 안의 숫자는 0 또는 1이다.
단, 좌표 왼쪽 상단(0, 0)은 항상 0이다.
획득한 숫자를 합산하여 숫자가 제일 큰 사람이 이기게 된다.
보드판이 담긴 board와 조작하려고 하는 문자열 operation이 주어질 때, 말이 해당 칸을 지나가면서 획득한 숫자의 합을 구하는 함수를 작성하세요.

입력
인자 1: board
int 타입의 2차원 배열
2 <= board.length <= 1,000
예: [ [0, 0, 1], [1, 0, 1], [1, 1, 1] ]
인자 2: operation
string 타입의 대문자 영어가 쓰여진 문자열

1 <= operation.length <= board.length * 2

U, L, D, R 이외의 문자열은 없습니다.
출력
int 타입을 반환해야 합니다.
board와 operation이 입력값의 예시 ([ [0, 0, 1], [1, 0, 1], [1, 1, 1] ], DDR)일 때, (0, 0) -> (1, 0) -> (2, 0) -> (2, 1) 순서로 이동하게 되고, 각 0, 1, 1, 1을 얻어 3을 반환합니다.
주의사항
만약, 말이 보드 밖으로 나갔다면 즉시 null 을 반환합니다.
**/
import java.util.*;
public class BoardGame {
    public Integer boardGame(int[][] board, String operation) {
        // oper에 따라 이동할 좌표를 해쉬맵을 생성하여 만들어줌
        HashMap<String, int[]> DIR = new HashMap<String, int[]>(){{
           put("U", new int[]{-1, 0});
           put("D", new int[]{1, 0});
           put("L", new int[]{0, -1});
           put("R", new int[]{0, 1});
        }};
        int LEN = board.length; // 보드의 길이 선언
        int Y = 0; // 시작 좌표 선언
        int X = 0;
        int score = 0; // 점수 선언

        char[] chars = operation.toCharArray(); // 입력받은 oper를 char 배열로 변환

        for (int i = 0; i < chars.length; i++) { // charArray 타입 oper를 순회
            int dY = DIR.get(String.valueOf(chars[i]))[0]; //
            int dX = DIR.get(String.valueOf(chars[i]))[1];
            Y += dY;
            X += dX;
            if (!isValid(Y, X, LEN)) return null;
            score += board[Y][X];
        }
        return score;
    }
    public boolean isValid(int y, int x, int LEN) {
        return 0 <= y && y < LEN && 0 <= x && x < LEN;
    }
}
