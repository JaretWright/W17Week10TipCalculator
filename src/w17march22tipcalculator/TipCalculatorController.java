/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17march22tipcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class TipCalculatorController implements Initializable {

    @FXML private TextField mealAmountTextField;
    @FXML private TextField tipPercentTextField;
    @FXML private TextField tipAmountTextField;
    @FXML private TextField totalCostTextField;
    @FXML private Button calculateTipButton;
    @FXML private Label errorLabel;
    
    
    
    public boolean validateInputs()
    {
       boolean response = true;
       
       if (mealAmountTextField.getText().isEmpty() || mealAmountTextField.getText().contains("-"))
       {
           mealAmountTextField.getStyleClass().add("error");
           response = false;
       }
       else 
       {
           mealAmountTextField.getStyleClass().remove("error");
       }
       
       if (tipPercentTextField.getText().isEmpty() || tipPercentTextField.getText().contains("-"))
       {
           tipPercentTextField.getStyleClass().add("error");
           response = false;
       }
       else
       {
           tipPercentTextField.getStyleClass().remove("error");
       }
       
       if (response)
       {
           errorLabel.setText("");
           return true;
       }
       else
       {
            errorLabel.setText("Field(s) in red must conitain numbers > 0");
            return false;
       }
       
    }
    
    
    
    public void calculateTipButtonPushed()
    {
        if (validateInputs())
        {
            double mealAmount=0;
            double tipPercent=0;


            try
            {
                mealAmount = Double.parseDouble(mealAmountTextField.getText());
                mealAmountTextField.getStyleClass().remove("error");
            }    
            catch (NumberFormatException e)
            {
                errorLabel.setText("The meal amount must be numeric only");
                mealAmountTextField.setText("");
                mealAmountTextField.getStyleClass().add("error");
            }

            try
            {
                tipPercent = Double.parseDouble(tipPercentTextField.getText());
                tipPercentTextField.getStyleClass().remove("error");
            }    
            catch (NumberFormatException e)
            {
                errorLabel.setText("The tip percent must be numeric only");
                tipPercentTextField.setText("");
                tipPercentTextField.getStyleClass().add("error");
            }   

            double tipAmount = mealAmount * tipPercent/100;
            tipAmountTextField.setText(String.format("$%.2f", tipAmount));
            totalCostTextField.setText(String.format("$%.2f", tipAmount + mealAmount));
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.errorLabel.setText("");
       
    }    
    
}
