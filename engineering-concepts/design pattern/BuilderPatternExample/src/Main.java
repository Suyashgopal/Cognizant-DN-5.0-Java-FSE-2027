public class Main {

    public static void main(String[] args) {


        // creating different computer objects easily using builder

        Computer c1 = new Computer.Builder()
                .setcpu("i7")
                .setram("16gb")
                .setstorage("512gb ssd")
                .build();


        Computer c2 = new Computer.Builder()
                .setcpu("i5")
                .setram("8gb")
                .build();


        c1.showdetails();

        System.out.println();

        c2.showdetails();
    }
}