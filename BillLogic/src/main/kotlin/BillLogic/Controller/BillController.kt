package BillLogic.Controller

import BillLogic.DTO.BilliNDTO
import BillLogic.Models.Bill
import BillLogic.Models.commission
import BillLogic.Services.commissionServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BillController
{

    @Autowired
    private lateinit var commissionServices: commissionServices

//    @PostMapping("/f/{city}")
//    fun find(@PathVariable city: String): Float?
//    {
//        return commissionServices.findByCommCity(city)?.percent
//    }

    @PostMapping("/Bill")
    fun makeBill(@RequestBody billiNDTO: BilliNDTO): ResponseEntity<Bill>
    {
        var bill = Bill()
        bill.city = billiNDTO.city
        bill.Amount=billiNDTO.Amount
        bill.commission= (commissionServices.findByCommCity(billiNDTO.city)?.percent) as Float
        // amount to pay = percent/100 x Bill Amount
        bill.TotalPay= ((commissionServices.findByCommCity(billiNDTO.city)?.percent) as Float) / 100 * billiNDTO.Amount!!
        return ResponseEntity.ok(bill)
    }
}