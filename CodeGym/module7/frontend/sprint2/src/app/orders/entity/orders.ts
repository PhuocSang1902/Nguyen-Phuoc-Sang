import {OrderDetail} from "./order-detail";
import {Customer} from "../../customer/entity/customer";

export interface Orders {
  id?: number;
  paymentStatus?: boolean;
  deliveryAddress?: string;
  deliveryPhone?: string;
  orderDetailSet?: OrderDetail[];
  idAccount?: number;
  customer?: Customer;
  orderValue?: number;
}
