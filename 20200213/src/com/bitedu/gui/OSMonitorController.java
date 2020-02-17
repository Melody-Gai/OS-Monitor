package com.bitedu.gui;

import com.bitedu.osm.OSResource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeTableView;

import java.util.Timer;
import java.util.TimerTask;

public class OSMonitorController {
   @FXML private LineChart cpuChart;
    @FXML private TreeTableView fileStat;

    private TimerTask timerTask = null;
    private Timer timer = new Timer();

    public void handleCPUSelectionChanged(Event event) {
        Tab tab = (Tab)event.getTarget();
        if(tab.isSelected()) {
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    OSResource.XYPair[] xyPairs = OSResource.getCPUPercetage();
                    XYChart.Series series = new XYChart.Series();

                    for (OSResource.XYPair xyPair:xyPairs) {
                        XYChart.Data data = new XYChart.Data(xyPair.getX(),xyPair.getY());
                        series.getData().add(data);
                    }

                    Platform.runLater(
                            ()->{
                                if(cpuChart.getData().size() > 0) {
                                    cpuChart.getData().remove(0);
                                }

                                cpuChart.getData().add(series);
                            }
                    );

                }
            };
            timer.schedule(timerTask,0,1000);
        }else {

        }
    }

    public void handleSelectFile(ActionEvent actionEvent) {
        System.out.println("Button action");
    }
}
