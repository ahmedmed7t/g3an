package totchi.g3an.ui.login;

import totchi.g3an.ui.base.BaseView;

/**
 * Created by CrazyNet on 28/08/2018.
 */

public interface LoginView extends BaseView {

  void onInvalidEmail();
  void onInvalidPassword();
  void showProgress();
  void toHome();
  void onInvalidData();
  void hideProgress();
}
