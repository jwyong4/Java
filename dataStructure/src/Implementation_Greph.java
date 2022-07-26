public class Implementation_Greph {
    // 버텍스와 간선을 담을 Array 타입의 graph
    private int[][] graph;
    // setGraph(size): 그래프에 size만큼의 버텍스를 추가해야 합니다.
    public void setGraph(int size) {
        graph = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }
    // getGraph(): 인접 행렬 정보가 담긴 배열을 반환합니다.
    public int[][] getGraph() {
        return graph;
    }
    // addEdge(from, to): fromVertex와 toVertex 사이의 간선을 추가합니다.
    public void addEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
    }
    // hasEdge(from, to): fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 Boolean으로 반환해야 합니다.
    public boolean hasEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return false;
        else if(graph[from][to] == 1) return true;
        else return false;
    }
    // removeEdge(from, to): fromVertex와 toVertex 사이의 간선을 삭제해야 합니다.
    public void removeEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 0;
    }
}