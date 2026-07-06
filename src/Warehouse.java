import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
    private final ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    private ArrayList<Product> stock;


    //الكونستراكتور لا يستقبل شيء فقط يقوم باضافة اول منتج
    public Warehouse() {
        stock = new ArrayList<>();

    }

    //====دالة اضافة منتج ====
    public void addProduct(Product p) {
        stock.add(p);
        System.out.println("تمت اضافة المنتج " + p.getName() + "بنجاح🤸‍♀️");
    }

    public void showInventory() {
        System.out.println("======المحتويات الموجودة في المستودع =====");
        if (stock.isEmpty()) {

            System.out.println("المستودع فاارغ ");
            return;
        }
        for (Product p : stock) {
            p.display();
        }
    }

    public void sellProduct(int id, int amountToSell) {
        for (Product p : stock) {
            if (p.getId() == id) {
                if (p.getQuantity() >= amountToSell) {
                    int newQuantity = p.getQuantity() - amountToSell;
                    p.setQuantity(newQuantity);
                    System.out.println("تم بيع " + amountToSell + " قطع من " + p.getName());
                    double total = p.getPrice() * amountToSell;
                    System.out.println("الحساب الاجمالي :" + total + "$");
                    if (p.getQuantity() <= 3) {
                        System.out.println("الكمية من هذا المنتج اصبحت اقل من 3 ");
                    }
                    Invoice newInvoice = new Invoice(p.getName(), amountToSell, total);
                    invoices.add(newInvoice);
                    newInvoice.printInvoice();


                    return;
                } else {
                    System.out.println("الكمية المطلوبة غير متاحة");
                    return;
                }
            }
        }
        System.out.println(" لم يتم العثور على المنتج: " + id);

    }

    public void searchProductById(int id) {
        boolean found = false;
        for (Product p : stock) {
            if (p.getId() == id) {
                System.out.println("تم العثور على الملف بنجاح");
                p.display();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("عذرا لم يتم العثور على المنتج ذو الرقم " + id);
        }
    }

    public void removeProductById(int id) {
        boolean removed = false;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getId() == id) {
                System.out.println("تم حذف المنتج بنجاح ");
                stock.remove(i);
                removed = true;
                break;
            }
        }
        if (removed == false) {
            System.out.println("لم يتم العثور على المنتج ذو الرقم " + id);
        }
    }

}