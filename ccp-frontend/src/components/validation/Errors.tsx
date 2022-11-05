import { CcValidationError } from "../../modal/modal";

function CCPErrors({userNameError, cardNumberError, cardLimitError}:CcValidationError) {
    return (
        <div className="validation-errors">
            {userNameError &&
                <div className="alert">
                    User Name field cannot be blank!
                </div>
            }
            {cardNumberError &&
                <div className="alert">
                    Card Number is not valid (should be valid as per Luhn 10 algorithm). It must be a 16 to 19 digit number!
                </div>
            }
            {cardLimitError &&
                <div className="alert">
                    Card Limit must be a valid number and greater or equeal to 0.
                </div>
            }
        </div>
    );
}

export default CCPErrors;