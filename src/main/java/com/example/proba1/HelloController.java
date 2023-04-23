package com.example.proba1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private static final List <Irany>iranyokLista = List.of(Irany.E,Irany.K,Irany.D,Irany.NY);
    private MyRectangle[][] rectangles = new MyRectangle[12][10];
    private ArrayList<MyRectangle> state= new ArrayList<>();
    //private State state = new State(rectangles);
    private Double egerX = 0.0;
    private Double egerY = 0.0;

    private Irany parent=null;
    private final Image egerImage = new Image(getClass().getResourceAsStream("/images/eger2.png"));
    private final Image sajtImage = new Image(getClass().getResourceAsStream("/images/sajt.png"));

    private final ImageView eger = new ImageView(egerImage);

    private final ImageView sajt = new ImageView(sajtImage);
    double x = 0;
    @FXML
    private AnchorPane palya;

    @FXML
    private Label labelFx;
    @FXML
    private AnchorPane fx_palya;

    @FXML
    private Button btnMovie;

    @FXML
    protected void buttonClick() {
        palyaKirajzolas();
        labelFx.setText("");
        egerX=0.0;
        egerY=0.0;
        eger.setX(egerX);
        eger.setY(egerY);
    }

    public void gombnyomas(KeyEvent event) {
        System.out.println(event);
        String text = event.getText();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {

                if (rectangles[i][j].contains(new Point2D(egerX + 5, egerY + 5))) {
                    System.out.println(i + " : " + j + " " + rectangles[i][j].getTiltottIranyokTomb());
                    if ((text.equals("d") && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.K))) && (egerX + 40 <= 480)) {
                        egerX += 40;

                    }
                    if ((text.equals("a") && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.NY)) && (egerX - 40 >= 0))) {
                        egerX -= 40;

                    }
                    if ((text.equals("s") && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.D)) && (egerY + 40 <= 400))) {
                        egerY += 40;

                    }
                    if ((text.equals("w") && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.E)) && (egerY - 40 >= 0))) {
                        egerY -= 40;

                    }

                    text = "";

                    break;
                }

            }
        }
        eger.setX(egerX);
        eger.setY(egerY);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    private void movingMouse(MyRectangle eger, Point2D point) {
//
//    }

    private void palyaKirajzolas() {
        state.clear();

        Rectangle keret = new Rectangle(4, 4, 482, 402);
        keret.setStroke(Color.BLACK);
        keret.setStrokeWidth(3);
        keret.setFill(Color.TRANSPARENT);
        fx_palya.getChildren().add(keret);


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                MyRectangle rect = new MyRectangle(40, 40, null);
                rect.setY(j * 40 + 4);
                rect.setX(i * 40 + 4);
                rectangles[i][j] = rect;
                fx_palya.getChildren().add(rect);
            }
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {

                for (Irany irany : rectangles[i][j].getTiltottIranyokTomb()) {
                    if (irany.equals(Irany.E)) {
                        fx_palya.getChildren().add(
                                new Rectangle(rectangles[i][j].getX(), rectangles[i][j].getY(), 40, 2));
                    }
                    if (irany.equals(Irany.D)) {
                        fx_palya.getChildren().add(
                                new Rectangle(rectangles[i][j].getX(), rectangles[i][j].getY() + 40, 40, 2));
                    }
                    if (irany.equals(Irany.K)) {
                        fx_palya.getChildren().add(
                                new Rectangle(rectangles[i][j].getX() + 40, rectangles[i][j].getY(), 2, 40));
                    }
                    if (irany.equals(Irany.NY)) {
                        fx_palya.getChildren().add(
                                new Rectangle(rectangles[i][j].getX(), rectangles[i][j].getY(), 2, 40));
                    }
                }
            }
        }


        sajt.setX(rectangles[11][9].getX());
        sajt.setY(rectangles[11][9].getY());

        sajt.setFitWidth(39);
        sajt.setFitHeight(39);
        fx_palya.getChildren().remove(eger);
        fx_palya.getChildren().add(eger);
        fx_palya.getChildren().remove(sajt);
        fx_palya.getChildren().add(sajt);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i == 0) && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.NY)))
                    rectangles[i][j].getTiltottIranyokTomb().add(Irany.NY);
                if ((j == 0) && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.E)))
                    rectangles[i][j].getTiltottIranyokTomb().add(Irany.E);
                if ((i == 11) && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.K)))
                    rectangles[i][j].getTiltottIranyokTomb().add(Irany.K);
                if ((j == 9) && (!rectangles[i][j].getTiltottIranyokTomb().contains(Irany.D)))
                    rectangles[i][j].getTiltottIranyokTomb().add(Irany.D);
                if (((i - 1) >= 0) && (rectangles[i - 1][j].getTiltottIranyokTomb().contains(Irany.K))) {

                    if (!(rectangles[i][j].getTiltottIranyokTomb().contains(Irany.NY))) {

                        rectangles[i][j].getTiltottIranyokTomb().add(Irany.NY);
                    }
                }
                if (((j - 1) >= 0) && (rectangles[i][j - 1].getTiltottIranyokTomb().contains(Irany.D))) {

                    if (!(rectangles[i][j].getTiltottIranyokTomb().contains(Irany.E))) {
                        rectangles[i][j].getTiltottIranyokTomb().add(Irany.E);
                    }
                }
                if (((i + 1) < 12) && (rectangles[i + 1][j].getTiltottIranyokTomb().contains(Irany.NY))) {
                    if (!(rectangles[i][j].getTiltottIranyokTomb().contains(Irany.K))) {
                        rectangles[i][j].getTiltottIranyokTomb().add(Irany.K);
                    }
                }
                if (((j + 1) < 10) && (rectangles[i][j + 1].getTiltottIranyokTomb().contains(Irany.E))) {
                    if (!(rectangles[i][j].getTiltottIranyokTomb().contains(Irany.D))) {
                        rectangles[i][j].getTiltottIranyokTomb().add(Irany.D);
                    }
                }
                //System.out.println(rectangles[i][j].toString());

            }

        }
        // state=new State(rectangles);

    }

    ///------------------------------------------------útvonal keresés--------------------------
    private void utvonalKereses() {
        int i = (int) (egerX / 40), j = (int) (egerY / 40);
        state.add(rectangles[i][j]);
        if (i==11 && j==9)
            labelFx.setText("Célba értél");
        System.out.println(i + " " + j);
        if (rectangles[i][j].getFreeWay().isEmpty()) {
            System.out.println("nincs kiút");
        } else {

            List<Irany> szabadIranyList = rectangles[i][j].getFreeWay();
            for (MyRectangle o: state){
                if ( ((int)(o.getX()/40) == i-1)&& ((int)(o.getY()/40)==j)){
                    szabadIranyList.remove(Irany.NY);
                }
                if ( ((int)(o.getX()/40) == i+1)&& ((int)(o.getY()/40)==j)){
                    szabadIranyList.remove(Irany.K);
                }
                if ( ((int)(o.getX()/40) == i)&& ((int)(o.getY()/40)==j+1)){
                    szabadIranyList.remove(Irany.D);
                }
                if ( ((int)(o.getX()/40) == i)&& ((int)(o.getY()/40)==j-1)){
                    szabadIranyList.remove(Irany.E);
                }
            }
            //----------------------lehet egyszerübben
            if (szabadIranyList.size()>1) {
                rectangles[i][j].setIsElagazas(true);
            }
            else {
                rectangles[i][j].setIsElagazas(false);
            }
            int c = state.size()-1;

            if (szabadIranyList.isEmpty()){

                while (c > 0) {

                    if (state.get(c).getIsElagazas()) {

                        break;
                    }else {
                        c--;
                    }
                    //System.out.println(state.get(c));
                }
                egerX=state.get(c).getX();
                egerY=state.get(c).getY();
                eger.setX(state.get(c).getX());
                eger.setY(state.get(c).getY());
                //System.out.println(c);
            }
            System.out.println( rectangles[i][j].getIsElagazas());
            //------------
            if (!szabadIranyList.isEmpty()){
                System.out.println(szabadIranyList);
                Irany szabadIrany = szabadIranyList.get(0);
                System.out.println("ide léphetsz" + szabadIrany);
                if (szabadIrany.equals(Irany.K)) {

                    if ((egerX + 40 < 480) && !state.contains(rectangles[i + 1][j])) {
                        System.out.println("visszaleptem");
                        egerX += 40;
                        eger.setX(egerX);
                    }
                }
                if (szabadIrany.equals(Irany.E)) {
                    if ((egerY - 40 >= 0) && !state.contains(rectangles[i][j - 1])) {
                        System.out.println("visszaleptem");
                        egerY -= 40;
                        eger.setY(egerY);
                    }
                }
                if (szabadIrany.equals(Irany.NY)) {
                    if ((egerX - 40 >= 0) && !state.contains(rectangles[i - 1][j])) {
                        System.out.println("visszaleptem");
                        egerX -= 40;
                        eger.setX(egerX);
                    }
                }
                if (szabadIrany.equals(Irany.D)) {
                    if ((egerY + 40 < 400) && !state.contains(rectangles[i][j + 1])) {
                        System.out.println("visszaleptem");
                        egerY += 40;
                        eger.setY(egerY);
                    }
                }


                //labelFx.setText("megoldás");

            }
            else {

                System.out.println(egerX+"  "+egerY);
                if(eger.getX()==4 && eger.getY()==4)
                    labelFx.setText("nincs kiút");

                //System.out.println("nicns kiút");
            }
        }
//        if (i==11 && j==9)
//            labelFx.setText("Célba értél");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        palyaKirajzolas();

    }

    public void eloreLepHandel(ActionEvent actionEvent) {
        utvonalKereses();
    }
}