package BillLogic.Services

import BillLogic.Models.commission
import BillLogic.Repository.commissionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommissionLogic : commissionServices {

    @Autowired
    private lateinit var commissionRepo: commissionRepo

    override fun setCommission(commission: commission): commission {

            return commissionRepo.save(commission)

    }

    override fun findByCity(city: String?): commission{
        return commissionRepo.findByCity(city)!!
    }


    override fun UpdatByCity(city: String, commission: commission): commission {
        var old = this.commissionRepo.findByCity(city)
         old?.city = commission.city
         old?.percent = commission.percent
        return (this.commissionRepo.save(commission))
    }




    override fun showAll(): List<commission> {
        return commissionRepo.findAll()
    }

    override fun findByCommCity(city: String?): commission? {
        //return (city?.let { this.commissionRepo.findCommByCity(it)!!.toFloat() })
        return city?.let { this.commissionRepo.findCommByCity(it) }

    }


}