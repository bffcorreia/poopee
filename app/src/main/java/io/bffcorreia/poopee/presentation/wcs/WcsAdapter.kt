package io.bffcorreia.poopee.presentation.wcs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopees.presentation.ItemClickListener
import io.bffcorreia.poopees.presentation.bind
import io.bffcorreia.poopees.presentation.inflate
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@PerActivity class WcsAdapter
@Inject constructor(@Named("activity_context") private val context: Context)
  : RecyclerView.Adapter<WcHolder>() {

  private val events: MutableList<Wc> = mutableListOf()
  private lateinit var listener: ItemClickListener<Wc>

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WcHolder {
    return WcHolder(parent.inflate(R.layout.wc_item))
  }

  override fun onBindViewHolder(holder: WcHolder, position: Int) {
    val wc = events[position]
    holder.bind(wc, listener)
    Picasso.with(context).load(wc.photoUrl).resize(200, 200).centerInside().into(holder.photoView)
    holder.distanceView.text = Random().nextInt(500).toString() + "m"
    holder.priceView.text = wc.price.toString()
    holder.rateView.text = wc.avgRate.toString()
  }

  override fun getItemCount(): Int {
    return events.size
  }

  fun setData(data: List<Wc>) {
    events.clear()
    events.addAll(data)
    notifyDataSetChanged()
  }

  fun setListener(listener: ItemClickListener<Wc>) {
    this.listener = listener
  }
}