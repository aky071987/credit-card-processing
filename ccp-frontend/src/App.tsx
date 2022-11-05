import React, { ChangeEvent, useEffect, useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import AddCreditCard from './components/add-card/AddCreditCard';
import ListCard from './components/list-card/ListCard';
import { CardListModal } from './modal/modal';
import { checkCardNumber, checkLuhn10Number } from './util/util';
import CcpService from './service/ccpservice';

function App() {
  const [creditCardModal, setCreditCardModal] = useState({
    userName: '', cardNumber: '', cardLimit: 0
  });

  const [validationErrors, setValidationErrors] = useState({
      userNameError: false, cardNumberError: false, cardLimitError: false
  });

  const [cardList, setCardList] = useState<CardListModal[]>([]);

  useEffect(() => {
    console.log("card list api called ....");
    CcpService.getAll()
      .then((response: any) => {
        console.log(response.data);
        setCardList(response.data['responseData']);
      })
      .catch((e: Error) => {
        console.log(e);
      });
    //$.get(urlGetAll, response => setCardList(response));
  }, []);

  const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setCreditCardModal(() => ({ ...creditCardModal, [name]: value }));
  }

  const validateForm = () => {
    const nameRgx = /^[^0-9.]+$/;
    const limitRgx = /^[0-9]+$/;
    let errors = {userNameError: true, cardNumberError: true, cardLimitError: true};
    if (nameRgx.test(creditCardModal.userName)){
      errors.userNameError = false;
    }
    if (checkCardNumber(creditCardModal.cardNumber, 16, 19) && checkLuhn10Number(creditCardModal.cardNumber)){
      errors.cardNumberError = false;
    }
    if (limitRgx.test(String(creditCardModal.cardLimit)) && creditCardModal.cardLimit > 0) {
      errors.cardLimitError = false;
    }
    setValidationErrors(errors);
    return !Object.values(errors).some(error => error === true);
  }

  const addCreditCard = () => {
    if(validateForm()){
      console.log("form is valid");
      CcpService.create(creditCardModal)
      .then((response: any) => {
        console.log(response.data);
        if(response.data['responseStatus'] == 'success'){
          setCreditCardModal({userName: '', cardNumber: '', cardLimit: 0});
          setCardList([...cardList, {...creditCardModal, balance: 1}]);
        } else if(response.data['responseStatus'] == 'error') {
          setValidationErrors(response['validationErrors']);
        } else {
          alert("server error, please try again later! or check with support!");
        }
      })
      .catch((e: Error) => {
        console.log(e);
      });
    }
  }

  return (
    <div className="container-fluid">
      <header className="App-header">
        <h2>Credit Card Processing Application</h2>
      </header>

      <AddCreditCard card={creditCardModal} error={validationErrors} handleChange={handleChange} addCreditCard={addCreditCard}/>
      <header className="mt-2 alert alert-info p-1 lh-sm" style={{fontSize: '17px'}} >
        Existing Credit Cards
      </header>
      <ListCard cardList={cardList}/>
    </div>
  );
}

export default App;
