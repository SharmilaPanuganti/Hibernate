package cgg.tutorial.hql;

public class StudentStatistics {
    private long studentCount;
    private Double avgMarks;
    private Double minMarks;
    private Double sum;
    public StudentStatistics() {
    }
    public StudentStatistics(long studentCount, Double avgMarks, Double minMarks, Double sum) {
        this.studentCount = studentCount;
        this.avgMarks = avgMarks;
        this.minMarks = minMarks;
        this.sum = sum;
    }
    public long getStudentCount() {
        return studentCount;
    }
    public void setStudentCount(long studentCount) {
        this.studentCount = studentCount;
    }
    public Double getAvgMarks() {
        return avgMarks;
    }
    public void setAvgMarks(Double avgMarks) {
        this.avgMarks = avgMarks;
    }
    public Double getMinMarks() {
        return minMarks;
    }
    public void setMinMarks(Double minMarks) {
        this.minMarks = minMarks;
    }
    public Double getSum() {
        return sum;
    }
    public void setSum(Double sum) {
        this.sum = sum;
    }
    @Override
    public String toString() {
        return "StudentStatistics [studentCount=" + studentCount + ", avgMarks=" + avgMarks + ", minMarks=" + minMarks
                + ", sum=" + sum + "]";
    }
}
