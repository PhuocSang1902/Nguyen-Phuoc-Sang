import {OrderDetail} from "./order-detail";
import {Customer} from "../../customer/entity/customer";

export interface OrderList {
  id?: number;
  paymentStatus?: boolean;
  deliveryAddress?: string;
  deliveryPhone?: string;
  orderValue?: number;
  orderDate?: string;
  status?: boolean;
}
