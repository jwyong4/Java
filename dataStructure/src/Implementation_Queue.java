import java.util.ArrayList;

public class Implementation_Queue {
    private ArrayList<Integer> listQueue = new ArrayList<Integer>();

    public void add(Integer data) {
        listQueue.add(data);
    }
    // 첫번째로 추가된 데이터를 삭제 후 리턴
    public Integer poll() {
        if(listQueue.size() == 0) {
            return null;
        }else {
            return listQueue.remove(0);
        }
    }
    // 큐에 추가된 데이터의 크기를 리턴
    public int size() {
        return listQueue.size();
    }
    // 첫번째로 추가된 데이터를 리턴
    public Integer peek() {
        if(listQueue.size() == 0) {
            return null;
        }else {
            return listQueue.get(0);
        }
    }
    // 큐에 들어있는 모든 데이터를 String타입으로 변환 후 리턴
    public String show() {
        return listQueue.toString();
    }
    // 큐에 들어있는 모든 데이터 삭제
    public void clear() {
        listQueue.clear();
    }
}

//        add(): 큐에 데이터를 추가할 수 있어야 합니다.
//        poll(): 가장 먼저 추가된 데이터를 큐에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
//        size(): 큐에 추가된 데이터의 크기를 리턴해야 합니다.
//        peek(): 큐에 가장 먼저 추가된 데이터를 리턴해야 합니다.
//        show(): 큐에 들어있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
//        clear(): 큐에 들어있는 모든 데이터를 삭제합니다.