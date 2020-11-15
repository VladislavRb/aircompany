package entity;

import entity.plane.ExperimentalPlane;
import entity.model.MilitaryType;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    @Override
    public String toString() {
        return "Airport{Planes=" + planes.toString() + '}';
    }
}
