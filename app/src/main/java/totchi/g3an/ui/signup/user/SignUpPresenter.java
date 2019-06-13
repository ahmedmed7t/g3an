package totchi.g3an.ui.signup.user;

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
 * Created by Fatma on 22/08/2018.
 */

public class SignUpPresenter extends BasePresenter<SignUpView> {
    DataManager manager;

    @Inject
    SignUpPresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(SignUpView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
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

    public void validUser(SignupBody body) {
        if (body.getFirstName().equals("")) {
            getMvpView().onInValidName();
        } else if (body.getEmail().equals("")) {
            getMvpView().onInvalidEmail();
        } else if (body.getPassword().length() < 6) {
            getMvpView().onInValidPass();
        } else if (body.getConfirmPass().length() < 6) {
            getMvpView().onInValidConfPass();
        } else
            getMvpView().onDataValid(body);
    }
}
