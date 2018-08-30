package albahrimaraxsa.com.cameracapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import static albahrimaraxsa.com.cameracapture.GetFilePath.getFilePath;

public class ShowImage extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);


        String filename = getIntent().getExtras().getString("filename");

        textView.setText(filename);
        File image = new File(getFilePath(filename));

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);

        imageView.setImageBitmap((bitmap));
    }
}
