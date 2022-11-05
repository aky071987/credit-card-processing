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

// valid numbers (16) : 2163967657234273, 0085118709679524
// valid numbers (17) : 75196307901855697, 19770618179789232
// valid numbers (18) : 240316437483346735, 552007848833803229
// valid numbers (19) : 2868591358136231565, 1304704207068365084