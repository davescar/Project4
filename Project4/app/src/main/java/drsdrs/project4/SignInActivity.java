package drsdrs.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;
import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.Spotify;
import com.spotify.sdk.android.player.SpotifyPlayer;
import com.spotify.sdk.android.player.Error;
import com.spotify.sdk.android.player.PlayerEvent;


import drsdrs.project4.onboarding.OnBoardingActivity;


public class SignInActivity extends Activity implements
        SpotifyPlayer.NotificationCallback, ConnectionStateCallback {

    // TODO: Replace with your client ID
    private static final String CLIENT_ID = "a2882012f2694315bc10b9dee32ee679";
    // TODO: Replace with your redirect URI
    private static final String REDIRECT_URI = "https://github.com/davescar";

    private Player mPlayer;
    private static final int REQUEST_CODE = 6054;
    private Button mLoginButton;
    public static final String ACCESS_TOKEN_KEY = "asdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(CLIENT_ID,
                AuthenticationResponse.Type.TOKEN,
                REDIRECT_URI);
        builder.setScopes(new String[]{"user-read-private", "streaming"});
        final AuthenticationRequest request = builder.build();


        //Find Login Button. Set OnClickListener
        mLoginButton = (Button) findViewById(R.id.login_to_spotify);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthenticationClient.openLoginActivity(SignInActivity.this, REQUEST_CODE, request);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);
            if (response.getType() == AuthenticationResponse.Type.TOKEN) {

                String accessToken = response.getAccessToken();
                UserSingleton.getInstance().setAuthToken(accessToken);

                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.putExtra(ACCESS_TOKEN_KEY, accessToken);
                startActivity(intent1);

                finish();



//                Config playerConfig = new Config(this, response.getAccessToken(), CLIENT_ID);
//                Spotify.getPlayer(playerConfig, this, new SpotifyPlayer.InitializationObserver() {
//                    @Override
//                    public void onInitialized(SpotifyPlayer spotifyPlayer) {
//                        mPlayer = spotifyPlayer;
//                        mPlayer.addConnectionStateCallback(SignInActivity.this);
//                        mPlayer.addNotificationCallback(SignInActivity.this);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        Log.e("SignInActivity", "Could not initialize player: " + throwable.getMessage());
//                    }
//                });

            }
        }
    }

    @Override
    protected void onDestroy() {
        Spotify.destroyPlayer(this);
        super.onDestroy();
    }

    @Override
    public void onPlaybackEvent(PlayerEvent playerEvent) {
        Log.d("SignInActivity", "Playback event received: " + playerEvent.name());
        switch (playerEvent) {
            // Handle event type as necessary
            default:
                break;
        }
    }

    @Override
    public void onPlaybackError(Error error) {
        Log.d("SignInActivity", "Playback error received: " + error.name());
        switch (error) {
            // Handle error type as necessary
            default:
                break;
        }
    }

    @Override
    public void onLoggedIn() {
        Log.d("SignInActivity", "User logged in");

        mPlayer.playUri(null, "spotify:track:2TpxZ7JUBn3uw46aR7qd6V", 0, 0);
    }

    @Override
    public void onLoggedOut() {
        Log.d("SignInActivity", "User logged out");
    }

    @Override
    public void onLoginFailed(Error error) {

    }

    @Override
    public void onTemporaryError() {
        Log.d("SignInActivity", "Temporary error occurred");
    }

    @Override
    public void onConnectionMessage(String message) {
        Log.d("SignInActivity", "Received connection message: " + message);
    }
}


