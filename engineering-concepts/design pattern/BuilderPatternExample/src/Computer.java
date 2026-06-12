public class Computer {

    private String cpu;
    private String ram;
    private String storage;


    // private constructor forces object creation through Builder only
    private Computer(Builder builder) {

        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }


    public void showdetails() {

        System.out.println("cpu: " + cpu);
        System.out.println("ram: " + ram);
        System.out.println("storage: " + storage);
    }



    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;


        public Builder setcpu(String cpu) {

            this.cpu = cpu;
            return this;
        }


        public Builder setram(String ram) {

            this.ram = ram;
            return this;
        }


        public Builder setstorage(String storage) {

            this.storage = storage;
            return this;
        }


        // returns final computer object after setting values
        public Computer build() {

            return new Computer(this);
        }
    }
}