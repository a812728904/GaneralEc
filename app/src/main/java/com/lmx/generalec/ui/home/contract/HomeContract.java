package com.lmx.generalec.ui.home.contract;

import com.lmx.general_core.base.BasePresenter;
import com.lmx.general_core.base.BaseView;

import java.util.List;

/**
 * Author:HomeContract
 * Created by LMX on 2018/4/17
 * Description:
 */
public interface HomeContract {
    interface Model {
    }

    interface View extends BaseView {
        void showTabList(List<String> mTabs);

        void LoadHemoInfoSuccess(String js);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getTabList();

        public abstract void getHomeInfo();
    }
}
