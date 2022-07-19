public abstract class Animal { // 추상클래스
    public String type;

    public void breath(){
        System.out.println("breathing!!.");
    }
    public abstract void sound(); // 추상메소드
}

//추상 클래스를 상속 받는 실체 클래스들은 반드시 추상메소드를 상속받아 오버라이딩해야 한다.
class Dog extends Animal{  //Animal 클래스 상속받음

    public Dog(){
        this.type = "mammalia";
    }

    public void sound() {  // 추상메소드 오버라이딩
        System.out.println("bau! bau!");
    }
}

class AnimalEx {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
    }
}