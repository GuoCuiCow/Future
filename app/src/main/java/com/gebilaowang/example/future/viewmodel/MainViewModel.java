package com.gebilaowang.example.future.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.gebilaowang.example.future.App;

import com.gebilaowang.example.future.R;
import com.gebilaowang.example.future.model.TopNewsService;
import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.messenger.Messenger;

import me.tatarka.bindingcollectionadapter.ItemView;
import rx.Observable;

/**
 * Created by cuiguo on 2016/11/16.
 */

public class MainViewModel implements ViewModel {
    // Token to Messenger append package name to be unique
    public static final String TOKEN_UPDATE_INDICATOR = "token_update_indicator" + App.sPackageName;

    //context
    private Context context;

    // viewModel for recycler header viewPager
    public final ItemView topItemView = ItemView.of(com.gebilaowang.example.future.BR.viewModel, R.layout.main_header_viewpager);
    public final ObservableList<TopItemViewModel> topItemViewModel = new ObservableArrayList<>();
    public MainViewModel(Activity activity) {
        context=activity;
        Messenger.getDefault().register(activity, NewsViewModel.TOKEN_TOP_NEWS_FINISH, TopNewsService.News.class, (news) -> {
            Observable.just(news)
                    .doOnNext(m -> topItemViewModel.clear())
                    .flatMap(n -> Observable.from(n.getTop_stories()))
                    .doOnNext(m -> topItemViewModel.add(new TopItemViewModel(context,m)))
                    .toList()
                    .subscribe((l) -> Messenger.getDefault().sendNoMsgToTargetWithToken(TOKEN_UPDATE_INDICATOR, activity));
        });

    }
}
