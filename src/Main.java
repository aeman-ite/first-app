import java.util.ArrayList;
import java.util.Scanner;

class warehouseLinkedlistStack {
    static node top = null;

    //دالة اضافة البضاعة
    public static void puchProduct(int id) {
        node newNode = new node(id);
        newNode.next = top;
        top = newNode;

    }

    //دالة التراجع عن العملية الاخيرة
    public static int undoLastAction() {
        if (top == null) {
            System.out.println("لم يتم العثور على اي عملية");
            return -1;
        } else {
            node firstNode = top;
            int removedId = top.id;
            top = firstNode.next;
            return removedId;
        }
    }

    static class node {
        int id;
        node next;

        node(int id) {
            this.id = id;
            this.next = null;
        }
    }
}

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
            System.out.println("6: التراجع عن اخر عملية ");
            System.out.println("\n");
            System.out.print("7 الخروج من الموقع ");
            
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
                    while (choiceUser < 1 || choiceUser > 3) {
                        System.out.println("ادخل رقم من الخيارات المتاحة ");
                        choiceUser = input.nextInt();
                        input.nextLine();
                    }


                    System.out.println("ادخل اسم المنتج :");
                    String name = input.nextLine();

                    System.out.println("ادخل الرقم التعريفي id :");
                    int id = input.nextInt();
                    warehouseLinkedlistStack.puchProduct(id);
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
                    System.out.println("التراجع عن اخر عملية اضفتها ");
                    int deletId = warehouseLinkedlistStack.undoLastAction();
                    if (deletId != -1) {
                        mywarehouse.removeProductById(deletId);
                    }
                    System.out.println("\n");
                    break;


                case 7:
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
