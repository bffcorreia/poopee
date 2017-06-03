package io.bffcorreia.poopee.data

import io.bffcorreia.poopee.data.model.Review
import io.bffcorreia.poopee.data.model.Wc
import rx.Observable
import java.util.*
import javax.inject.Inject

class WcRepository @Inject constructor() {

  fun getWcs(): Observable<List<Wc>> {
    return Observable.from(buildWcs()).toList()
  }

  private fun buildWcs(): List<Wc> {
    val wcs = ArrayList<Wc>()
    val bestReview = Review(5, 5, 5, 5)
    val normalReview = Review(3, 3, 4, 3)
    val badReview = Review(1, 1, 2, 1)
    val imageSrc = "http://i.imgur.com/m3AqN0N.jpg"
    val arr1 = ArrayList<Review>()
    val arr2 = ArrayList<Review>()
    val arr3 = ArrayList<Review>()
    arr1.add(bestReview)
    arr2.add(bestReview)
    arr2.add(normalReview)
    arr3.add(badReview)
    wcs.add(Wc(Date(), Date(), "-", "Pav. de Portugal 1", 0.0f, imageSrc, 5f, 5f, 5f, 5f,
        arr1))
    wcs.add(Wc(Date(), Date(), "-", "Pav. de Portugal 2", 0.0f, imageSrc, 4f, 4f, 4f, 4f,
        arr2))
    wcs.add(Wc(Date(), Date(), "1234", "Pav. de Portugal VIP", 1.5f, imageSrc, 3f, 3f, 3f, 3f,
        arr3))
    return wcs
  }
}