public class Main {

    public static void main(String[] args) {

        Light light = new Light();

        RemoteControl remote = new RemoteControl();


        // wrapping light actions as command objects

        remote.setcommand(new LightOnCommand(light));
        remote.pressbutton();


        remote.setcommand(new LightOffCommand(light));
        remote.pressbutton();
    }
}