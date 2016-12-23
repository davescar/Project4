package drsdrs.project4;

import kaaes.spotify.webapi.android.models.UserPrivate;

/**
 * Created by ds on 12/22/16.
 */

public class UserSingleton {

    private static UserSingleton sUserSingleton;
    private UserPrivate mUserPrivatel;
    private String mAuthToken;

    private UserSingleton() {
    }

    public static UserSingleton getInstance() {
        if (sUserSingleton == null) {
            sUserSingleton = new UserSingleton();
        }

        return sUserSingleton;
    }

    public UserPrivate getUserPrivatel() {
        return mUserPrivatel;
    }

    public void setUserPrivatel(UserPrivate userPrivatel) {
        mUserPrivatel = userPrivatel;
    }

    public String getAuthToken() {
        return mAuthToken;
    }

    public void setAuthToken(String authToken) {
        mAuthToken = authToken;
    }
}