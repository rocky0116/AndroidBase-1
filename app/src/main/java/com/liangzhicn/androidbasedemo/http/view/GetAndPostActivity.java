package com.liangzhicn.androidbasedemo.http.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.android.base.common.assist.Toastor;
import com.android.base.frame.activity.impl.BaseMvpActivity;
import com.android.base.widget.LoadProgressLayout;
import com.liangzhicn.androidbasedemo.R;
import com.liangzhicn.androidbasedemo.http.contract.GetAndPostContract;
import com.liangzhicn.androidbasedemo.http.presenter.GetAndPostPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者: lujianzhao
 * 创建时间: 2016/06/18 14:49
 * 描述:
 */
public class GetAndPostActivity extends BaseMvpActivity<GetAndPostContract.Presenter,GetAndPostContract.View> implements GetAndPostContract.View{

    @Bind(R.id.tv_content)
    TextView mContent;

    @Bind(R.id.progress_layout)
    LoadProgressLayout mProgressLayout;


    @NonNull
    @Override
    protected GetAndPostContract.Presenter getMvpPresenter() {
        return new GetAndPostPresenter();
    }

    @NonNull
    @Override
    protected GetAndPostContract.View getMvpView() {
        return  this;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_get_post;
    }

    @Override
    protected void initView() {
    }

    /**
     * 请求错误的时候重试界面的点击按钮
     * @param view
     */
    @OnClick(R.id.btnTryAgain)
    public void onTryAgain(View view) {
        Toastor.showToast(this,"重试");
    }


    @Override
    public void showLoadingView() {
        mProgressLayout.showLoadingView();
    }

    @Override
    public void showEmptyView() {
        mProgressLayout.showEmptyView();
    }

    @Override
    public void showErrorView() {
        mProgressLayout.showErrorView();
    }

    @Override
    public void showContentView() {
        mProgressLayout.showContentView();
    }

    @Override
    public void showGet(String data) {
        mContent.setText(mContent.getText().toString()+"\r\n\r\n"+data);
    }
}
