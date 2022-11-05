import { AddCreditCardProps } from "../../modal/modal";

function AddCreditCard({card, error, handleChange, addCreditCard }: AddCreditCardProps) {

    return (
        <>
        <div className="form">
            <div className="row">
                <div className="col-6">
                    <label className="form-label">Name</label>
                        {error.userNameError &&
                            <div className="alert alert-danger p-1 fs-6 lh-sm">
                                User Name field cannot be blank!
                            </div>
                        }
                    <input className="form-control" type="text" name="userName" value={card.userName} onChange={handleChange} />
                </div>
            </div>

            <div className="row">
                <div className="col-6">
                    <label className="form-label">Card Number</label>
                    {error.cardNumberError &&
                        <div className="alert alert-danger p-1 fs-6 lh-sm">
                            Card Number is not valid! should be valid as per Luhn 10 algorithm and must be a 16 to 19 digit number!
                        </div>
                    }
                    <input className="form-control" type="text" name="cardNumber" value={card.cardNumber} onChange={handleChange} />
                </div>
            </div>

            <div className="row">
                <div className="col-6">
                    <label className="form-label">Card Limit</label>
                        {error.cardLimitError &&
                            <div className="alert alert-danger p-1 fs-6 lh-sm">
                                Card Limit must be a valid number and greater than 0 !
                            </div>
                        }
                    <input className="form-control" type="number" name="cardLimit" value={card.cardLimit} onChange={handleChange} />
                </div>
            </div>

            <button className="btn btn-primary mt-4 px-4" onClick={addCreditCard}> Add </button>
        </div>
        </>
    );
}

export default AddCreditCard;