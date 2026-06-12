// This factory only creates Excel document objects.

public class ExcelFactory extends DocumentFactory {

    public Document createdocument() {

        return new ExcelDocument();
    }
}