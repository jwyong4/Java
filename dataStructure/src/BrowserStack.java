import java.util.*;

public class BrowserStack {
    public ArrayList<Stack> browserStack(String[] actions, String start) {

        Stack<String> prevStack = new Stack<>(); // 이전 스택
        Stack<String> nextStack = new Stack<>(); // 다음 스택
        Stack<String> current = new Stack<>(); // 현재 스택
        ArrayList<Stack> result = new ArrayList<>(); // 리스트
        // actions : 브라우저에서 행동한 순서를 나열한 배열
        // start : 시작 페이지를 나타내는 현재 접속해 있는 대문자 알파벳

        current.add(start);

        for (int i = 0; i < actions.length; i++) {
            // 2. 뒤로가기를 누를 경우
            if (actions[i].equals("-1") && !prevStack.empty()) {
                // 원래 있던 페이지를 next에 넣는다.
                nextStack.push(current.pop());
                // prev에 있는 top 페이지로 이동한다.
                current.push(prevStack.pop());
                // prev 값을 pop(가장 나중에 추가된 데이터를 삭제 후 리턴)한다.
            }
            // 3. 앞으로가기를 누를 경우
            else if (actions[i].equals("1") && !nextStack.empty()) {
                // 원래 있던 페이지를 prev에 넣는다.
                prevStack.push(current.pop());
                // next에 있는 top 페이지로 이동한다.
                current.push(nextStack.pop());
                // prev 값을 pop한다.
            }
            // 4. 브라우저에서 뒤로가기, 앞으로가기 버튼이 비활성화일 경우
            else if (actions[i].equals("1") || actions[i].equals("-1")) {
                // 스택에 push하지 않는다.
            }
            // 1. 새로운 페이지로 접속할 경우
            else {
                // prev에 원래 있던 페이지를 넣는다.
                prevStack.push(current.pop());
                // Current
                current.push(actions[i]);
                // next를 비운다.
                nextStack.clear();
            }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}