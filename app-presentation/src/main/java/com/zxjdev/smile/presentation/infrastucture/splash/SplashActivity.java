package com.zxjdev.smile.presentation.infrastucture.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.authorization.login.LoginActivity;
import com.zxjdev.smile.presentation.authorization.register.RegisterActivity;
import com.zxjdev.smile.presentation.common.base.activity.ActivityModule;
import com.zxjdev.smile.presentation.common.base.activity.DaggerActivity;
import com.zxjdev.smile.presentation.infrastucture.main.MainActivity;
import com.zxjdev.smile.presentation.infrastucture.splash.di.SplashActivityComponent;
import com.zxjdev.smile.presentation.infrastucture.splash.di.SplashActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开屏界面
 */
public class SplashActivity extends DaggerActivity implements SplashContract.View {

  @BindView(R.id.layout_button_container) View buttonContainer;
  @BindView(R.id.btn_login) Button btnLogin;
  @BindView(R.id.btn_register) Button btnRegister;

  @Inject SplashContract.Presenter presenter;

  private SplashActivityComponent splashActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash);
    ButterKnife.bind(this);

    initUi();

    presenter.handleAutoLogin();
  }

  @Override
  protected void onStart() {
    super.onStart();
    // doButtonsPropertyAnimationFromCode();
  }

  @Override
  protected void onResume() {
    super.onResume();
    // doButtonsPropertyAnimationFromCode();
  }

  @Override
  protected void initDaggerComponent() {
    splashActivityComponent = getApplicationComponent().getSplashActivityComponent(new ActivityModule(this),
      new SplashActivityModule(this));
    splashActivityComponent.inject(this);
  }

  @Override
  protected void releaseDaggerComponent() {

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
    splashActivityComponent = null;
  }

  private void initUi() {
    // 设置自定义的字体
    Typeface customFont = Typeface.createFromAsset(this.getAssets(), "fonts/AaPangYaer.ttf");
    btnLogin.setTypeface(customFont);
    btnRegister.setTypeface(customFont);
  }

  @OnClick(R.id.btn_login)
  public void loginCLick() {
    navigateToLogin();
  }

  @OnClick(R.id.btn_register)
  public void registerClick() {
    navigateToRegister();
  }

  private void navigateToLogin() {
    Intent login = new Intent(context, LoginActivity.class);
    startActivity(login);
  }

  private void navigateToRegister() {
    Intent login = new Intent(context, RegisterActivity.class);
    startActivity(login);
  }

  @Override
  public void navigateToMain() {
    Intent intent = new Intent(context, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }

  @Override
  public void showButtons() {
    buttonContainer.setVisibility(View.VISIBLE);

    doButtonsViewAnimationFromRes();
    // buttonContainer.post(this::doButtonsPropertyAnimationFromCode);
    // buttonContainer.post(this::doButtonsViewAnimationFromCode);
  }

  private void doButtonsPropertyAnimationFromCode() {
    float btnLoginStartPosition = buttonContainer.getX() + buttonContainer.getMeasuredWidth();
    float btnLoginEndPosition = btnLogin.getX();

    ObjectAnimator btnLoginPosition = ObjectAnimator.ofFloat(btnLogin, "x", btnLoginStartPosition, btnLoginEndPosition);
    btnLoginPosition.setDuration(3000);

    ObjectAnimator btnLoginRotation = ObjectAnimator.ofFloat(btnLogin, "rotation", 0, -360);
    btnLoginRotation.setDuration(3000);

    float btnRegisterStartPosition = buttonContainer.getX() - btnRegister.getMeasuredWidth();
    float btnRegisterEndPosition = btnRegister.getX();
    ObjectAnimator btnRegisterPosition = ObjectAnimator.ofFloat(btnRegister, "x", btnRegisterStartPosition,
      btnRegisterEndPosition);
    btnRegisterPosition.setDuration(3000);

    ObjectAnimator btnRegisterRotation = ObjectAnimator.ofFloat(btnRegister, "rotation", 0, 360);
    btnRegisterRotation.setDuration(3000);

    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(btnRegisterPosition, btnRegisterRotation, btnLoginPosition, btnLoginRotation);
    animatorSet.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animation) {
      }

      @Override
      public void onAnimationEnd(Animator animation) {
      }

      @Override
      public void onAnimationCancel(Animator animation) {
      }

      @Override
      public void onAnimationRepeat(Animator animation) {

      }
    });
    animatorSet.start();
  }

  private void doButtonsViewAnimationFromCode() {
    float btnLoginStartPosition = -(btnLogin.getX() + btnLogin.getWidth());
    float btnLoginEndPosition = 0;

    TranslateAnimation btnLoginTranslate = new TranslateAnimation(Animation.ABSOLUTE, btnLoginStartPosition,
      Animation.ABSOLUTE, btnLoginEndPosition, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);

    RotateAnimation btnLoginRotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
      Animation.RELATIVE_TO_SELF, 0.5f);

    AnimationSet btnLoginAnimation = new AnimationSet(true);
    btnLoginAnimation.addAnimation(btnLoginRotate);
    btnLoginAnimation.addAnimation(btnLoginTranslate);
    btnLoginAnimation.setDuration(3000);

    btnLogin.startAnimation(btnLoginAnimation);

    float btnRegisterStartPosition = buttonContainer.getWidth() - btnRegister.getX();
    float btnRegisterEndPosition = 0;

    TranslateAnimation btnRegisterTranslate = new TranslateAnimation(Animation.ABSOLUTE, btnRegisterStartPosition,
      Animation.ABSOLUTE, btnRegisterEndPosition, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);

    RotateAnimation btnRegisterRotate = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF, 0.5f,
      Animation.RELATIVE_TO_SELF, 0.5f);

    AnimationSet btnRegisterAnimation = new AnimationSet(true);
    btnRegisterAnimation.addAnimation(btnRegisterRotate);
    btnRegisterAnimation.addAnimation(btnRegisterTranslate);
    btnRegisterAnimation.setDuration(3000);

    btnRegister.startAnimation(btnRegisterAnimation);
  }

  private void doButtonsViewAnimationFromRes() {
    Animation animRollInFromLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_roll_in_from_left);
    Animation animRollInFromRight = AnimationUtils.loadAnimation(getApplicationContext(),
      R.anim.anim_roll_in_from_right);
    btnRegister.startAnimation(animRollInFromRight);
    btnLogin.startAnimation(animRollInFromLeft);
  }
}
