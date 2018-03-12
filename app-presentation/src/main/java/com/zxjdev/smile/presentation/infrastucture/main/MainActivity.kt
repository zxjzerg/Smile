package com.zxjdev.smile.presentation.infrastucture.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.text.TextUtils
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.soundcloud.android.crop.Crop
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import com.zxjdev.smile.presentation.moment.list.MomentListFragment
import com.zxjdev.smile.presentation.user.UserModel
import com.zxjdev.smile.presentation.user.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    private var drawerToggle: ActionBarDrawerToggle? = null
    private var tvUsername: TextView? = null
    private var ivAvatar: ImageView? = null

    private val fragmentTags = ArrayList<String>()

    @Inject internal lateinit var presenter: MainPresenter
    private var outputUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        fragmentTags.add(MomentListFragment.TAG)
        fragmentTags.add(SettingsFragment.TAG)

        if (savedInstanceState == null) {
            showFragment(R.id.flyt_content, MomentListFragment::class.java, MomentListFragment.TAG)
            view_navigation.setCheckedItem(R.id.navi_item_moments)
        }

        presenter.takeView(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle!!.syncState()
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {

            val uri = data.data
            cropImage(uri)
        } else if (requestCode == Crop.REQUEST_CROP && resultCode == Activity.RESULT_OK) {
            presenter.handleChangeAvatar(outputUri!!.path)
        }
    }

    private fun getImagePathFromUri(uri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)

        val cursor = contentResolver.query(uri, projection, null, null, null)
        cursor!!.moveToFirst()

        val columnIndex = cursor.getColumnIndex(projection[0])
        val picturePath = cursor.getString(columnIndex)
        cursor.close()
        return picturePath
    }

    private fun cropImage(inputUri: Uri?) {
        val outputFile = File(context.cacheDir, TEMP_AVATAR_FILE_NAME)
        outputUri = Uri.fromFile(outputFile)
        Crop.of(inputUri, outputUri).asSquare().start(this)
    }

    override fun displayUser(user: UserModel) {
        if (view_navigation.headerCount <= 0) return

        val headerView = view_navigation.getHeaderView(0)
        val tvUsername = headerView.findViewById(R.id.tv_name) as TextView
        val ivAvatar = headerView.findViewById(R.id.iv_avatar) as ImageView

        tvUsername.text = user.username
        if (TextUtils.isEmpty(user.avatar)) {
            imageLoader.loadCircleImage(R.drawable.default_avatar, ivAvatar)
        } else {
            imageLoader.loadCircleImage(user.avatar, ivAvatar)
        }
        ivAvatar.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
    }

    private fun initUi() {
        drawerToggle = ActionBarDrawerToggle(this, dlyt_container, view_toolbar, R.string.open, R.string.close)

        // handle click event for showing the drawer
        view_toolbar.setNavigationOnClickListener { dlyt_container.openDrawer(Gravity.LEFT) }

        initNavigationView()
    }

    /**
     * Initialize the navigation view in the left drawer.
     */
    private fun initNavigationView() {
        view_navigation.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navi_item_moments -> showFragment(R.id.flyt_content,
                        MomentListFragment::class.java,
                        MomentListFragment.TAG)
                R.id.navi_item_settings -> showFragment(R.id.flyt_content,
                        SettingsFragment::class.java,
                        SettingsFragment.TAG)
            }
            dlyt_container.closeDrawers()
            true
        }
        if (view_navigation.headerCount > 0) {
            val headerView = view_navigation.getHeaderView(0)
            tvUsername = headerView.findViewById(R.id.tv_name) as TextView
            ivAvatar = headerView.findViewById(R.id.iv_avatar) as ImageView
        }
    }

    /**
     * Display a certain fragment.
     *
     * @param container resource id of the container
     * @param cls class of the fragment to show
     * @param tag unique tag of the fragment
     */
    private fun showFragment(@IdRes container: Int, cls: Class<out Fragment>, tag: String) {
        var isShowing = false
        val fragmentManager = super.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()

        for (fragmentTag in fragmentTags) {
            val frag = fragmentManager.findFragmentByTag(fragmentTag)
            if (frag != null && !frag.isHidden) {
                if (fragmentTag == tag) {
                    // Do nothing
                    isShowing = true
                } else {
                    fragmentTransaction.hide(frag)
                }
            }
        }

        if (!isShowing) {
            var frag: Fragment? = fragmentManager.findFragmentByTag(tag)
            if (frag != null) {
                fragmentTransaction.show(frag)
            } else {
                frag = Fragment.instantiate(context, cls.name)
                fragmentTransaction.add(container, frag, tag)
            }
        }
        fragmentTransaction.commit()
        getFragmentManager().executePendingTransactions()
    }

    companion object {

        private const val TEMP_AVATAR_FILE_NAME = "avatar.jpg"

        private const val PICK_IMAGE_REQUEST = 1
    }
}