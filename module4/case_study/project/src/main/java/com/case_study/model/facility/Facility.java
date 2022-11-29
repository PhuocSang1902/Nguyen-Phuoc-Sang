package com.case_study.model.facility;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    @ManyToOne
    private RentType rentType;
    @ManyToOne
    private FacilityType facilityType;
    private String standardRoom;
    private String descritionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    @Column(columnDefinition = "text")
    private String facilityFree;
    @Column(columnDefinition = "boolean")
    private Boolean flagRemove;

    public Facility() {
    }

    public Facility(Integer id, String name, Integer area, Double cost, Integer maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String descritionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descritionOtherConvenience = descritionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.flagRemove = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescritionOtherConvenience() {
        return descritionOtherConvenience;
    }

    public void setDescritionOtherConvenience(String descritionOtherConvenience) {
        this.descritionOtherConvenience = descritionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Boolean getFlagRemove() {
        return flagRemove;
    }

    public void setFlagRemove(Boolean flagRemove) {
        this.flagRemove = flagRemove;
    }
}
