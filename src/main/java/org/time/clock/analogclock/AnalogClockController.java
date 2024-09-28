package org.time.clock.analogclock;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.time.LocalTime;


public class AnalogClockController {

    @FXML
    private ImageView HourHand;

    @FXML
    private ImageView MinuteHand;

    @FXML
    private ImageView SecondHand;

    public void updateClock() {
        LocalTime now = LocalTime.now();
        int second = now.getSecond();
        int minute = now.getMinute();
        int hour = now.getHour();

        double secondAngle = second * (6);
        double minuteAngle = (minute * 6) + (second * 0.1);
        double hourAngle = (30 * hour) + (minute * 0.5) + (second / 120);

        SecondHand.setRotate(secondAngle);
        MinuteHand.setRotate(minuteAngle);
        HourHand.setRotate(hourAngle);
    }

    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}