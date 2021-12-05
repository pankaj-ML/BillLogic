package BillLogic.Models

class Bill
{
    var city : String? = null
    var Amount : Float? = null
    var commission: Float? =null
    var TotalPay: Float? = null

    constructor(city: String?, Amount: Float?, commission: Float?, TotalPay: Float?) {
        this.city = city
        this.Amount = Amount
        this.commission = commission
        this.TotalPay = TotalPay
    }

    constructor()
}