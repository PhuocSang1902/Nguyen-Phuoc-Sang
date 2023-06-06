import {Contract} from './contract';
import {AttachFacility} from './attach-facility';

export interface ContractDetail {
  attachFacilityName?: string;
  id?: number;
  contract?: Contract;
  attachFacility?: AttachFacility;
  quantity?: number;
}
