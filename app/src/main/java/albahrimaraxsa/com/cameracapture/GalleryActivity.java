package albahrimaraxsa.com.cameracapture;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    ListView listView;
    List<String> listPhotoName;

    GalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        listView = (ListView)findViewById(R.id.listView);

        DataHelper dataHelper = new DataHelper(this);
        listPhotoName =  dataHelper.getData();

        adapter = new GalleryAdapter(this, listPhotoName);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.textView);

                String textViewvalue = (String) textView.getText();

                if (textViewvalue.substring(textViewvalue.length() - 4).equalsIgnoreCase(".jpg")) {
                    Intent intent = new Intent(GalleryActivity.this, ShowImage.class);
                    intent.putExtra("filename", textView.getText());
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(GalleryActivity.this, ShowVideo.class);
                    intent.putExtra("filename", textView.getText());
                    startActivity(intent);
                }

            }
        });

    }

}
