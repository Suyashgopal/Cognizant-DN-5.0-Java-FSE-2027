public class StudentController {

    private Student student;
    private StudentView view;


    // controller connects model data with view

    public StudentController(Student student, StudentView view) {

        this.student = student;
        this.view = view;
    }


    public void setstudentname(String name) {
        student.setname(name);
    }


    public void setstudentgrade(String grade) {
        student.setgrade(grade);
    }


    public void updateview() {

        view.showdetails(
                student.getname(),
                student.getid(),
                student.getgrade()
        );
    }
}