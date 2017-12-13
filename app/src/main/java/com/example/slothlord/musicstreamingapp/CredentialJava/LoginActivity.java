package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slothlord.musicstreamingapp.MediaPlayer.MediaPlayerActivity;
import com.example.slothlord.musicstreamingapp.NewsfeedJava.NewsFeedActivity;
import com.example.slothlord.musicstreamingapp.NewsfeedJava.NewsFeedController;
import com.example.slothlord.musicstreamingapp.R;
import com.example.slothlord.musicstreamingapp.RadioStationJava.RadioStationsActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Context context = this;
        final EditText email_input = (EditText) findViewById(R.id.email_input);
        final EditText password_input = (EditText) findViewById(R.id.password_input);

        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /** Check the input fields and make sure they are filled. Then send to the controller.
                String email = email_input.getText().toString();
                String password = password_input.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    LoginController controller = new LoginController(context);
                    System.out.println("Email: " + email + "\tPassword: " + password);
                    controller.checkCredentials(email, password);

                } else {
                    Toast.makeText(getApplicationContext(), "Fill all input areas", Toast.LENGTH_SHORT).show();
                }
                **/
            }

        });

        Button signup = (Button) findViewById(R.id.signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent iSignup = new Intent(context, SignupActivity.class);

                /** Testing. Remove when done. **/
                NewsFeedController controller = new NewsFeedController(context);
                controller.retrieveNews();

//                Intent iSignup = new Intent(context, RadioStationsActivity.class);
                Intent iSignup = new Intent(context, NewsFeedActivity.class);
                startActivity(iSignup);
            }
        });
    }
}
