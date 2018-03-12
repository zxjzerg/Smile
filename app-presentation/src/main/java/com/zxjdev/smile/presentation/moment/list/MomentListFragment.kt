package com.zxjdev.smile.presentation.moment.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.base.fragment.BaseFragment
import com.zxjdev.smile.presentation.moment.MomentModel
import com.zxjdev.smile.presentation.moment.create.NewMomentActivity
import com.zxjdev.smile.presentation.moment.list.adapter.MomentAdapter
import kotlinx.android.synthetic.main.fragment_moments.*
import javax.inject.Inject

class MomentListFragment : BaseFragment(), MomentListContract.View {

    private lateinit var momentAdapter: MomentAdapter
    @Inject internal lateinit var presenter: MomentListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater!!.inflate(R.layout.fragment_moments, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        presenter.takeView(this)
    }

    private fun initUi() {
        rv_moments.layoutManager = LinearLayoutManager(activity)
        momentAdapter = MomentAdapter(super.imageLoader)
        rv_moments.adapter = momentAdapter

        layout_swipe.setColorSchemeResources(R.color.colorAccent)
        layout_swipe.setOnRefreshListener { presenter.refreshMoments() }

        fbtn_add_new_moment.setOnClickListener({
            val addMoment = Intent(activity, NewMomentActivity::class.java)
            startActivity(addMoment)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun displayMomentList(momentModels: List<MomentModel>?) {
        if (momentModels != null) momentAdapter.setMoments(momentModels)
    }

    override fun dismissRefreshingView() {
        layout_swipe.isRefreshing = false
    }

    companion object {

        val TAG = MomentListFragment::class.java.simpleName
    }
}
