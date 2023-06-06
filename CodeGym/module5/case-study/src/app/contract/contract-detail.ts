import {Contract} from "./contract";
import {AttachFacility} from "./attach-facility";

export interface ContractDetail {
  id?: number;
  contract?: Contract;
  attachFacility?: AttachFacility;
  quantity?: number;
}
