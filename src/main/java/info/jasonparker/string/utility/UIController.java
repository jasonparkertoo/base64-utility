package info.jasonparker.string.utility;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UIController {

    @FXML
    private TextArea encode;

    @FXML
    private TextArea decode;

    @FXML
    private AnchorPane pane;

    @FXML
    void toBase64(Event event) {
        var input = this.encode.getText();
        var base64 = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
        decode.setText(base64);
    }

    @FXML
    void toString(Event event) {
        try {
            var output = this.decode.getText();
            var string = Base64.getDecoder().decode(output.getBytes(StandardCharsets.UTF_8));
            this.encode.setText(new String(string));
        } catch (IllegalArgumentException e) {
            this.encode.setText("Invalid Base64");
        }
    }

    @FXML
    void clear(Event event) {
        var source = ((TextArea) event.getSource()).getId();

        if (source.compareToIgnoreCase("output") < 0) {
            this.encode.clear();
        }

        this.decode.clear();
    }
}

