package entity.plane;

import entity.model.ClassificationLevel;
import entity.model.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public String toString() {
        return "experimentalPlane{model='" + model + "'}";
    }
}