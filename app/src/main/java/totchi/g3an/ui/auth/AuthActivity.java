package totchi.g3an.ui.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import totchi.g3an.ui.login.LoginActivity;
import totchi.g3an.R;
import totchi.g3an.ui.signup.user.SignupActivity;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.create_account_bt)
    void openSignUp() {
        startActivity(new Intent(this, SignupActivity.class));
    }

    @OnClick(R.id.login_bt)
    void openLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
