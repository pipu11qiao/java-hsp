package designPattern.create.builder;

class HeadingBuilder {
    public String buildHeading(String line) {
        int n = 0;
        while (line.charAt(0) == '#') {
            n++;
            line = line.substring(1);
        }
        return String.format("<h%d>%s<h%d>", n, line.strip(), n);
    }
}


class ParagraphBuilder {
    public String buildParagraph(String line) {
        return String.format("<p>%s<p>", line.strip());
    }
}


class QuoteBuilder {
    public String buildQuote(String line) {
        return String.format("<q>%s<q>", line.substring(1).strip());
    }
}

public class HtmlBuilder {
    private HeadingBuilder headingBuilder = new HeadingBuilder();
    private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
    private QuoteBuilder quoteBuilder = new QuoteBuilder();

    public String toHtml(String markdown) {
        StringBuilder buffer = new StringBuilder();
        markdown.lines().forEach(line -> {
            if (line.startsWith("#")) {
                buffer.append(headingBuilder.buildHeading(line)).append('\n');
            } else if (line.startsWith(">")) {
                buffer.append(quoteBuilder.buildQuote(line)).append('\n');
            } else {
                buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
            }
        });
        return buffer.toString();
    }

    public static void main(String[] args) {
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        String htmlStr = htmlBuilder.toHtml("## title message\n p sdfsadf p \n>q asdfas q \np sfsdfsdf p");
        System.out.println(htmlStr);
    }
}
