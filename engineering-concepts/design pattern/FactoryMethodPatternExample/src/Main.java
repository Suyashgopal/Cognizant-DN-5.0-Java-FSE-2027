// Testing factory pattern by creating objects without directly using document classes.

public class Main {

    public static void main(String[] args) {

        DocumentFactory factory;


        factory = new WordFactory();

        Document doc1 = factory.createdocument();

        doc1.open();



        factory = new PdfFactory();

        Document doc2 = factory.createdocument();

        doc2.open();



        factory = new ExcelFactory();

        Document doc3 = factory.createdocument();

        doc3.open();
    }
}