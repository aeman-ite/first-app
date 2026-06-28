public class HiLife extends Product {

    private int vastness;

    public HiLife(int id, String name, double price, int quantity, int vastness) {
        super(id, name, price, quantity);
        this.vastness = vastness;
    }

    public String getVastness() {
        return vastness + "letter";
    }

    public void setVastness(int vastness) {
        this.vastness = vastness;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("vastness : " + vastness + " leter ");
    }
}