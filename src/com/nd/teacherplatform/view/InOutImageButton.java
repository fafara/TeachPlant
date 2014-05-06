package com.nd.teacherplatform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;

import com.nd.teacherplatform.animation.InOutAnimation;

public class InOutImageButton extends ImageButton {

	private Animation	animation;

	public InOutImageButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public InOutImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InOutImageButton(Context context) {
		super(context);
	}

	@Override
	protected void onAnimationEnd() {
		super.onAnimationEnd();
		if ((this.animation instanceof InOutAnimation)) {
			setVisibility(((InOutAnimation) this.animation).direction != InOutAnimation.Direction.OUT ? View.VISIBLE
					: View.GONE);
		}
	}

	@Override
	protected void onAnimationStart() {
		super.onAnimationStart();
		if ((this.animation instanceof InOutAnimation))
			setVisibility(View.VISIBLE);
	}

	@Override
	public void startAnimation(Animation animation) {
		super.startAnimation(animation);
		this.animation = animation;
		getRootView().postInvalidate();
	}
}