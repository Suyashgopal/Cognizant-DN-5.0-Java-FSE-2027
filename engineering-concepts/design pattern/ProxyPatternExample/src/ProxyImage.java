public class ProxyImage implements Image {

    private RealImage realimage;

    private String filename;


    public ProxyImage(String filename) {

        this.filename = filename;
    }


    public void display() {


        // creates real object only when required

        if(realimage == null) {

            realimage = new RealImage(filename);
        }


        realimage.display();
    }
}