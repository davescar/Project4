package drsdrs.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.UserPrivate;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String mAccessToken;
    private UserPrivate mMe;
    private Button mJoinButton;
    private Button mStartNewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccessToken = getIntent().getStringExtra(SignInActivity.ACCESS_TOKEN_KEY);

        SpotifyApi api = new SpotifyApi();

        mJoinButton = (Button) findViewById(R.id.join_playlist);
        mStartNewButton = (Button) findViewById(R.id.new_playlist);


// Most (but not all) of the Spotify Web API endpoints require authorisation.
// If you know you'll only use the ones that don't require authorisation you can skip this step

        api.setAccessToken(mAccessToken);

        SpotifyService spotify = api.getService();

        spotify.getMe(new Callback<UserPrivate>() {
            @Override
            public void success(UserPrivate userPrivate, Response response) {
                UserSingleton.getInstance().setUserPrivatel(userPrivate);

                mJoinButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                mStartNewButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, NewPlaylistActivity.class);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void failure(RetrofitError error) {
                Log.w(TAG, "getMe:failure: ", error);

            }
        });

    }
}
