package BillLogic.Repository

import BillLogic.Models.commission
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface commissionRepo: MongoRepository<commission,Int>
{
    @Query(value="{'city' : ?0}")
    fun findByCity(city: String?): commission?

    @Query(value="{'city' : ?0}" , fields = "{'percent': 1}")
    fun findCommByCity(city: String):commission?
}