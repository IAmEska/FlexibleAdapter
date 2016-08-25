/*
 * Copyright (C) 2015 Wasabeef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.davidea.samples.flexibleadapter.animators;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

import eu.davidea.flexibleadapter.common.BaseItemAnimator;

public class SlideInLeftAnimator extends BaseItemAnimator {

	public SlideInLeftAnimator() {

	}

	public SlideInLeftAnimator(Interpolator interpolator) {
		mInterpolator = interpolator;
	}

	@Override
	protected void animateRemoveImpl(final RecyclerView.ViewHolder holder, final int index) {
		ViewCompat.animate(holder.itemView)
				.translationX(-holder.itemView.getRootView().getWidth())
				.setDuration(getRemoveDuration())
				.setInterpolator(mInterpolator)
				.setListener(new DefaultRemoveVpaListener(holder))
				.start();
	}

	@Override
	protected boolean preAnimateAddImpl(final RecyclerView.ViewHolder holder) {
		ViewCompat.setTranslationX(holder.itemView, -holder.itemView.getRootView().getWidth());
		return true;
	}

	@Override
	protected void animateAddImpl(final RecyclerView.ViewHolder holder, final int index) {
		ViewCompat.animate(holder.itemView)
				.translationX(0)
				.setDuration(getAddDuration())
				.setInterpolator(mInterpolator)
				.setListener(new DefaultAddVpaListener(holder))
				.start();
	}

}