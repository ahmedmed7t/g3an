package totchi.g3an.ui.signup.chief;

import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.ui.base.BaseView;

/**
 * Created by Fatma on 23/08/2018.
 */

public interface ChiefRegisterView extends BaseView {
    void onInValidPhone();

    void onInvalidId();

    void onInValidImage();

    void showPorgress();

    void hideProgress();

    void onSignUpSucess(User user);

    void onSignUpFailed(String error);

    void onDataValid(SignupBody body);

}
