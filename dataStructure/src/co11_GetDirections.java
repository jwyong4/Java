import java.util.*;

public class co11_GetDirections {
    public static boolean getDirections(int[][] matrix, int from, int to) {
        // BFS 구현
        // 1. 탐색할 2차원 배열 또는 그래프
        // 2. 방문처리를 하기 위한 boolean type
        // 3. Queue 자료 구조

        Queue<Integer> queue = new LinkedList<>(); // 너비 탐색을 위한 queue
        boolean[] visited = new boolean[matrix.length]; // 방문 처리를 위한 boolean type 배열

        queue.add(from); // 첫 방문 노드를 queue에 넣어준다.
        visited[from] = true; // 첫 방문 노드를 방문 처리해준다.

        // queue가 비어있지 않다면 반복
        while (!queue.isEmpty()) {
            int now = queue.poll(); // queue에 들어있는 첫번째 노드를 x에 넣어줌

            // 목적지라면 true
            if (now == to) return true;

            // queue의 현재 노드와 연결되어있는 모든 노드들을 순차적으로 확인
            for (int next = 0; next < matrix[now].length; next++) {

                // 방문 처리가 false 이고 간선이 있다면,
                if (!visited[next] && matrix[now][next] == 1) {
                    queue.add(next); // queue에 노드를 넣어주고,
                    visited[next] = true; // 방문 처리한다.
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                    0,
                      2
        );
        System.out.println(result);
    }
}

/**
        문제
        주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환해야 합니다.

        입력
        인자 1: matrix
        Array 타입을 요소로 갖는 인접 행렬이 담긴 2차원 배열
        인자 2: from
        int 타입의 시작 정점
        인자 3: to
        int 타입의 도착 정점

        출력
        boolean 타입을 리턴해야 합니다.
 **/