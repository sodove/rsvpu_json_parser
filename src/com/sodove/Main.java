package com.sodove;

import com.sodove.model.ScheduleLesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

    JsonParser parser = new JsonParser();
    List<ScheduleLesson> scheduleLesson = parser.parse("v_gru=4030"); // v_gru, v_aud, v_prep
    List<List<ScheduleLesson>> scheduleDateTable = new ArrayList<>();

    if (!scheduleLesson.isEmpty()) {
        String scheduleDate = scheduleLesson.get(0).getDate();
        List<ScheduleLesson> scheduleContent = new ArrayList<>();
        for (int i = 0; i <= scheduleLesson.size(); i++) {
            String scheduleDateCycle;
            try {
                scheduleDateCycle = scheduleLesson.get(i).getDate();
            } catch (IndexOutOfBoundsException e) {
                scheduleDateTable.add(scheduleContent);
                break;
            }
            if (!Objects.equals(scheduleDate, scheduleDateCycle)) {
                scheduleDateTable.add(scheduleContent);
                scheduleContent = new ArrayList<>();
                scheduleDate = scheduleDateCycle;
            }
            scheduleContent.add(scheduleLesson.get(i));
        }
    }
    System.out.println(scheduleDateTable);
    }
}
