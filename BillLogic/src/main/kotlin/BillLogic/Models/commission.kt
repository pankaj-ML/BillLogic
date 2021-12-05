package BillLogic.Models

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("CITY/Commission")
class commission {

    var percent: Float? = null

    @Indexed(unique=true)
    var city: String? = null

    constructor(percent: Float?, city: String?) {
        this.percent = percent
        this.city = city
    }
}