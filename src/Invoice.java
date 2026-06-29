import java.util.Date;

public class Invoice {
    //===== المتغيرات =====
    private static int idcounter = 1;
    //متغير خاص ب رقم الفاتورة
    private int invoicId;
    //متغير اسم المنتج وظيفتو يحفظ اسم المنتج الي انباع ب هذه الفاتورة
    private String productName;
    //متغير وظسفتو يحفظ كم قطعة انباعت بهذه الفاتورة من المنتج
    private int quantitySold;
    //متغير وظيفته بيحفظ الرقم الي رح يدفعو الزبون السعر كلو
    private double totalPrice;
    //متغير جاهز مشان التاريخ والوقت
    private Date date;

    //=====الكونستراكتور =====
    public Invoice(String productName, int quantitySold, double totalPrice) {
        this.invoicId = idcounter++;
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.date = new Date();
    }

    //دالة الطباعة
    public void printInvoice() {
        System.out.println(" فاتورة مبيعات رقم : " + invoicId);
        System.out.println(" التاريخ : " + date);
        System.out.println("اسم المنتج : " + productName);
        System.out.println(" الكمية المباعة : " + quantitySold);
        System.out.println("الحساب الكامل" + totalPrice);


    }


}
