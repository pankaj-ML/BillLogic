package BillLogic.Controller

import BillLogic.Models.commission
import BillLogic.Repository.commissionRepo
import BillLogic.Services.commissionServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class commissionController {
    @Autowired
    private lateinit var commissionServices: commissionServices

    @PostMapping("/setcommission")
    fun setcommission(@RequestBody commission: commission): ResponseEntity<commission> {

        try {
            (commissionServices.findByCity(commission.city).city).isNullOrEmpty()
        } catch (ex: Exception) {
            return ResponseEntity.ok(commissionServices.setCommission(commission))
            throw Exception("CITY ADD")
        }

        if((commission.city)!!.equals(commissionServices.findByCity(commission.city).city))
        {
            throw Exception("City is Exist")
        }
        else
        {
            return ResponseEntity.ok(commissionServices.setCommission(commission))
        }
    }

    @PutMapping("/Update/{city}")
    fun updatByCity(@PathVariable city: String, @RequestBody commission: commission): ResponseEntity<commission> {
        if (commission.percent!! <= 5) {
            throw Exception("NOT velid")
        } else {
            return ResponseEntity.ok(commissionServices.UpdatByCity(city, commission))
        }
    }

    @GetMapping("/ShowInfo")
    fun ShowInfo(): ResponseEntity<List<commission>> {
        return ResponseEntity.ok(commissionServices.showAll())
    }

    @GetMapping("/Find/{city}")
    fun findByCity(@PathVariable city: String): ResponseEntity<commission>
    {
        return ResponseEntity.ok(commissionServices.findByCity(city))
    }
}