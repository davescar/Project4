package drsdrs.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.ArtistSimple;
import kaaes.spotify.webapi.android.models.Track;
import kaaes.spotify.webapi.android.models.TracksPager;
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

        mJoinButton = (Button) findViewById(R.id.join_playlist);
        mStartNewButton = (Button) findViewById(R.id.new_playlist);


// Most (but not all) of the Spotify Web API endpoints require authorisation.
// If you know you'll only use the ones that don't require authorisation you can skip this step

        SpotifySingleton.getInstance().getSpotifyService().getMe(new Callback<UserPrivate>() {
            @Override
            public void success(UserPrivate userPrivate, Response response) {
                SpotifySingleton.getInstance().setUserPrivatel(userPrivate);

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

        //TESTING

        SpotifySingleton.getInstance().getSpotifyService().searchTracks("Changes", new Callback<TracksPager>() {
            @Override
            public void success(TracksPager tracksPager, Response response) {
                for (Track track: tracksPager.tracks.items) {
                    String artists = "";
                    for (ArtistSimple artist: track.artists) {
                        artists += artist.name + ", ";
                    }
                }


            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "failure: ", error );

            }
        });

        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapShot: dataSnapshot.getChildren()) {
                    Track track = snapShot.getValue(Track.class);
                    Log.d(TAG, "onDataChange: " + track.uri);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
