public class PrintfDemo {
    public static void main(String[] args) {
        double d = 345.76689;
        String s = "你好";
        int i = 13;
//        System.out.printf("num: %d,string: %s", 3, "33");
//        System.out.printf("%4.3f", d);
        System.out.printf("%o", i); // 八进制
        System.out.println();
        System.out.printf("%#o", i); // 八进制
        System.out.println();
        System.out.printf("%x", i); // 十六进制
        System.out.println();
        System.out.printf("%#x", i); // 十六进制
        System.out.println();
        System.out.printf("%d", i); // 十进制
        System.out.println();
    }
}