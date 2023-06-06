import {Image} from "./image";

export interface ProductDetail {
  id?: number;
  code?: number;
  name?: string;
  description?: string;
  cost?: number;
  amountInStore?: number;
  publisher?: string;
  issuingCompany?: string;
  publicationDate?: string;
  kindOfBook?: string;
  author?: string;
  coverType?: string;
  numberOfPages?: string;
  imageSet?: Image[];
}
