package com.company;

import java.awt.*;

public class FactoryDemo {
    public static void main(String[] args) {

        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        //get an object of Shape Square
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of Shape Square
        shape3.draw();

        //get printer factory
        AbstractFactory printerFactory = FactoryProducer.getFactory("printer");

        Printer printer1 = printerFactory.getPrinter("Paper");
        printer1.print();
        Printer printer2 = printerFactory.getPrinter("Web");
        printer2.print();
        Printer printer3 = printerFactory.getPrinter("Screen");
        printer3.print();
    }
}

interface Shape{
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

interface Printer{
    void print();
}

class PaperPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("paper");
    }
}
class WebPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("web");
    }
}
class ScreenPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("screen");
    }
}

abstract class AbstractFactory {
    abstract Printer getPrinter(String type);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return (Shape) new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return (Shape) new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return (Shape) new Square();
        }
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        return null;
    }

}

class PrinterFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("paper")){
            return new PaperPrinter();
        } else if(type.equalsIgnoreCase("web")){
            return new WebPrinter();
        } else if(type.equalsIgnoreCase("Screen")){
            return new ScreenPrinter();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("Printer")){
            return new PrinterFactory();
        }
        return null;
    }
}