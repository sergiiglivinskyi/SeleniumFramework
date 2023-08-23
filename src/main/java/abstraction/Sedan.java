package abstraction;

public class Sedan extends Cars{

    @Override
    public void engine() {
        System.out.println("Sedan has V6 engine");
    }

    @Override
    public void horsePower() {
        System.out.println("Horse power for sedans normally 200-290 hp");
    }
}
