import java.util.*;

class TaxAmount{
    public double calculateTaxAmount(int ctc){
        double slab = 0;
        if(ctc<=180000) {
            slab = 0;
        }else if(ctc >=180001 && ctc <= 300000){
            slab = 0.1;
        }else if(ctc>=300001 && ctc<=500000) {
            slab = 0.2;
        }else if(ctc>=500001 && ctc<=1000000) {
            slab = 0.3;
        }

        double tax = ctc*slab;

        return tax;
    }
}
public class Assignment1Q5 {
    public static void main(String args[]) {

        int ctc;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ctc");
        ctc = sc.nextInt();
        TaxAmount tax = new TaxAmount();
        System.out.println("The tax amount is "+ tax.calculateTaxAmount(ctc));
        sc.close();
    }
}