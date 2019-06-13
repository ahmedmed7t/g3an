package totchi.g3an.ui.post_details;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.orderItem;
import totchi.g3an.data.remote.model.showPostDetails.postDetails;
import totchi.g3an.ui.base.BasePresenter;
import totchi.g3an.ui.basket.foodBasketActivity;
import totchi.g3an.ui.basket.foodBasketPresenter;

/**
 * Created by CrazyNet on 10/09/2018.
 */

public class post_detailsPresenter extends BasePresenter<post_detailsView> {

    DataManager dataManager ;

    @Inject
    public post_detailsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void getPost(int id) {
        dataManager.showPostDetails(id).subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GenralResponse<postDetails>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(GenralResponse<postDetails> postDetailsGenralResponse) {

                        getMvpView().fillorder(postDetailsGenralResponse.getData());

                    }


                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    public void addOrder(orderItem item){

        new foodBasketPresenter().addToArray(foodBasketActivity.items,item);
    }
}
