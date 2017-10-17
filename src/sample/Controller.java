package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;


public class Controller {

    /*
     * Simple controller class for sample.fxml :
     */

    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;

    @FXML
    private JFXButton openButton;

    @FXML
    private JFXButton playButton;

    @FXML
    private JFXButton fowardButton;

    @FXML
    private JFXButton backwardButton;

    @FXML
    private JFXSlider timeSlider;

    @FXML
    private JFXSpinner spinnerMediaView;

    @FXML
    private JFXSlider volumeSlider;

    @FXML
    private Slider slider;


    @FXML
    private void openButton(ActionEvent event) {

        try {

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Select mp4 or mp4....", "*.mp3", "*.mp4");

            fileChooser.getExtensionFilters().add(extensionFilter);

            File selectedFile = fileChooser.showOpenDialog(null);
            String filepath = selectedFile.toURI().toString();

            mediaPlayer = new MediaPlayer(new Media(filepath));
            mediaView.setMediaPlayer(mediaPlayer);

            mediaPlayer.play();
            mediaPlayer.setAutoPlay(false);


            //For auto-resize :

            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();

            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));


        } catch (Exception exception) {

            System.out.println((char) 27 + "[36m" + "[X] Exception was caused :: Re-run the application and try again. " + (char) 27 + "[0m");
            exception.printStackTrace();
        }

    }

    @FXML
    private void setPlayButton(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void setFowardButton(ActionEvent event) {

        mediaPlayer.seek(mediaPlayer.getStopTime());
    }

    @FXML
    private void setBackwardButton(ActionEvent event) {

        mediaPlayer.seek(mediaPlayer.getStartTime());
    }

    @FXML
    private void pauseToggle(ActionEvent event) {

        mediaPlayer.pause();
    }

    @FXML
    private void setTimeSlider(ActionEvent event) {

        //To be implemented...
    }

}
