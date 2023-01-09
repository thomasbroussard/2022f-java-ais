package fr.epita.data.datamodel;

public class Passenger {
    private String name;
    private Integer pClass;
    private Double age;
    private Integer sex;
    private Integer survived;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpClass() {
        return pClass;
    }

    public void setpClass(Integer pClass) {
        this.pClass = pClass;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSurvived() {
        return survived;
    }

    public void setSurvived(Integer survived) {
        this.survived = survived;
    }
}
