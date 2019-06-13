package totchi.g3an.ui.signup.user;

import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.ui.base.BaseView;

/**
 * Created by Fatma on 22/08/2018.
 */

public interface SignUpView extends BaseView {
    void showPorgress();

    void hideProgress();

    void onSignUpSucess(User user);

    void onSignUpFailed(String error);

    void onDataValid(SignupBody body);

    void onInvalidEmail();

    void onInValidName();

    void onInValidPass();

    void onInValidConfPass();
}
