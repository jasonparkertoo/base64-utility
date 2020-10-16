package info.jasonparker.string.utility;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UIController {

    @FXML
    private TextArea input;

    @FXML
    private TextArea output;

    @FXML
    private AnchorPane pane;

    @FXML
    void toBase64(Event event) {
        var input = this.input.getText();
        var base64 = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
        output.setText(base64);
    }
}

