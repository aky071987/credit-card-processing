
import { CardListProps } from "../../modal/modal";

function ListCard({cardList}: CardListProps) {

    const formatNumber = (number: any) => {
        return number.replace(/ /g,'')
                     .replace(/-/g,'')
                     .replace(/(.{4})/g,"$1 ");
    }
                     
    return(
		<>  
			{cardList.length === 0 ? (
				<div> No Cards </div>
			) : 
            (
                <table className="table">
                <thead className="thead-dark">
                  <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Card Number</th>
                    <th scope="col">Balance</th>
                    <th scope="col">Limit</th>
                  </tr>
                </thead>
                <tbody>
                  {
                    cardList.map(card =>
                      <tr key={card.cardNumber}>
                        <td> {card.userName} </td>
                        <td> {formatNumber(card.cardNumber)} </td>
                        <td> {card.balance} </td>
                        <td> {card.cardLimit} </td>
                      </tr>
                    )
                  }
                </tbody>
              </table>
			)}
		</>
	)
}

export default ListCard;