package Lesson13;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(List.of(stages));
    }

}
