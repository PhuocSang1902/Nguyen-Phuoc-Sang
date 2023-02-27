import {ProductDetail} from "../../product/entiry/product-detail";
import {Customer} from "../../customer/entity/customer";

export interface Cart {
  id?: number;
  product?: ProductDetail;
  customer?: Customer;
  numberOfProduct?: number;
}
