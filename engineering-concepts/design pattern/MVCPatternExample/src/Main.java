public class Main {

    public static void main(String[] args) {


        Student student = new Student("rahul", 101, "A");

        StudentView view = new StudentView();


        // changes are done through controller instead of directly

        StudentController controller =
                new StudentController(student, view);



        controller.updateview();


        controller.setstudentname("amit");
        controller.setstudentgrade("A+");


        controller.updateview();
    }
}