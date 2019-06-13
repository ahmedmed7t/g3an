package totchi.g3an.ui.chiefPost;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.showChiefProfile.chiefPost;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by CrazyNet on 02/10/2018.
 */

public class chiefPostPresenter extends BasePresenter<chiefPostView> {

    DataManager dataManager;

    @Inject
    public chiefPostPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void getPosts(){

        dataManager.showChiefProfile(1).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GenralResponse<ArrayList<chiefPost>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(GenralResponse<ArrayList<chiefPost>> arrayListGenralResponse) {

                        getImages(arrayListGenralResponse.getData());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void getImages(ArrayList<chiefPost> arrayList)
    {
        ArrayList<Integer> Images = new ArrayList<Integer>();

        int size = arrayList.size();

        for(int i=0;i<size;i++)
        {
            Images.add(arrayList.get(i).getPlateImage());
        }

        getMvpView().getImages(Images);
    }
}
