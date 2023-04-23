package com.example.proba1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

enum Irany {E, D, K, NY}

public class MyRectangle extends Rectangle {
    private int i, j;

    //private MyRectangle parent;

    private MyRectangle szulo = null;
    private boolean isElagazas;
    private ArrayList<Irany> tiltottIranyokTomb = new ArrayList<>();

    private static final List <Irany>iranyokLista = List.of(Irany.E,Irany.K,Irany.D,Irany.NY);

    public MyRectangle(MyRectangle szulo){
        this.szulo = szulo;
    }
    public MyRectangle(int x, int y, MyRectangle szulo) {
        super(x, y, Color.DODGERBLUE);
        this.szulo = szulo;
        int i = 0;
        int random;
        random = (int) (Math.random() * 4);
        this.isElagazas=false;
       // iranyokLista = Arrays.asList(iranyok);
        tiltottIranyokTomb.add(iranyokLista.get(random));
    }

    public List<Irany> getFreeWay() {
        List<Irany> freeWay = new ArrayList<>(iranyokLista);
        freeWay.removeAll(this.getTiltottIranyokTomb());

        return freeWay;
    }

    public void addTiltottIranyok(Irany irany){
        if (!tiltottIranyokTomb.contains(irany))
                tiltottIranyokTomb.add(irany);
    }

    public ArrayList<Irany> getTiltottIranyokTomb() {
        return tiltottIranyokTomb;
    }

    public void setTiltottIranyokTomb(ArrayList<Irany> tiltottIranyokTomb) {
        this.tiltottIranyokTomb = tiltottIranyokTomb;
    }

    public boolean getIsElagazas() {
        return isElagazas;
    }
    public void setIsElagazas(boolean elagazas) {
        this.isElagazas = elagazas;
    }
    public MyRectangle getSzulo() {
        return szulo;
    }

    public void setSzulo(MyRectangle szulo) {
        this.szulo = szulo;
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "iranyokTomb=" + tiltottIranyokTomb +
                '}';
    }
}