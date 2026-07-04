import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Warehouse mywarehouse = new Warehouse();

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
            System.out.println("5: بيع منتج عن طريق رقم التعريف ");
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
                    System.out.println("4:اضافة منتج الى القائمة ");
                    System.out.println("اختر صنف المنتج :" + " 1 : منتج عادي 2 : laptop 3 : mopile");
                    int choiceUser = input.nextInt();
                    input.nextLine();
                    System.out.println("ادخل اسم المنتج :");
                    String name = input.nextLine();

                    System.out.println("ادخل الرقم التعريفي id :");
                    int id = input.nextInt();

                    System.out.println("ادخل سعر المنتج :");
                    double price = input.nextDouble();

                    System.out.println("ادخل الكمية : ");
                    int quantity = input.nextInt();
                    if (choiceUser == 1) {
                        //انشاء كائن جديد
                        Product userProduct = new Product(id, name, price, quantity);
                        mywarehouse.addProduct(userProduct);
                        System.out.println("تمت اضافة المنتج بنجاح ");
                        break;
                    } else if (choiceUser == 2) {
                        System.out.println("ادخل حجم الرام : ");
                        int ram = input.nextInt();
                        input.nextLine();
                        System.out.println("ادخل نوع المعالج : ");
                        String processor = input.nextLine();
                        Laptop userLaptop = new Laptop(id, name, price, quantity, ram, processor);
                        mywarehouse.addProduct(userLaptop);
                        break;
                    } else if (choiceUser == 3) {
                        System.out.println("ادخل سعه البطارية ");
                        int battery = input.nextInt();
                        input.nextLine();
                        Mobile mobileUser = new Mobile(id, name, price, quantity, battery);
                        mywarehouse.addProduct(mobileUser);
                    }
                    break;


                case 5:
                    System.out.println("ادخل رقم المنتج الذي تريد بيعه : ");
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
