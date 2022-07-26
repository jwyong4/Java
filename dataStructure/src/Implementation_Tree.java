import java.util.*;

public class Implementation_Tree {
    // 입력 데이터를 담을 수 있는 String 타입의 value
    private String value;
    // 하위 노드를 저장할 수 있는 ArrayList 타입의 children
    private ArrayList<Implementation_Tree> children;

    public Implementation_Tree() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public Implementation_Tree(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }
    // addChildNode(value): 입력받은 value를 Tree에 계층적으로 추가할 수 있어야 합니다.
    public void addChildNode(Implementation_Tree node) {
        if(children == null) children = new ArrayList<>();
        children.add(node);
    }
    // removeChildNode(node): 입력받은 node를 Tree에서 삭제할 수 있어야 합니다.
    public void removeChildNode(Implementation_Tree node) {
        if(children != null) children.remove(node);
    }
    // getChildrenNode(): 현재 트리에서 존재하는 children을 리턴합니다.
    public ArrayList<Implementation_Tree> getChildrenNode() {
        return children;
    }
    // contains(value): 트리에 포함된 데이터를 찾을 수 있어야 합니다.
    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                return children.get(i).contains(data);
            }
        }
        return false;
    }
}
