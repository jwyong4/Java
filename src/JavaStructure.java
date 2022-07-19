
class InstanceA { // Class 생성. static으로 선언 시 공유 가능
    public int a = 1; // 필드.인스턴스.변수 선언
    public static int b = 2; // 필드.클래스.변수 선언

    void A() {  // 인스턴스 메소드 선언
        System.out.println(a+b);
    }
    static void B() {  // 클래스 메소드 선언
        System.out.println(b+b);
    }
}

public class JavaStructure { // 클래스 선언
    //"main 메소드를 실행하는 데 필요한 값들이 있다면 args이라는 문자열을 배열을 통해서 main 메소드에 전달하겠다"라는 의미
    public static void main(String[] args) {// 제일 먼저 실행되고 기본인 main 메소드
//        InstanceA instanceA = new InstanceA(); // 인스턴스 변수 생성

//        System.out.println(InstanceA.a); // 클래스 외부의 인스턴스 변수 호출 불가
        System.out.println(InstanceA.b); // 클래스 외부의 클래스 변수 호출, 클래스 내부에 인스턴스 변수가 없어도 됨

//        InstanceA.A(); // 클래스 외부의 인스턴스 메소드 호출 불가
        InstanceA.B(); // 클래스 외부의 클래스 메소드 호출, 클래스 내부에 인스턴스 변수가 없어도 됨

    }
}