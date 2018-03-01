package com.zxjdev.smile.presentation.moment.list

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment
import com.zxjdev.smile.presentation.moment.MomentModel
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter
import javax.inject.Inject

class MomentListFragment : BaseFragment(), MomentListContract.View {

    @BindView(R.id.rv_moments) internal lateinit var rvMoments: RecyclerView
    @BindView(R.id.fbtn_add_new_moment) internal lateinit var btnNewMoment: FloatingActionButton
    @BindView(R.id.layout_swipe) internal lateinit var layoutSwipe: SwipeRefreshLayout

    private var momentAdapter: MomentAdapter? = null
    @Inject internal lateinit var presenter: MomentListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater!!.inflate(R.layout.fragment_moments, container, false)
        ButterKnife.bind(this, view)
        initUi()
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.takeView(this)
        if (savedInstanceState == null) {
            presenter.loadMoments()
        } else {
            presenter.loadSavedInstanceState(savedInstanceState)
        }
    }

    private fun initUi() {
        rvMoments.layoutManager = LinearLayoutManager(activity)
        momentAdapter = MomentAdapter(super.imageLoader)
        rvMoments.adapter = momentAdapter

        layoutSwipe.setColorSchemeResources(R.color.colorAccent)
        layoutSwipe.setOnRefreshListener { presenter.refreshMoments() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        presenter.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    @OnClick(R.id.fbtn_add_new_moment)
    fun addNewMomentClick() {
        val addMoment = Intent(activity, NewMomentActivity::class.java)
        startActivity(addMoment)
    }

    override fun displayMomentList(momentModels: List<MomentModel>) {
        momentAdapter!!.setMoments(momentModels)
    }

    override fun dismissRefreshingView() {
        layoutSwipe.isRefreshing = false
    }

    companion object {

        val TAG = MomentListFragment::class.java.simpleName
    }
}
