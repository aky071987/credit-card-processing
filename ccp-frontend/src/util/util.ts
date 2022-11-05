export const checkCardNumber = (cardNumber: any, minLength = 16, maxLength = 19) : boolean => {
    const number = cardNumber.replace(/ /g,'').replace(/-/g,'');
    return number.length >= minLength && number.length <= maxLength;
}

export const checkLuhn10Number = (number: string) => {
    let sum = 0;
    for (let i=0; i<number.length; i++){
      let digit = Number(number.charAt(i));
      if (i % 2 === 0) {
        digit *= 2;
        if (digit > 9)
          digit -= 9;
      }
      sum += digit;
    }
    return (sum % 10) === 0;
}