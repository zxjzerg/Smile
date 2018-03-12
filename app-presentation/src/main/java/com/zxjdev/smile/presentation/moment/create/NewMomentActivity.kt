package com.zxjdev.smile.presentation.moment.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_new_moment.*
import javax.inject.Inject

class NewMomentActivity : BaseActivity(), NewMomentContract.View {

    @Inject internal lateinit var presenter: NewMomentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_moment)
        initUi()

        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_new_moment, menu)
        // Tint the icon in menu to white
        menu.findItem(R.id.action_send).icon.setTint(resources.getColor(android.R.color.white))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_send -> {
                presenter.handleAddMoment(et_content.text.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun close() {
        onBackPressed()
    }

    private fun initUi() {
        setSupportActionBar(view_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
    }
}
