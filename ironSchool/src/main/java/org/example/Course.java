package org.example;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
        this.money_earned = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public double getMoney_earned() {
        return money_earned;
    }


    public void addEarnings(double earnings){
        if (earnings > 0){
            this.money_earned += earnings;
        }
    }
}
