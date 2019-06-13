package totchi.g3an.ui.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.login.LoginResponse;
import totchi.g3an.data.remote.model.showAllPosts.post;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by Medhat on 02/09/2018.
 */

public class homeFragmentPresenter extends BasePresenter<HomeFragment> {

    DataManager dataManager;

    HomeFragment homeFragment;


    @Inject
    public homeFragmentPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void fetchPosts()
    {
        dataManager.showAllPosts().subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new SingleObserver<GenralResponse<ArrayList<post>>>(){


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(GenralResponse<ArrayList<post>> arrayListGenralResponse) {
                        ArrayList<post> arr = arrayListGenralResponse.getData();
                        homeFragment.fillArray(arr);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
}

}