public class Student {

    private String name;
    private int id;
    private String grade;


    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }


    public String getname() {
        return name;
    }

    public int getid() {
        return id;
    }

    public String getgrade() {
        return grade;
    }


    public void setname(String name) {
        this.name = name;
    }

    public void setgrade(String grade) {
        this.grade = grade;
    }
}