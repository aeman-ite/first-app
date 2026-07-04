public class Laptop extends Product {

    //====المتغيرات====
    private int ram;
    private String processor;

    public Laptop(int id, String name, double price, int quantity, int ram, String processor) {
        super(id, name, price, quantity);
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    //==== دالة لطباعة كل المنتج ====
    public void display() {
        super.display();
        System.out.println("ram :" + ram + "\n processor :" + processor);
    }
}
