// This factory only creates PDF document objects.

public class PdfFactory extends DocumentFactory {

    public Document createdocument() {

        return new PdfDocument();
    }
}