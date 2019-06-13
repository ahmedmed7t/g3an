package totchi.g3an.ui.signup.user;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import totchi.g3an.R;
import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.ui.login.LoginActivity;
import totchi.g3an.ui.signup.chief.ChiefRigesterActivity;
import totchi.g3an.utils.Utils;

public class SignupActivity extends BaseActivity implements SignUpView {
    @BindView(R.id.capture_image_iv)
    CircleImageView capture_image_iv;
    @BindView(R.id.user_name_et)
    EditText user_name_et;
    @BindView(R.id.user_mail_et)
    EditText user_mail_et;
    @BindView(R.id.user_pass_et)
    EditText user_pass_et;
    @BindView(R.id.user_conf_pass_et)
    EditText user_conf_pass_et;
    @BindView(R.id.user_rd)
    RadioButton user_rd;
    @BindView(R.id.chief_rb)
    RadioButton chief_rb;
    @BindView(R.id.sign_in_bt)
    Button signUp;
    @BindView(R.id.next_bt)
    Button next;
    @BindView(R.id.choose_group)
    RadioGroup radioGroup;

    com.facebook.login.LoginManager fbLoginManager;
    CallbackManager callbackManager;
    SignupBody signupBody;
    @Inject
    SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        activityComponent().inject(this);
        presenter.attachView(this);

        signupBody = new SignupBody();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.chief_rb: {
                        next.setVisibility(View.VISIBLE);
                        signUp.setVisibility(View.INVISIBLE);
                        signupBody.setType("3");

                    }
                    break;
                    case R.id.user_rd: {
                        next.setVisibility(View.GONE);
                        signUp.setVisibility(View.VISIBLE);
                        signupBody.setType("2");
                    }
                }
            }
        });
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        Account[] accounts = new Account[0];
        accounts = AccountManager.get(this).getAccounts();

        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                String possibleEmail = account.name;
                user_mail_et.setText(possibleEmail);
            }
        }

        fbLoginManager = com.facebook.login.LoginManager.getInstance();
        callbackManager = CallbackManager.Factory.create();
        fbLoginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginResult.getAccessToken().getToken();

                // here write code When Login successfully
//                socialBody = new SocialBody();
//                socialBody.setType(AppConstants.LoginTypes.facebook);
//                socialBody.setToken(loginResult.getAccessToken().getToken());
//                socialBody.setAppId(AppConstants.APP_ID);
//                showProgress();
//                mPresenter.authUserWithSocialMedia(socialBody);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {
                // here write code when get error
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.sign_in_tv, R.id.fb_image})
    void signUpWithFb() {
        fbLoginManager.logInWithReadPermissions(SignupActivity.this,
                Arrays.asList("email", "public_profile"));
    }

    @OnClick({R.id.sign_in_bt, R.id.next_bt})
    void sign() {
        String emil = user_mail_et.getText().toString();
        String name = user_name_et.getText().toString();
        String password = user_pass_et.getText().toString();
        String confirmationPass = user_conf_pass_et.getText().toString();


        signupBody.setEmail(emil);
        signupBody.setFirstName(name);
        signupBody.setPassword(password);
        signupBody.setConfirmPass(confirmationPass);
        signupBody.setMACaddress(Utils.getMAcAddress());
        presenter.validUser(signupBody);
    }


    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void connectionError() {

    }

    @Override
    public void showPorgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSignUpSucess(User user) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onSignUpFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataValid(SignupBody body) {
        if (body.getType().equals("2"))
            presenter.signup(body);
        else
            startActivity(new Intent(this, ChiefRigesterActivity.class).putExtra("SignUP", body));
    }

    @Override
    public void onInvalidEmail() {
        user_mail_et.setError(getString(R.string.invalidmail));
    }


    @Override
    public void onInValidName() {
        user_name_et.setError(getString(R.string.invalidname));
    }

    @Override
    public void onInValidPass() {
        user_pass_et.setError(getString(R.string.invalidpass));

    }

    @Override
    public void onInValidConfPass() {
        user_conf_pass_et.setError(getString(R.string.invalidpass));
    }

}
