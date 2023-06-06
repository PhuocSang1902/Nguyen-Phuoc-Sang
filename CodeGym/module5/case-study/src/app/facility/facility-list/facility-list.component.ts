import {Component, OnInit} from '@angular/core';
import {RentType} from "../rent-type";
import {FacilityType} from "../facility-type";
import {Facility} from "../facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  rentType: RentType[] = [{id: 1, name: "year"}, {id: 1, name: "month"}, {id: 1, name: "date"}, {id: 1, name: "hours"}]

  facilityType: FacilityType[] = [{id: 1, name: "villa"}, {id: 2, name: "house"}, {id: 3, name: "room"}]

  facilities: Facility[] = [
    {
      id: 1,
      name: "Villa Beach Front",
      area: 2500,
      cost: 1000000,
      maxPeople: 10,
      facilityType: this.facilityType[0],
      rentType: this.rentType[2],
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
      facilityType: this.facilityType[1],
      rentType: this.rentType[1],
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
      facilityType: this.facilityType[2],
      rentType: this.rentType[3],
      facilityFree: "1 xe máy, 1 xe đạp",
      flagDelete: false
    },
    {
      id: 4,
      name: "Villa No Beach Front",
      area: 22000,
      cost: 9000000,
      maxPeople: 8,
      facilityType: this.facilityType[0],
      rentType: this.rentType[0],
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
      facilityType: this.facilityType[1],
      rentType: this.rentType[1],
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
      facilityType: this.facilityType[2],
      rentType: this.rentType[3],
      facilityFree: "1 xe máy",
      flagDelete: false
    },
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
