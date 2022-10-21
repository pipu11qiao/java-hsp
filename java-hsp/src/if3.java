
import java.util.Scanner;

public class if3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入信用分:");
        int grade = myScanner.nextInt();

        System.out.println(grade);

        if (grade > 1) {
            if (grade == 100) {
                System.out.println("信用极好");
            } else if (grade > 80 && grade <= 99) {
                System.out.println("信用很好");
            } else if (grade > 70 && grade <= 80) {
                System.out.println("信用好");
            }else{
                System.out.println("信用一般");
            }
        } else {
            System.out.println("信用差");
        }
    }
}