public class RemoteControl {

    private Command command;


    // stores command so button can run any action

    public void setcommand(Command command) {
        this.command = command;
    }


    public void pressbutton() {
        command.execute();
    }
}