package designPattern.create.abstractFactory;

public interface AbstractFactory {
    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);

}

