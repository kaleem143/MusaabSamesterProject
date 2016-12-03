package com.example.musaab.musaabproject3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {
 private    CallbackManager callbackManager;
 private TextInputLayout usernamelayout,passwordlayout;
    private EditText username,password;
    private String email,userpassword;

    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    private FacebookCallback<LoginResult> mcallBack=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken=loginResult.getAccessToken();

            Profile profile=Profile.getCurrentProfile();
            Intent intent = new Intent(getActivity(),Welcome.class);
            startActivity(intent);


        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {
            Toast.makeText(getContext(), "Facebook Login error", Toast.LENGTH_SHORT).show();

        }
    };

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        callbackManager= CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

    }

    private String getPassword(Cursor c) {
        return c.getString(3);
    }

    private String getEmail(Cursor c) {
      return c.getString(2);

    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile=Profile.getCurrentProfile();

        accessTokenTracker.startTracking();
        profileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginButton facebookloginButton=(LoginButton) view.findViewById(R.id.login_button);
        Button registerbtn=(Button)view.findViewById(R.id.registerBtn);
        Button loginbtn=(Button)view.findViewById(R.id.btnlogin);
        username=(EditText)view.findViewById(R.id.input_username);
        password=(EditText)view.findViewById(R.id.input_password);
        usernamelayout=(TextInputLayout)view.findViewById(R.id.input_layout_username);
        passwordlayout=(TextInputLayout)view.findViewById(R.id.input_layout_password);
        username.addTextChangedListener(new MyTextWatcher(username));
        password.addTextChangedListener(new MyTextWatcher(password));


        facebookloginButton.setReadPermissions("user_friends");
        facebookloginButton.setFragment(this);

        facebookloginButton.registerCallback(callbackManager,mcallBack);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Register.class);
                startActivity(intent);

            }
        });



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(submitForm()){
                DBAdapter db=new DBAdapter(getActivity());
                db.open();
                Cursor c = db.getContactByEmail(username.getText().toString());
                if (c.moveToFirst())
                {
                    do {
                        email=   getEmail(c);
                        userpassword=getPassword(c);
                        Log.d("useremail",email);
                        Log.d("password",userpassword);
                    } while (c.moveToNext());
                }
                db.close();
                if(email.equals(username.getText().toString().trim()) && userpassword.equals(password.getText().toString().trim())){
                   Intent intent =new Intent(getContext(),Welcome.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                }
             }





            }
        });

    }




    private boolean submitForm() {
        if (!validateName()) {
            return false;
        }

        if (!validatePassword()) {
            return false;
        }

       return true;
    }

    private boolean validatePassword() {
        if (password.getText().toString().trim().isEmpty()) {
            passwordlayout.setError(getString(R.string.err_msg_password));
            requestFocus(password);
            return false;
        } else {
            passwordlayout.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateName() {
        if (username.getText().toString().trim().isEmpty()) {
            usernamelayout.setError(getString(R.string.err_msg_name));
            requestFocus(username);
            return false;
        } else {
            usernamelayout.setErrorEnabled(false);
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);

    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;

                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }

}
