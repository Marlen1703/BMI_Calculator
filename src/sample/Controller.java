package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {
    Double num1;
    Double num2;
    Double result;
    @FXML
    private ImageView image;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField display;
    @FXML
    void calculate(ActionEvent event){
        try {
            num1 = Double.parseDouble(height.getText());
            num2 = Double.parseDouble(weight.getText());
            result = num2 / (num1 * num1);
//            result = Math.round(result * 100000) / 10.0;

            if (result >= 18.5) {
                Image normal=new Image("sample/Normal.jpg");
                image.setImage(normal);
                image.setFitHeight(280);
                display.setText(" Your BMI is equal to " + result + "\n" + ".You are Normal.");
            }
            if(result<18.5){
                display.setText(" Your BMI is equal to " + result + "\n" + ".You are underweight.");
                Image underweight=new Image("sample/UnderWeight.jpg");
                image.setImage(underweight);
                image.setFitHeight(280);
            }
            if(result>=25){
                display.setText(" Your BMI is equal to " + result + "\n" + ".You are overweight.");
                Image overweight=new Image("sample/OverWeight.jpg");
                image.setImage(overweight);
                image.setFitHeight(280);

            }
            if(result>=30){
                display.setText(" Your BMI is equal to " + result + "\n" + ".You are Obese.");
                Image obese=new Image("sample/Obese.jpg");
                image.setImage(obese);
                image.setFitHeight(280);
            }
        }
        catch (Exception c){
            display.setText(("Enter values !!!"));
            Image default_image=new Image("/sample/bmi.png");
            image.setImage(default_image);
            image.setFitHeight(280);
        }
    }
    @FXML
    void reset(ActionEvent event) {
        height.setText("");
        weight.setText("");
        display.setText("");
        Image default_image=new Image("sample/bmi.png");
        image.setImage(default_image);

    }

}
