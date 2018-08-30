package albahrimaraxsa.com.cameracapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

import static albahrimaraxsa.com.cameracapture.GetFilePath.getFilePath;
import static albahrimaraxsa.com.cameracapture.GetFilePath.getFilePathVideo;

public class ShowVideo extends AppCompatActivity {

    VideoView videoView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        videoView = (VideoView) findViewById(R.id.videoView);
        textView = (TextView) findViewById(R.id.textView);


        String filename = getIntent().getExtras().getString("filename");

        textView.setText(filename);
        File video = new File(getFilePathVideo(filename));

//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);

        videoView.setVideoPath(video.getAbsolutePath());
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
//        imageView.setImageBitmap((bitmap));
    }
}
