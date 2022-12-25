import {Component, OnInit} from '@angular/core';
import {RentType} from "../../../model/facility/rent-type";
import {FacilityType} from "../../../model/facility/facility-type";
import {Facility} from "../../../model/facility/facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  year: RentType = {
    id: 1,
    name: "year"
  };

  month: RentType = {
    id: 1,
    name: "month"
  };

  date: RentType = {
    id: 1,
    name: "date"
  };

  hours: RentType = {
    id: 1,
    name: "hours"
  };

  villa: FacilityType = {
    id: 1,
    name: "villa"
  }

  house: FacilityType = {
    id: 1,
    name: "house"
  }

  room: FacilityType = {
    id: 1,
    name: "room"
  }

  facilities: Facility[] = [
    {
      id: 1,
      name: "Villa Beach Front",
      area: 2500,
      cost: 1000000,
      maxPeople: 10,
      facilityType: this.villa,
      rentType: this.date,
      standardRoom: "vip",
      descriptionOtherConvenience: "Có hồ bơi",
      poolArea: 500,
      numberOfFloors: 4,
      flagDelete: false
    },
    {
      id: 2,
      name: "House Princess 01",
      area: 14000,
      cost: 5000000,
      maxPeople: 7,
      facilityType: this.house,
      rentType: this.month,
      standardRoom: "vip",
      descriptionOtherConvenience: "Có thêm bếp nướng",
      numberOfFloors: 3,
      flagDelete: false
    },
    {
      id: 3,
      name: "Room Twin 01",
      area: 5000,
      cost: 1000000,
      maxPeople: 2,
      facilityType: this.room,
      rentType: this.hours,
      facilityFree: "1 xe máy, 1 xe đạp",
      flagDelete: false
    },
    {
      id: 4,
      name: "Villa No Beach Front",
      area: 22000,
      cost: 9000000,
      maxPeople: 8,
      facilityType: this.villa,
      rentType: this.year,
      standardRoom: "normal",
      descriptionOtherConvenience: "Có hồ bơi",
      poolArea: 300,
      numberOfFloors: 3,
      flagDelete: false
    },
    {
      id: 5,
      name: "House Princess 02",
      area: 10000,
      cost: 4000000,
      maxPeople: 5,
      facilityType: this.house,
      rentType: this.date,
      standardRoom: "normal",
      descriptionOtherConvenience: "Có thêm bếp nướng",
      numberOfFloors: 2,
      flagDelete: false
    },
    {
      id: 6,
      name: "Room Twin 02",
      area: 3000,
      cost: 900000,
      maxPeople: 2,
      facilityType: this.room,
      rentType: this.hours,
      facilityFree: "1 xe máy",
      flagDelete: false
    },
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
