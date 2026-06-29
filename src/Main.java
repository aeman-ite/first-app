import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Warehouse mywarehouse = new Warehouse();
        Product phone = new Product(1, "Redmi 13 pro", 200, 20);
        Laptop wendose = new Laptop(101, "Dell pro", 250, 20, 16, "i7pro");
        HiLife fridge = new HiLife(200, "aljoud", 300, 10, 40);

        mywarehouse.addProduct(phone);
        mywarehouse.addProduct(wendose);
        mywarehouse.addProduct(fridge);
        mywarehouse.sellProduct(1, 5);
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {

            int choice;
            System.out.println("\n");
            System.out.println("الرجاء اختيار عملية من القائمة ");
            System.out.println("\n");
            System.out.println(" 1 : عرض كافة المنتجات في المستودع ");
            System.out.println("\n");
            System.out.println("2 : البحث عن منتج بواسطة رقم التعريف ");
            System.out.println("\n");
            System.out.println(" 3 : حذف المنتج بواسطة رقم التعريف");
            System.out.println("\n");
            System.out.println("4 : اضافة منتج الى القائمة ");
            System.out.println("\n");
            System.out.println("5: شراء منتج عن طريق رقم التعريف ");
            System.out.println("\n");
            System.out.println("6 : الخروج من النظام");
            System.out.println("\n");
            System.out.print("ادخل رقم خيارك 😊 : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("===== المحتويات الموجودة بالمستودع =====");
                    mywarehouse.showInventory();
                    System.out.println("\n");
                    break;
                case 2:

                    System.out.print("==== البحث عن منتج بواسطة رقم التعريف الرجاء ادخال رقم التعريف : ====");
                    int searchId = input.nextInt();
                    mywarehouse.searchProductById(searchId);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.print(" 3 : حذف المنتج بواسطة رقم التعريف الرجاء ادخال رقم المنتج المراد حذفه");
                    int removeId = input.nextInt();
                    mywarehouse.removeProductById(removeId);
                    System.out.println("\n");
                    break;


                case 4:
                    System.out.println("\n");
                    System.out.println("5:اضافة منتج الى القائمة ");
                    System.out.println("ادخل اسم المنتج :");
                    String name = input.nextLine();

                    System.out.println("ادخل الرقم التعريفي id :");
                    int id = input.nextInt();

                    System.out.println("ادخل سعر المنتج :");
                    double price = input.nextDouble();

                    System.out.println("ادخل الكمية : ");
                    int quantity = input.nextInt();

                    //انشاء كائن جديد
                    Product userProduct = new Product(id, name, price, quantity);
                    mywarehouse.addProduct(userProduct);
                    System.out.println("تمت اضافة المنتج بنجاح ");
                    break;

                case 5:
                    System.out.println("ادخل رقم المنتج الذي تريد شراءه : ");
                    int productId = input.nextInt();
                    System.out.println("ادخل الكمية التي تريدها ");
                    int productQuantity = input.nextInt();
                    mywarehouse.sellProduct(productId, productQuantity);
                    break;

                case 6:
                    System.out.println("شكرا لاستخدام برنامجنا 😊 تم تسجيل الخروج بنجاح ");
                    running = false;
                    break;

                default:
                    System.out.println("الرجاء اختيار رقم من 1 الى 6 ");
            }

        }
        input.close();

    }
}
