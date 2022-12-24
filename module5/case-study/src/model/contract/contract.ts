import {Customer} from "../customer/customer";
import {Employee} from "../employee/employee";
import {Facility} from "../facility/facility";

export interface Contract {
  id?: number;
  startDate?: number;
  endDate?: number;
  deposit?: number;
  customer?: Customer;
  employee?: Employee;
  facility?: Facility;
}
