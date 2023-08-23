package abstraction;

public class SUV extends Cars{

    @Override
    public void engine() {
        System.out.println("SUV has V8 engine");
    }

    @Override
    public void horsePower() {
        System.out.println("SUVs normally have 270-300 hp");
    }
}
