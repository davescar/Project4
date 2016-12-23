package drsdrs.project4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.UserPrivate;

/**
 * Created by ds on 12/22/16.
 */

public class SpotifySingleton {

    private static SpotifySingleton sSpotifySingleton;
    private UserPrivate mUserPrivatel;
    private String mAccessToken;
    private SpotifyService mSpotifyService;
    private DatabaseReference mPlaylistRef;

    private SpotifySingleton() {
    }

    public static SpotifySingleton getInstance() {
        if (sSpotifySingleton == null) {
            sSpotifySingleton = new SpotifySingleton();
        }

        return sSpotifySingleton;
    }

    public UserPrivate getUserPrivatel() {
        return mUserPrivatel;
    }

    public void setUserPrivatel(UserPrivate userPrivatel) {
        mUserPrivatel = userPrivatel;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;

        SpotifyApi api = new SpotifyApi();
        api.setAccessToken(mAccessToken);
        mSpotifyService = api.getService();
    }

    public SpotifyService getSpotifyService() {
        return mSpotifyService;
    }

    public void subscribeToPlaylist (String playlistID) {
        mPlaylistRef = FirebaseDatabase.getInstance().getReference()
                .child(playlistID);

    }

    public DatabaseReference getPlaylistRef() {
        return mPlaylistRef;
    }
}