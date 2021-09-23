package com.iet.ietians_diary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    SignInButton signInButton ;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // [START config_signin]
        // Configure Google Sign In
        setContentView(R.layout.activity_sign_in);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // [END config_signin]

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signInButton = findViewById(R.id.signIn);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        // [END initialize_auth]
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null)
        {
            updateUI(currentUser);
        }
    }
    // [END on_start_check_user]

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]

    private void updateUI(FirebaseUser user) {

        //TODO Intent After Login
            Intent intent = new Intent(SignIn.this, Dashboard.class);
            startActivity(intent);
            finish();
    }

}










////
////    private static String TAG = "SIGNIN";
////    private SignInButton signInButton ;
////    private GoogleSignInClient mGoogleSignInClient;
////    private static  final int RC = 1;
////    String name, email;
////    String token;
////    private FirebaseAuth firebaseAuth;
////    private FirebaseAuth.AuthStateListener authStateListener;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        //FirebaseApp.initializeApp(this);
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_sign_in);
////        //FirebaseApp.initializeApp(this);
////
////        authStateListener = new FirebaseAuth.AuthStateListener() {
////            @Override
////            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
////                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
////
////                if (firebaseUser!=null){
////                    //TODO CONTINUE TO ANOTHER ACTIVITY / REDIRECT TO DASHBOARD
////
////                }else{
////
////                }
////            }
////        };
////
////        //IF USER IS NOT LOGGED IN / OR FIRST TIME LOGIN
////        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
////                .requestIdToken(getString(R.string.default_web_client_id))
////                .requestEmail()
////                .build();
////
////        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
////       // firebaseAuth = FirebaseAuth.getInstance();
////        signInButton= findViewById(R.id.signIn);
////        signInButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent= mGoogleSignInClient.getSignInIntent();
////                startActivityForResult(intent, RC);
////
////
////            }
////        });
////
////
////
////
////
////
////    }
////    @Override
////    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
////
////    }
////
////    @Override
////    public void onPointerCaptureChanged(boolean hasCapture) {
////
////    }
////
////
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////
////        if (requestCode == RC) {
////            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
////            handleSignInResult(result);
////
////        }
////    }
////    private void handleSignInResult(GoogleSignInResult result){
////        if ( result.isSuccess()){
////            GoogleSignInAccount account = result.getSignInAccount();
////            token = account.getIdToken();
////            GoogleSignInAccount googleSignInAccount= result.getSignInAccount();
////            AuthCredential authCredential = GoogleAuthProvider.getCredential(token,null);
////            finalAuthentication(authCredential);
////
////        }else{
////            Toast.makeText(getApplicationContext(), "Cannot Login", Toast.LENGTH_SHORT).show();
////        }
////
////    }
////    private void finalAuthentication(AuthCredential credentials){
////        firebaseAuth.signInWithCredential(credentials).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(getApplicationContext(), "LoggedIn", Toast.LENGTH_SHORT).show();
//
//                    //TODO MAKE INTENT HERE
//
//                }else{
//                    Toast.makeText(SignIn.this, "Login Failed "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
// /*   @Override
//    protected void onStart() {
//        super.onStart();
//        if (authStateListener != null){
//       //     FirebaseAuth.getInstance().signOut();
//        }
////        firebaseAuth.addAuthStateListener(authStateListener);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (authStateListener != null){
//            firebaseAuth.removeAuthStateListener(authStateListener);
//        }
//    }*/
//
//}