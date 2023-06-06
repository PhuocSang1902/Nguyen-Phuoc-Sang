import {CustomerType} from "./customer-type";

export interface Customer {
  id?: number;
  name?: string;
  customerType?: CustomerType;
  birthday?: string;
  idCard?: number;
  phoneNumber?: string;
  gender?: string;
  email?: string;
  address?: string;
  flagDelete?: boolean;
}
