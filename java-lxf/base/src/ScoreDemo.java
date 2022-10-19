import java.util.Scanner;

public class ScoreDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入上次成绩:");
        int lastScore = sc.nextInt();
        System.out.println("请输入本次成绩:");
        int curScore = sc.nextInt();
        float r = (float) (curScore - lastScore) * 100 / lastScore;
        System.out.printf("成绩提高了%.2f%%",r);
    }
}