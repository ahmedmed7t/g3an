package totchi.g3an.ui.addPlate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import totchi.g3an.BuildConfig;
import totchi.g3an.R;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.ui.base.BaseView;

import static android.view.View.generateViewId;

public class addPlateActivity extends BaseActivity implements BaseView{

    public ImageView imageview;
    public Bitmap bitmap;

    private static final int PICK_IMAGE_REQUEST_CODE = generateViewId();
    private static final int REQUEST_IMAGE_CAPTURE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plate);

        imageview = findViewById(R.id.camera);
    }

    public void getImage(View view)
    {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && null != data) {

            final Uri imageUri = data.getData();
            InputStream imageStream = null;
            try {
                imageStream = getContentResolver().openInputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(imageStream);

            imageview.setImageBitmap(bitmap);

        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void connectionError() {

    }
}
