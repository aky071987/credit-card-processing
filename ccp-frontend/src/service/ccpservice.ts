import { CardListModal, CreditCardModal } from "../modal/modal";
import httpservice from "./httpservice";

const customConfig = {
    headers: {
    'Content-Type': 'application/json'
    }
};

const getAll = () => {
    return httpservice.get<Array<CardListModal>>("/creditCards");
};


const create = (data: CreditCardModal) => {
    return httpservice.post<CardListModal>("/addCreditCard", JSON.stringify(data), customConfig);
};

const CcpService = {
    getAll,
    create,
  };
  
  export default CcpService;