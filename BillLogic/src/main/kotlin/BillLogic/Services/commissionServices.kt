package BillLogic.Services

import BillLogic.Models.commission

interface commissionServices {
    fun setCommission(commission: commission): commission
    fun UpdatByCity(city:String,commission: commission): commission
    fun showAll(): List<commission>
    fun findByCommCity(city: String?): commission?
    fun findByCity(city: String?): commission

    }
