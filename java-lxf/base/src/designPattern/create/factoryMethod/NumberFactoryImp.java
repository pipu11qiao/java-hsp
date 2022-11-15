package designPattern.create.factoryMethod;

import java.math.BigDecimal;

public class NumberFactoryImp implements NumberFactory {
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
