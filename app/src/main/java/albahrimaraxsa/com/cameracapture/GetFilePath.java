package albahrimaraxsa.com.cameracapture;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFilePath {

    public static String getFilePath(String filename){
        File filepath = new File(Environment.getExternalStoragePublicDirectory("DCIM").getAbsolutePath(),"AppsPhoto");
        if(!filepath.exists()) filepath.mkdir();
        return filepath.getAbsolutePath()+"/"+filename;
    }

    public static String getFilePathVideo (String filename){
        File filepath = new File(Environment.getExternalStoragePublicDirectory("DCIM").getAbsolutePath(),"AppsVideo");
        if(!filepath.exists()) filepath.mkdir();
        return filepath.getAbsolutePath()+"/"+filename;
    }
}
