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
    wcs.add(Wc(Date(), Date(), "bruno", "asdfgh", 1.02f, "http://goo.gl/iWJc4m", 5f, 5f, 5f, 5f,
        Arrays.asList(bestReview)))
    wcs.add(Wc(Date(), Date(), "mario", "vladmir", 2.5f, "http://goo.gl/iWJc4m", 4f, 4f, 4f, 4f,
        Arrays.asList(bestReview, normalReview)))
    wcs.add(Wc(Date(), Date(), "andre", "niculau", 0.5f, "http://goo.gl/iWJc4m", 3f, 3f, 3f, 3f,
        Arrays.asList(badReview)))
    return wcs
  }
}