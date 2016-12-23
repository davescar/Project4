package drsdrs.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewPlaylistActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_new_playlist);

        mTextView = (TextView) findViewById(R.id.playlist_name);
        mTextView.setText("Join: " + UserSingleton.getInstance().getUserPrivatel().id);

    }
}
