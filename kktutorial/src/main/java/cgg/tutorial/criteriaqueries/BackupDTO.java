package cgg.tutorial.criteriaqueries;

public class BackupDTO {
    private String name;
    private int id;
    private Double marks;
    public BackupDTO() {
    }
    public BackupDTO(String name, int id, Double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getMarks() {
        return marks;
    }
    public void setMarks(Double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "BackupDTO [name=" + name + ", id=" + id + ", marks=" + marks + "]";
    }
}
