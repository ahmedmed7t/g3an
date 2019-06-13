package totchi.g3an.ui.main;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.showChiefs.chiefResponse;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by CrazyNet on 06/09/2018.
 */

public class searchFragmentPresenter extends BasePresenter<searchFragment> {

    DataManager dataManager;
    searchFragment fragment;

    @Inject
    public searchFragmentPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void getChiefs()
    {
        dataManager.showchief().subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GenralResponse<ArrayList<chiefResponse>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(GenralResponse<ArrayList<chiefResponse>> arrayListGenralResponse) {

                        ArrayList<chiefResponse> arrayList = arrayListGenralResponse.getData();
                        fragment.sendArrayToView(arrayList);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
