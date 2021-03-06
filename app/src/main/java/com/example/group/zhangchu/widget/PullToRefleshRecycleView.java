package com.example.group.zhangchu.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by kongalong on 2016/12/13.
 */


public class PullToRefleshRecycleView extends PullToRefreshBase<RecyclerView> {

    public PullToRefleshRecycleView(Context context) {
        super(context);
    }

    public PullToRefleshRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefleshRecycleView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefleshRecycleView(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    //重写4个方法
    //1 滑动方向
    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    //重写4个方法
    //2  滑动的View
    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView view = new RecyclerView(context, attrs);
        return view;
    }

    //重写4个方法
    //3 是否滑动到底部
    @Override
    protected boolean isReadyForPullEnd() {
        View view = getRefreshableView().getChildAt(getRefreshableView()
                .getChildCount() - 1);
        if (null != view) {
            //Log.d("flag", "isReadyForPullEnd: " + (getRefreshableView().getBottom() >= view.getBottom()));
            return getRefreshableView().getBottom() >= view.getBottom();
        }
        //Log.d("flag", "isReadyForPullEnd: " + false);

        return false;
    }

    //重写4个方法
    //4 是否滑动到顶部
    @Override
    protected boolean isReadyForPullStart() {
        View view = getRefreshableView().getChildAt(0);

        if (view != null) {
            return view.getTop() >= getRefreshableView().getTop();
        }
        return false;
    }

}

