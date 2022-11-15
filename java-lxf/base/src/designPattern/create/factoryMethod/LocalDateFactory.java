package designPattern.create.factoryMethod;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;

public class LocalDateFactory {
    public static LocalDate fromInt(int yyyyMMdd) {
        String s = yyyyMMdd + "";
        return LocalDate.of(Integer.parseInt(s.substring(0, 4)), Integer.parseInt(s.substring(4, 6)), Integer.parseInt(s.substring(6)));
    }

    public static void main(String[] args) {
        LocalDate date = LocalDateFactory.fromInt(20221115);

        System.out.println(date.getClass());
        System.out.println(date);
    }
}

