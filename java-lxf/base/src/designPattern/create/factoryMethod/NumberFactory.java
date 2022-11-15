package designPattern.create.factoryMethod;

public interface NumberFactory {
    Number parse(String s);

    static NumberFactory getFactory(){
        return impl;
    }
    static NumberFactory impl = new NumberFactoryImp();
}
