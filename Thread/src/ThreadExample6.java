public class ThreadExample6 {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();

        ThreadA threadA = new ThreadA(sharedObject);
        ThreadB threadB = new ThreadB(sharedObject);

        threadA.start();
        threadB.start();
    }
}

class WorkObject {
    public synchronized void methodA() { // 임계 영역 지정
        System.out.println("ThreadA의 methodA Working");
        notify();
        try {wait();} catch(Exception e) {}
    }
    public synchronized void methodB() { // 임계 영역 지정
        System.out.println("ThreadA의 methodB Working");
        notify();
        try {wait();} catch(Exception e) {}
    }

}

class ThreadA extends  Thread {
    private WorkObject workObject;

    public ThreadA(WorkObject workObject) {
        this.workObject = workObject;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodA();
        }
    }
}
class ThreadB extends  Thread {
    private WorkObject workObject;

    public ThreadB(WorkObject workObject) {
        this.workObject = workObject;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodB();
        }
    }
}



