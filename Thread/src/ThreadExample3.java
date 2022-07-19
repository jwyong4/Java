public class ThreadExample3 {
    public static void main(String[] args) {
        Runnable threadTask3 = new ThreadTask3();
        Thread thread3_1 = new Thread(threadTask3);
        Thread thread3_2 = new Thread(threadTask3);

        thread3_1.setName("김코딩");
        thread3_2.setName("이자바");

        thread3_1.start();
        thread3_2.start();
    }
}

class Account {
    // 잔액을 표현하는 변수
    private int balance = 10000;
    // 외부에서 참조할 수 있도록 get
    public int getBalance() {
        return balance;
    }
    // 인출 성공 시 true, 실패 시 false
    public boolean withdraw(int money){
        //** 예외가 발생했을 때 다른 스레드 실행
        //** 학습을 위해서 일부러 오작동 실행
        try {Thread.sleep(1000);} catch (Exception error) {}
        // 잔액이 금액 이상이면 잔액에서 금액을 깎음
        if (balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    }
}

// Runnable 인터페이스 구현
class ThreadTask3 implements Runnable {
    // Account 인자를 받는 인스턴스 생성
    Account account = new Account();

    @Override
    public void run() {
        // account 객체에 Balance 속성 부여. 잔액이 0원 이상일 때,
        while (account.getBalance() > 0) {
            // 0~0.9999...의 랜덤수 발생
            int money = (int) (Math.random() * 3 + 1) * 1000;
            // 머니만큼
            boolean denied = !account.withdraw(money);

            System.out.println(String.format("%s님께서 %d원을 인출 시도 / 잔액 : %d %s",
                    Thread.currentThread().getName(), money, account.getBalance(), denied ? "-> DENIED" : "" // 3항 조건 연산자
                    ));
        }
    }
}