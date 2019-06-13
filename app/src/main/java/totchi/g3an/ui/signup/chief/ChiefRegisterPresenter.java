package totchi.g3an.ui.signup.chief;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by Fatma on 23/08/2018.
 */

public class ChiefRegisterPresenter extends BasePresenter<ChiefRegisterView> {
    DataManager manager;

    @Inject
    ChiefRegisterPresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(ChiefRegisterView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    void validChief(SignupBody body) {
        if (body.getSid().equals("")) {
            getMvpView().onInvalidId();
        } else if (body.getPhone().equals("")) {
            getMvpView().onInValidPhone();
        }
//        else if (body.getImage() != null && body.getPhoto() != null) {
//            if (body.getImage().isEmpty() && body.getPhoto().isEmpty()) {
//                getMvpView().onInValidImage();
//            }
        else
            getMvpView().onDataValid(body);
    }

    void signup(SignupBody body) {
        manager.register(body).subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getMvpView().showPorgress();
                    }

                    @Override
                    public void onSuccess(User user) {
                        getMvpView().hideProgress();
                        if (user.isStatus())
                            getMvpView().onSignUpSucess(user);
                        else
                            getMvpView().onSignUpFailed(user.getError());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().hideProgress();
                        getMvpView().onSignUpFailed(e.getMessage());
                    }
                });
    }
}
