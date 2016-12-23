package drsdrs.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinPlaylistActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_playlist);

        mEditText = (EditText) findViewById(R.id.enter_playlist_name);
        mButton = (Button) findViewById(R.id.join_playlist);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String playlistID = mEditText.getText().toString();
                SpotifySingleton.getInstance().subscribeToPlaylist(playlistID);
            }
        });

    }
}
