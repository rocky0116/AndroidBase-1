package com.liangzhicn.androidbasedemo.http.contract;

import com.android.base.callback.ExecutorCallBack;
import com.android.base.frame.model.impl.BaseModel;
import com.android.base.frame.presenter.impl.ActivityPresenter;
import com.android.base.frame.view.IBaseView;

/**
 * Created by Administrator on 2016/4/27.
 */
public interface GetAndPostContract {

    abstract class Model extends BaseModel {
        /**
         * Get请求
         * @param requestCallBack
         */
        public abstract void getRequest(ExecutorCallBack<String> requestCallBack);

        /**
         * POST请求
         * @param requestCallBack
         */
        public abstract void getPost(ExecutorCallBack<String> requestCallBack);

        /**
         * POST混合GET请求.两个请求都完毕时才会回调onComplete
         * 这里的泛型是因为两次请求解析出的bean不一致,所以才用Object来接收结果
         * @param requestCallBack
         */
        public abstract void getBlend(ExecutorCallBack<Object> requestCallBack);
    }

    interface View extends IBaseView {
        /**
         * 显示Get请求的数据
         * @param data
         */
        void showGet(String data);
    }

    abstract class Presenter<M extends Model> extends ActivityPresenter<M,View> {
    }

}
