package com.lmx.generalec.ui.home;

import com.lmx.general_core.base.BasePresenter;
import com.lmx.general_core.base.BaseView;

import java.util.List;

/**
 * Author:MainC
 * Created by LMX on 2018/4/11
 * Description:
 */
public interface HomeContract {
    interface View extends BaseView {
        void showTabList(List<String> mTabs);

        void LoadHemoInfoSuccess(String js);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getTabList();

        public abstract void getHomeInfo();
    }
}
