import java.util.*;

class ArmstrongNumBetweenRange{
    public int[] armstrongNumbersInRange(int min, int max){
        int[] list; int i;
        ArrayList<Integer> arr= new ArrayList<Integer>();
        for(i=min+1; i<max; i++) {
            int num=i,n=i, sum=0, temp;
            while(num>0) {
                temp=num%10;
                sum += temp*temp*temp;
                num /= 10;
            }
            if(n == sum) {
                arr.add(n);
            }
        }

        list = new int[arr.size()];
        for(i=0; i<arr.size(); i++) {
            list[i]=arr.get(i);
        }
        return list;
    }
}

public class Assignment1Q2 {
    public static void main(String [] args) {
        int min=100; int max=999;
        ArmstrongNumBetweenRange getList=new ArmstrongNumBetweenRange();
        int[] list= getList.armstrongNumbersInRange(min,max);
        for(int i=0; i<list.length; i++) {
            System.out.println(list[i]+" ");
        }
    }

}