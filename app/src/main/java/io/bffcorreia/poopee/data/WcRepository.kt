package io.bffcorreia.poopee.data

import io.bffcorreia.poopee.data.model.Review
import io.bffcorreia.poopee.data.model.Wc
import rx.Observable
import java.util.ArrayList
import java.util.Date
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
    val arr4 = ArrayList<Review>()
    arr1.add(bestReview)
    arr2.add(bestReview)
    arr2.add(normalReview)
    arr3.add(badReview)
    arr4.add(bestReview)
    arr4.add(badReview)
    wcs.add(Wc(Date(), Date(), "-", "Pav. de Portugal 1", 0.0f, imageSrc, 4f, 3f, 4f, 2f,
        arr1))
    wcs.add(Wc(Date(), Date(), "-", "Pav. de Portugal 2", 0.0f, imageSrc, 4f, 4f, 4f, 2f,
        arr2))
    wcs.add(Wc(Date(), Date(), "1234", "Pav. de Portugal VIP", 1.5f, imageSrc, 5f, 5f, 5f, 5f,
        arr3))
    wcs.add(Wc(Date(), Date(), "1234", "Golden Throne", 10.0f, "http://img.timeinc.net/time/2010/10_toilets/gold.jpg", 5f, 5f, 5f, 5f,
        arr4))
    wcs.add(Wc(Date(), Date(), "1234", "Modern Toilet icon", 1.0f, "https://www.theinteriorgallery.com/prod_images_blowup/modern-toilet-zain-2.jpg", 5f, 5f, 5f, 5f,
        arr4))
    return wcs
  }
}