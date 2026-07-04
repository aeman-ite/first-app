public class Mobile extends Product {

    //===== الخصائص =====
    private int batteryCapacity; // سعه البطارية

    public Mobile(int id, String name, double price, int quantity, int batteryCapacity) {
        super(id, name, price, quantity);
        this.batteryCapacity = batteryCapacity;
    }

    //دالة اوفيررايد لطباعه الخصائص
    @Override
    public void display() {
        super.display();
        System.out.println("سعة البطارية :" + batteryCapacity + "mAh");
    }


}
