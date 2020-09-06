package com.example.multimedia_example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.VideoView;
import android.view.View;
import android.net.Uri;
import android.widget.MediaController;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void executarAudio(View view) {
        player = MediaPlayer.create(this, R.raw.audio);
        player.start();
    }

    public void executar(View view) {
        if (!player.isPlaying()) {
            player.start();
        }
    }

    public void pausar(View view) {
        if (player.isPlaying()) {
            player.pause();
        }
    }

    public void parar(View view) {
        if (player.isPlaying()) {
            player.stop();
        }
    }

    public void executarVideo(View v) {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

}