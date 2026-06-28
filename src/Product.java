public class Product {
    //==== الخصائص====
    private int id;
    private String name;
    private double price;
    private int quantity;

    //==== constractur====
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //دوال الغيتر لاخراج القيم وطباعتها
    public int getId() {
        return id;
    }

    //====دوال السيتر لادخال القيم الى المتغيرات ====
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    //====
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //==== دالة لطباعة كل المنتج ====
    public void display() {
        System.out.println(" ID : " + id + "\n name : " + name + "\n price :" + price + "$" + "\n quantity :" + quantity + "قطع");
    }


}
