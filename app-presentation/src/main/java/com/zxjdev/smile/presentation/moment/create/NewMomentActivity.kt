package com.zxjdev.smile.presentation.moment.create

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import javax.inject.Inject

class NewMomentActivity : BaseActivity(), NewMomentContract.View {

    @BindView(R.id.view_toolbar) internal lateinit var toolbar: Toolbar
    @BindView(R.id.et_content) internal lateinit var etContent: EditText

    @Inject internal lateinit var presenter: NewMomentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_moment)
        ButterKnife.bind(this)
        initUi()

        presenter!!.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.dropView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_new_moment, menu)
        // Tint the icon in menu to white
        menu.findItem(R.id.action_send).icon.setTint(resources.getColor(android.R.color.white))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_send -> {
                presenter!!.handleAddMoment(etContent!!.text.toString())
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun close() {
        onBackPressed()
    }

    private fun initUi() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = null
    }
}
