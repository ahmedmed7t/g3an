package totchi.g3an.injection.component;


import dagger.Subcomponent;
import totchi.g3an.injection.modules.ActivityModule;
import totchi.g3an.injection.scops.PerActivity;
import totchi.g3an.ui.login.LoginActivity;
import totchi.g3an.ui.post_details.post_details;
import totchi.g3an.ui.signup.chief.ChiefRigesterActivity;
import totchi.g3an.ui.signup.user.SignupActivity;

/**
 * Created by Fatma on 03/07/2018.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SignupActivity signupActivity);

    void inject(ChiefRigesterActivity chiefRigesterActivity);

    void inject(LoginActivity LoginActivity);

    void inject(post_details post_details);
}
