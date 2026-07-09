import java.util.ArrayList;
import java.util.InputMismatchException;
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

            int choice = 0;
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
            System.out.println("\n");
            System.out.print("ادخل رقم خيارك 😊 : ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException exp) {
                System.out.println("int can not be String");
            }

            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("===== المحتويات الموجودة بالمستودع =====");
                    mywarehouse.showInventory();
                    System.out.println("\n");
                    break;
                case 2:

                    System.out.print("==== البحث عن منتج بواسطة رقم التعريف الرجاء ادخال رقم التعريف : ====");
                    int searchId = 0;
                    boolean runingSearchId = true;
                    while (runingSearchId) {
                        try {
                            searchId = input.nextInt();
                            input.nextLine();
                            runingSearchId = false;
                        } catch (InputMismatchException expId) {
                            System.out.println("int can not be String ");
                            input.nextLine();
                        }
                    }
                    mywarehouse.searchProductById(searchId);
                    System.out.println("\n");
                    runingSearchId = false;
                    break;
                case 3:
                    System.out.print(" 3 : حذف المنتج بواسطة رقم التعريف الرجاء ادخال رقم المنتج المراد حذفه");
                    int removeId = 0;
                    boolean runRemovId = true;
                    while (runRemovId) {
                        try {
                            removeId = input.nextInt();
                            input.nextLine();
                            runRemovId = false;
                        } catch (InputMismatchException expRe) {
                            System.out.println("int can not be String ");
                            input.nextLine();
                        }
                    }
                    mywarehouse.removeProductById(removeId);
                    System.out.println("\n");
                    break;


                case 4:
                    System.out.println("\n");
                    System.out.println("4:اضافة منتج الى القائمة ");
                    System.out.println(" اختر صنف المنتج الذي تريده : " + " || enter 1:generic product " + "  || enter 3:laptop " + " || enter 2: mobile");
                    int choiceUser = 0;
                    while (choiceUser < 1 || choiceUser > 3) {
                        try {
                            choiceUser = input.nextInt();
                            input.nextLine();
                            if (choiceUser < 1 || choiceUser > 3) {
                                System.out.println("ادخل رقم من الخيارات المتاحة ");
                            }
                        } catch (InputMismatchException exc) {
                            System.out.println("int can not be String ");
                            input.nextLine();
                        }
                    }
                    // الاسم
                    System.out.println("ادخل اسم المنتج :");
                    String name = input.nextLine();
                    //الرقم التعريفي
                    System.out.println("ادخل الرقم التعريفي id :");
                    int id = 0;
                    boolean runId = true;
                    while (runId) {
                        try {
                            id = input.nextInt();
                            input.nextLine();
                            runId = false;
                        } catch (InputMismatchException expId) {
                            System.out.println("int can not be string");
                            input.nextLine();
                        }
                        warehouseLinkedlistStack.puchProduct(id);
                    }
                    //السعر
                    System.out.println("ادخل سعر المنتج :");
                    double price = 0;
                    boolean runPrice = true;
                    while (runPrice) {
                        try {
                            price = input.nextDouble();
                            input.nextLine();
                            runPrice = false;
                        } catch (InputMismatchException expPrice) {
                            System.out.println("int can not be string");
                            input.nextLine();
                        }
                    }
                    //الكمية
                    System.out.println("ادخل الكمية : ");
                    int quantity = 0;
                    boolean runQuntity = true;
                    while (runQuntity) {
                        try {
                            quantity = input.nextInt();
                            input.nextLine();
                            runQuntity = false;
                        } catch (InputMismatchException expQuantity) {
                            System.out.println("int can not be string");
                            input.nextLine();
                        }
                    }


                    if (choiceUser == 1) {
                        //انشاء كائن جديد
                        Product userProduct = new Product(id, name, price, quantity);
                        mywarehouse.addProduct(userProduct);
                        System.out.println("تمت اضافة المنتج بنجاح ");
                        break;
                    } else if (choiceUser == 2) {
                        System.out.println("ادخل حجم الرام : ");
                        int ram = 0;
                        boolean runRam = true;
                        while (runRam) {
                            try {
                                ram = input.nextInt();
                                input.nextLine();
                                runRam = false;
                            } catch (InputMismatchException expRam) {
                                System.out.println("int can not be string");
                                input.nextLine();
                            }
                        }
                        System.out.println("ادخل نوع المعالج : ");
                        String processor = input.nextLine();
                        Laptop userLaptop = new Laptop(id, name, price, quantity, ram, processor);
                        mywarehouse.addProduct(userLaptop);
                        break;
                    } else if (choiceUser == 3) {
                        System.out.println("ادخل سعه البطارية ");
                        int battery = 0;
                        boolean runBattery = true;
                        while (runBattery) {
                            try {
                                battery = input.nextInt();
                                input.nextLine();
                                runBattery = false;
                            } catch (InputMismatchException expBattery) {
                                System.out.println("int can not be string");
                                input.nextLine();
                            }
                        }
                        Mobile mobileUser = new Mobile(id, name, price, quantity, battery);
                        mywarehouse.addProduct(mobileUser);
                    }
                    break;


                case 5:
                    System.out.println("ادخل رقم المنتج الذي تريد بيعه : ");
                    int productId = 0;
                    boolean runProductId = true;
                    while (runProductId) {
                        try {
                            productId = input.nextInt();
                            input.nextLine();
                            runProductId = false;
                        } catch (InputMismatchException expRunProductId) {
                            System.out.println("int can not be string");
                            input.nextLine();
                        }
                    }
                    boolean loopQuantity = true;
                    while (loopQuantity) {
                        System.out.println("ادخل الكمية التي تريدها و ادخل الرقم 0 للرجوع الى القائمة");
                        int productQuantity = 0;
                        boolean runProductQuantity = true;
                        while (runProductQuantity) {
                            try {
                                productQuantity = input.nextInt();
                                input.nextLine();
                                runProductQuantity = false;
                            } catch (InputMismatchException expproductQuantity) {
                                System.out.println("int can not be string");
                                input.nextLine();

                            }
                            if (productQuantity == 0) {
                                System.out.println("تم الغاء العملية والعودة للقائمة الرئيسية");
                                loopQuantity = false;
                                continue;
                            }

                        }
                        mywarehouse.sellProduct(productId, productQuantity);
                        if (mywarehouse.isSellSuccessful) {
                            loopQuantity = false;
                        }
                    }
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
                    System.out.println("الرجاء اختيار رقم من 1 الى 7 ");
            }

        }
        input.close();

    }
}
