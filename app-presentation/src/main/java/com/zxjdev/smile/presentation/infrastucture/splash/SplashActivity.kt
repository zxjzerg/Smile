@file:Suppress("unused")

package com.zxjdev.smile.presentation.infrastucture.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.animation.*
import com.zxjdev.smile.R
import com.zxjdev.smile.presentation.authorization.login.LoginActivity
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity
import com.zxjdev.smile.presentation.common.base.activity.BaseActivity
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

/**
 * 开屏界面
 */
class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject internal lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initUi()

        presenter.takeView(this)
        presenter.handleAutoLogin()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    private fun initUi() {
        // 设置自定义的字体
        val customFont = Typeface.createFromAsset(this.assets, "fonts/AaPangYaer.ttf")
        btn_login.typeface = customFont
        btn_register.typeface = customFont
        btn_login.setOnClickListener({ navigateToLogin() })
        btn_register.setOnClickListener({ navigateToRegister() })
    }

    private fun navigateToLogin() {
        val login = Intent(context, LoginActivity::class.java)
        startActivity(login)
    }

    private fun navigateToRegister() {
        val login = Intent(context, RegisterActivity::class.java)
        startActivity(login)
    }

    override fun navigateToMain() {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun showButtons() {
        layout_button_container.visibility = View.VISIBLE

        // doButtonsViewAnimationFromRes();
        layout_button_container.post { this.doButtonsPropertyAnimationFromCode() }
        // buttonContainer.post(this::doButtonsViewAnimationFromCode);
    }

    /**
     * 通过代码实现属性动画
     */
    private fun doButtonsPropertyAnimationFromCode() {
        val btnLoginStartPosition = layout_button_container.x + layout_button_container.measuredWidth
        val btnLoginEndPosition = btn_login.x

        val btnLoginPosition = ObjectAnimator.ofFloat(btn_login, "x", btnLoginStartPosition, btnLoginEndPosition)
        btnLoginPosition.duration = 3000

        val btnLoginRotation = ObjectAnimator.ofFloat(btn_login, "rotation", 0.toFloat(), (-360).toFloat())
        btnLoginRotation.duration = 3000

        val btnRegisterStartPosition = layout_button_container.x - btn_register.measuredWidth
        val btnRegisterEndPosition = btn_register.x
        val btnRegisterPosition = ObjectAnimator.ofFloat(btn_register,
                "x",
                btnRegisterStartPosition,
                btnRegisterEndPosition)
        btnRegisterPosition.duration = 3000

        val btnRegisterRotation = ObjectAnimator.ofFloat(btn_register, "rotation", 0.toFloat(), 360.toFloat())
        btnRegisterRotation.duration = 3000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(btnRegisterPosition, btnRegisterRotation, btnLoginPosition, btnLoginRotation)
        animatorSet.start()
    }

    /**
     * 通过代码实现View动画，按钮起始位置和结束位置是精确的
     */
    private fun doButtonsViewAnimationFromCode() {
        val btnLoginStartPosition = -(btn_login.x + btn_login.width)
        val btnLoginEndPosition = 0f

        val btnLoginTranslate = TranslateAnimation(Animation.ABSOLUTE,
                btnLoginStartPosition,
                Animation.ABSOLUTE,
                btnLoginEndPosition,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f)

        val btnLoginRotate = RotateAnimation(0f,
                360f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f)

        val btnLoginAnimation = AnimationSet(true)
        btnLoginAnimation.addAnimation(btnLoginRotate)
        btnLoginAnimation.addAnimation(btnLoginTranslate)
        btnLoginAnimation.duration = 3000

        btn_login.startAnimation(btnLoginAnimation)

        val btnRegisterStartPosition = layout_button_container.width - btn_register.x
        val btnRegisterEndPosition = 0f

        val btnRegisterTranslate = TranslateAnimation(Animation.ABSOLUTE,
                btnRegisterStartPosition,
                Animation.ABSOLUTE,
                btnRegisterEndPosition,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f)

        val btnRegisterRotate = RotateAnimation(0f,
                -360f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f)

        val btnRegisterAnimation = AnimationSet(true)
        btnRegisterAnimation.addAnimation(btnRegisterRotate)
        btnRegisterAnimation.addAnimation(btnRegisterTranslate)
        btnRegisterAnimation.duration = 3000

        btn_register.startAnimation(btnRegisterAnimation)
    }

    /**
     * 通过XML Resource实现View动画，按钮起始位置和结束位置是不精确的
     */
    private fun doButtonsViewAnimationFromRes() {
        val animRollInFromLeft = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_roll_in_from_left)
        val animRollInFromRight = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_roll_in_from_right)
        btn_register.startAnimation(animRollInFromRight)
        btn_login.startAnimation(animRollInFromLeft)
    }
}
