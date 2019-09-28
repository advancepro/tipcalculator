package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class tipcalculatorcontroller {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal t2_id = new BigDecimal (0.15);

    @FXML private Label per_id;
    @FXML private Label tip_id;
    @FXML private Label tot_id;
    @FXML private Label pr_id;
    @FXML private Button but_id;
    @FXML private TextField t1_id;
    @FXML private TextField t3_id;
    @FXML private TextField tt2_id;
    @FXML private Slider sl_id;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal amount = new BigDecimal(t1_id.getText());
            BigDecimal tip = amount.multiply(t2_id);
            BigDecimal total = amount.add(tip);

            tt2_id.setText(currency.format(tip));
            t3_id.setText(currency.format(total));
        } catch (NumberFormatException ex) {
            t1_id.setText("Enter the price");
            t1_id.selectAll();
            t1_id.requestFocus();
        }
        }
    }

