package ss4_class_and_object.practice.Lesson1Rectangular;

import java.util.Scanner;

public class Rectangular {
    private double width;
    private double height;

    Rectangular(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return (width + height) * 2;
    }

    public String display(){
        return "Rectangular{" + "width= " + width + ", height= " + height + "}";
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

