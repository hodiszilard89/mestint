//package com.example.proba1;
//
//import com.example.proba1.util.State;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class Mezo implements State {
//    int i,j;
//
//
//    private static final  Irany[] iranyok={Irany.E,Irany.K,Irany.D,Irany.NY};
//    //LinkedList <Mezo> nyiltTag = new LinkedList< >();
//    private Mezo szulo ;
//
//    boolean elagazas;
//
//    private List<Mezo> elagazasArray;
//
//    public Mezo(int i, int j , boolean elagazas) {
//        this.i = i;
//        this.j=j;
//        this.elagazas=elagazas;
//    }
//
//    public List<Irany> getFreeWay(MyRectangle rectangle){
//        List<Irany> freeWays = new ArrayList<>();
//        for (Irany zartIrany: rectangle.getTiltottIranyokTomb() ){
//            for (Irany o:iranyok){
//                if (!zartIrany.equals(o))
//                {freeWays.add(o);}
//            }
//        }
//        System.out.println("szabad út   "+rectangle.getTiltottIranyokTomb());
//        System.out.println("zárt út   "+freeWays);
//        return freeWays;
//    }
//
//    public boolean isSolution(){
//        return (this.i==12 && this.j==10);
//    }
//    public List<Mezo> getElagazasArray() {
//        return elagazasArray;
//    }
//
//    public void setElagazasArray(List<Mezo> elagazasArray) {
//        this.elagazasArray = elagazasArray;
//    }
//
//
//    public Mezo getSzulo() {
//        return szulo;
//    }
//
//    public void setSzulo(Mezo szulo) {
//        this.szulo = szulo;
//    }
//}
