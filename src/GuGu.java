public class GuGu {
    public void dan(int n) { // 정수만 입력으로 받는 dan 메소드
        for (int i = 1; i < 10; i++) {// for (초기치; 조건문; 증가치)
            System.out.println(n * i);
        }
    }

    public static void main(String[] args) {
        GuGu gugu = new GuGu(); // int n; 처럼 GuGu gugu는 GuGu의 자료형으로 선언
        for (int i = 2; i < 10; i++ ) {
            gugu.dan(i); // gugu 객체를 통해 dan 메소드를 호출하면 전부 출력 가능
        }
    }
}