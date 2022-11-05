import { CardListModal, CreditCardModal } from "../modal/modal";
import httpservice from "./httpservice";

const getAll = () => {
    return httpservice.get<Array<CardListModal>>("/creditCards");
};


const create = (data: CreditCardModal) => {
    return httpservice.post<CardListModal>("/addCreditCard", data);
};

const CcpService = {
    getAll,
    create,
  };
  
  export default CcpService;