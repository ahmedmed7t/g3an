package totchi.g3an.ui.signup.chief;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import totchi.g3an.R;
import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.ui.login.LoginActivity;

public class ChiefRigesterActivity extends BaseActivity implements ChiefRegisterView {
    TelephonyManager tMgr;
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    String mPhoneNumber;
    @BindView(R.id.user_phone_et)
    EditText phoneNumber;
    @BindView(R.id.user_id_et)
    EditText id;
    SignupBody signupBody;
    @Inject
    ChiefRegisterPresenter presenter;
    @BindView(R.id.sign_up_bt)
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chief_rigester);
        //inject presenter with activity component
        activityComponent().inject(this);
        ButterKnife.bind(this);
        presenter.attachView(this);

        signupBody = getIntent().getParcelableExtra("SignUP");
        asknumberPermission();

    }

    @OnClick(R.id.sign_up_bt)
    void signUpChief() {
        signupBody.setSid(id.getText().toString());
        signupBody.setPhone(phoneNumber.getText().toString());
        presenter.validChief(signupBody);
    }

    public void asknumberPermission() {
        tMgr = (TelephonyManager) ChiefRigesterActivity.this.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_PHONE_STATE)) {

                ActivityCompat.requestPermissions(ChiefRigesterActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {

            if (tMgr.getLine1Number() != null) {
                mPhoneNumber = tMgr.getLine1Number();
                phoneNumber.setText(mPhoneNumber);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (tMgr.getLine1Number() != null) {
                        phoneNumber.setText(tMgr.getLine1Number());
                    }

                } else {
                    Toast.makeText(this, getString(R.string.noPhonePremission), Toast.LENGTH_LONG).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }

    }

    @Override
    public void onInValidPhone() {
        phoneNumber.setError(getString(R.string.invalidPhone));
    }

    @Override
    public void onInvalidId() {
        id.setError(getString(R.string.invalidID));
    }

    @Override
    public void onInValidImage() {

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
        presenter.signup(body);
    }


    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void connectionError() {

    }
}
