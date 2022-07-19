public class Cartest {
    public static void main(String[] args) {
        Car bmw = new Car();   // BMW 인스턴스 생성
        Car tesla = new Car(); // BMW 인스턴스 생성

        System.out.println(bmw);
        System.out.println(tesla);

        bmw.model = "530 i";
        bmw.color = "blue";

        tesla.model = "Model Y";
        tesla.color = "white";

        System.out.println("제 BMW의 모델은 " + bmw.model + "이고 " + bmw.color + "색 입니다. 문은" + Car.doors + "개!");
        System.out.println("제 Tesla의 모델은 " + tesla.model + "이고 " + tesla.color + "색 입니다. 문은" + Car.doors + "개!");
    }
}


class Car {
    String model;
    String color;
    static int doors = 4;
    void start() {
        System.out.println("시동을 걸었습니다. 부릉부릉~~");
    }
    void accelerate() {
        System.out.println("속도 업!!");
    }
    void stop() {
        System.out.println("멈춤.");
    }
}
