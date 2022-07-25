import java.util.ArrayList;

public class Implementation_Stack {
    private ArrayList<Integer> listStack = new ArrayList<Integer>();

    public void push(Integer data) {
        listStack.add(data); // 배열의 add로 구현
    }
    // 스택에서 데이터 꺼내기
    public Integer pop() {
        if(listStack.size() == 0) {
            return null;
        }else {
            return listStack.remove(listStack.size() - 1);
        }
    }
    // 스택에 쌓인 데이터 크기 리턴
    public int size() {
        return listStack.size();
    }
    // 가장 나중에 추가된 데이터 리턴
    public Integer peek() {
        if(listStack.size() == 0) {
            return null;
        }else {
            return listStack.get(listStack.size() - 1);
        }
    }
    // 스택에 포함되어 있는 데이터를 문자열로 변환
    public String show() {
        return listStack.toString();
    }
    // 스택에 들어있는 모든 데이터 삭제
    public void clear() { listStack.clear(); }
}

//        push(): 스택에 데이터를 추가할 수 있어야 합니다.
//        pop(): 가장 나중에 추가된 데이터를 스택에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
//        size(): 스택에 추가된 데이터의 크기를 리턴해야 합니다.
//        peek(): 가장 나중에 추가된 데이터를 리턴해야 합니다.
//        show(): 현재 스택에 포함되어 있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
//        clear(): 현재 스택에 포함되어 있는 모든 데이터 삭제합니다.