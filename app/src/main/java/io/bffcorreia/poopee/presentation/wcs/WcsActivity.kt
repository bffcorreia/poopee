package io.bffcorreia.poopee.presentation.wcs

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopee.presentation.BaseActivity
import javax.inject.Inject

class WcsActivity(override val layoutRes: Int = R.layout.activity_wcs) : BaseActivity(),
    WcsContract.View {

  @Inject lateinit var presenter: WcsPresenter
  @Inject lateinit var adapter: WcsAdapter
  @BindView(R.id.wcs) lateinit var eventsView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    eventsView.layoutManager = LinearLayoutManager(this)
    eventsView.adapter = adapter
    adapter.setListener(presenter.wcClickListener())
    presenter.start(this)
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }

  override fun showLoadingView() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showEmptyView() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showWcs(events: List<Wc>) {
    adapter.setData(events)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.stop()
  }
}