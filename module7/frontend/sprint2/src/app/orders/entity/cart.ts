import {ProductDetail} from "../../product/entiry/product-detail";
import {Customer} from "../../customer/entity/customer";
import {ProductHome} from "../../product/entiry/productHome";

export interface Cart {
  id?: number;
  productHome?: ProductHome;
  product?: ProductDetail;
  idAccount?: number;
  numberOfProduct?: number;
  total?: number;
}
