/*
 * Copyright 2015.  Emin Yahyayev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ewintory.udacity.popularmovies.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ewintory.udacity.popularmovies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @attr ref android.R.styleable#AnimatorStateView_messageText
 * @attr ref android.R.styleable#AnimatorStateView_messageImage
 */
public final class AnimatorStateView extends LinearLayout {

    @BindView(R.id.message_view_text) TextView mTextView;
    @BindView(R.id.message_view_image) ImageView mImageView;

    private View mRoot;

    private AnimatorStateView(Context context) {
        super(context, null, 0);
        initialize(context, null, 0);
    }

    public AnimatorStateView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        initialize(context, attrs, 0);
    }

    private AnimatorStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyle) {
        mRoot = LayoutInflater.from(context).inflate(R.layout.widget_animator_state, this, true);
        ButterKnife.bind(this, mRoot);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimatorStateView, defStyle, 0);

        String text = a.getString(R.styleable.AnimatorStateView_messageText);
        Drawable image = a.getDrawable(R.styleable.AnimatorStateView_messageImage);

        mTextView.setText(text);
        mImageView.setImageDrawable(image);

        a.recycle();
    }

    public void setMessageText(CharSequence text) {
        mTextView.setText(text);
    }

    public void setMessageImage(Drawable drawable) {
        mImageView.setImageDrawable(drawable);
    }
}
