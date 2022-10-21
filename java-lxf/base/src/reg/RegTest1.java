package reg;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegTest1 {
    public static void main(String[] args) {
        String reg = "20\\d\\d";
        System.out.println("\033[0;32m" + ("2019".matches(reg)) + "\033");
        System.out.println("aa");
        System.out.println("2100".matches(reg));
        System.out.println("bb");
    }
}

class RegTest2 {
    public static void main(String[] args) throws Exception {
        String re = "\\d{3,4}-\\d{7,8}";

        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}

class RegTest3 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败");
        }
    }
}