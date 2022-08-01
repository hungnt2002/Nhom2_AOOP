package jdbc.model;

public class Student {
    
    private String mssv;
    private String name;
    private int age;
    private Double diemTrungBinh;

    public Student(String mssv, String name, int age, Double diemTrungBinh) {
        this.mssv = mssv;
        this.name = name;
        this.age = age;
        this.diemTrungBinh = diemTrungBinh;
    }

    

    @Override
    public String toString() {
        return "Student [age=" + age + ", diemTrungBinh=" + diemTrungBinh + ", mssv=" + mssv + ", name=" + name + "]";
    }

    public String getMssv() {
        return mssv;
    }
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Double getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public void setDiemTrungBinh(Double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

}
