export interface CreditCardModal {
    userName: string;
    cardNumber: string;
    cardLimit: number;
}

export interface CcValidationError {
    userNameError: boolean; 
    cardNumberError: boolean;
    cardLimitError: boolean;
}

export interface AddCreditCardProps {
    card: CreditCardModal;
    error: CcValidationError;
    handleChange: (event: any) => void;
    addCreditCard: () => void;
}

export interface CardListModal extends CreditCardModal {
    balance: number;
}

export interface CardListProps {
    cardList: CardListModal[];
}