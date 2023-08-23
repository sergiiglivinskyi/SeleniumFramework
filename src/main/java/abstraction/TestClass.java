package abstraction;

public class TestClass {

    public static void main(String[] args) {

        Sedan sedan = new Sedan();
        sedan.horsePower();
        sedan.engine();
        sedan.sound();

        SUV suv = new SUV();
        suv.engine();
        suv.sound();
        suv.horsePower();
    }
}
