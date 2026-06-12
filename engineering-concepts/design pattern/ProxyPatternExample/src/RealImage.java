public class RealImage implements Image {

    private String filename;


    public RealImage(String filename) {

        this.filename = filename;

        loadimage();
    }


    // actual image loading happens here

    private void loadimage() {

        System.out.println("loading image: " + filename);
    }


    public void display() {

        System.out.println("showing image: " + filename);
    }
}