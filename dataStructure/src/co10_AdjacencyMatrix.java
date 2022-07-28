import java.util.Arrays;

public class co10_AdjacencyMatrix {
    public static int[][] createMatrix(int[][] edges) {

        int size = 0;
        // 행렬을 순회하여 최대값을 size에 넣어줌
        for (int i = 0; i < edges.length; i++) { // 열을 순회
            for (int j = 0; j < edges[i].length; j++) { // 행을 순회
                if (size < edges[i][j]) {
                    size = edges[i][j]; // size에 간선목록의 최대값을 넣어줌
                }
            }
        }
        // 행렬을 생성한 후 size(간선목록의 최대값)을 넣고 1을 더해줌 (배열의 인덱스는 0부터 시작하기 때문)
        int[][] graph = new int[size + 1][size + 1];
        // 간선목록을 순회하며,
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0]; // 시작점 from
            int to = edges[i][1]; // 도착점 to
            // 방향성 == 1, 일시 무향이면,
            if (edges[i][2] == 1) {
                graph[from][to] = 1; // 간선 추가
                graph[to][from] = 1; // 반대 방향으로도 간선 추가
            }
            // else 일시 방향이면,
            else {
                graph[from][to] = 1; // 간선 추가
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });
        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output1));
        System.out.println(Arrays.deepToString(output2));
    }
}

/**
    인접 행렬 생성하기
        문제
        방향이 있는 간선과 방향이 없는 간선들의 목록들을 받아 2차원 배열의 인접행렬을 반환하는 함수를 작성하세요.

        조건
        각 간선은 3가지 정보를 담고 있습니다.
        0번째: 간선의 시작 정점 (0 이상의 정수)
        1번째: 간선의 도착 정점 (0 이상의 정수)
        2번째: 방향성 (1 == 일시 무향, 0 == 일시 방향)

        입력
        인자 1: edges
        int 타입의 방향/무향인 간선들의 목록이 담긴 배열

        출력
        Array 타입을 리턴해야 합니다.
        2차원 배열의 인접 행렬

        주의 사항
        정점 0에서 정점 4로 이어주는 간선이 존재할 경우 정점 1, 2, 3도 존재합니다.
        반환하는 인접행렬은 2차원 배열이며, 행(row)는 바깥 배열, 열(column)은 안쪽 배열입니다.
        int[][] matrix = new int[][]{{0, 0}, {0, 0}}
        matrix[0] == 0번째 행
        matrix[0][0] == 0번째 행의 0번째 열
        두 정점간의 간선의 유무는 0과 1로 표시합니다.
        0: 두 정점간에 간선이 존재하지 않을 경우
        1: 두 정점간에 간선이 존재할 경우
        아래의 2차원 배열에서 세로축은 시작 정점, 가로축은 도착 정점입니다.
        음수는 올 수 없습니다.
        self loop 없습니다.
 **/