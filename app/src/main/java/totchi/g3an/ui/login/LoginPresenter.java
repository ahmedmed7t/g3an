package totchi.g3an.ui.login;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.login.LoginResponse;
import totchi.g3an.data.remote.model.login.loginBody;
import totchi.g3an.ui.base.BasePresenter;
import totchi.g3an.ui.basket.foodBasketActivity;

/**
 * Created by CrazyNet on 28/08/2018.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    DataManager dataManager;

    @Inject
    public LoginPresenter(DataManager dataManager){this.dataManager=dataManager;}

    public void login(loginBody body)
    {
        dataManager.login(body).subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getMvpView().showProgress();
                    }

                    @Override
                    public void onSuccess(LoginResponse body) {
                        getMvpView().hideProgress();
                        if(body.isStatus())
                        {
                            foodBasketActivity.userID = body.getId();
                            getMvpView().toHome();
                        }else{
                            getMvpView().onInvalidData();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().hideProgress();
                        getMvpView().onInvalidData();

                    }
                });
    }

}
