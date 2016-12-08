package info.juanmendez.md.materialdesigncompat;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    TextInputLayout inputLayoutUsername, inputLayoutPassword;

    @ViewById
    EditText etUsername, etPassword;

    @AfterViews
    void afterViews() {
        this.setSupportActionBar(toolbar);
    }


    @Click(R.id.btnLogin)
    void onBtnLoginClick() {

        if (validateName() && validatePassword()) {
            Toast.makeText(this, "Succesfully Logged In!", Toast.LENGTH_LONG).show();
        }
    }


    boolean validateName() {

        if (!etUsername.getText().toString().isEmpty()) {
            inputLayoutUsername.setErrorEnabled(false);
            return true;
        } else {
            inputLayoutUsername.setError("Username is required");
        }

        return false;
    }

    boolean validatePassword() {

        String pwd = etPassword.getText().toString().trim();

        if (pwd.length() >= 8) {
            inputLayoutPassword.setErrorEnabled(false);
            return true;
        } else {
            inputLayoutPassword.setError("Minimum 8 characters required");
        }

        return false;
    }
}
