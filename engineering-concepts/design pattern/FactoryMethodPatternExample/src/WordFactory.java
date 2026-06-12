// This factory only creates Word document objects.

public class WordFactory extends DocumentFactory {

    public Document createdocument() {

        return new WordDocument();
    }
}