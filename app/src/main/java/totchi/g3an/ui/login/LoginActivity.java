package totchi.g3an.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import totchi.g3an.R;
import totchi.g3an.data.remote.model.login.loginBody;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.ui.forgetpass.ForgetPassActivity;
import totchi.g3an.ui.main.HomeActivity;
import totchi.g3an.ui.signup.user.SignupActivity;

public class LoginActivity extends BaseActivity implements LoginView{
    @BindView(R.id.user_mail_et)
    EditText user_mail_et;

    @BindView(R.id.user_pass_et)
    EditText user_pass_et;

    @BindView(R.id.create_account_tv)
    TextView createAccount;

    @BindView(R.id.forget_pass_text)
    TextView forgetPass;

    @Inject
    LoginPresenter presenter ;

    loginBody l_Body ;

    public int index ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        activityComponent().inject(this);



        presenter.attachView(this);



    }

    @OnClick({R.id.sign_fb_tv, R.id.imageView})
    void faceBookLogin() {

    }

    @OnClick(R.id.create_account_tv)
    void openSinUp() {
        startActivity(new Intent(this, SignupActivity.class));
    }

    @OnClick(R.id.log_in_bt)
    void openHome() {
       // loginBody l = getUserData();
        getUserData();
       // presenter.login(l_Body);
        toHome();
    }

    public void getUserData(){
        l_Body = new loginBody();
        l_Body.setEmail(user_mail_et.getText().toString());
        l_Body.setPassword(user_pass_et.getText().toString());

    }

    @OnClick(R.id.forget_pass_text)
    void openForget() {
        startActivity(new Intent(this, ForgetPassActivity.class));
    }

    @Override
    public void onInvalidEmail() {
        user_mail_et.setError("Please, enter a valid email");
    }

    @Override
    public void onInvalidPassword() {
        user_pass_et.setError("Please, enter a valid password");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void toHome() {
        try {
            index = Integer.parseInt(user_mail_et.getText().toString());
        }catch (NumberFormatException ex){}

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("i",index);
        startActivity(i);
    }

    @Override
    public void onInvalidData() {
        user_pass_et.setText("");
        Toast.makeText(this,"Incorrect Email or Password ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void connectionError() {

    }
}
