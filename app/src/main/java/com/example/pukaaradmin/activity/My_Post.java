package com.example.pukaaradmin.activity;

import static com.example.pukaaradmin.activity.FileUtil.getRealPathFromURI;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;



import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.apiinterface.ApiInterface;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class My_Post extends AppCompatActivity {

ImageView post_pic;
    private ProgressDialog progressDialog = null;
    int SELECT_PICTURE = 200;
    File file = null;
    public  static final int PERMISSIONS_MULTIPLE_REQUEST = 123;
    private ApiInterface apiInterface;
    Button created_post;
    EditText post_text;
    String s = "sssss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);
        post_pic = findViewById(R.id.post_pic);
        created_post = findViewById(R.id.post_button1);
        post_text = findViewById(R.id.post_text);

        //
        apiInterface = ApiClient.Companion.create();

        post_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imageChooser();
                //checkPermissions();
                //checkRunTimePermission();
                //checkPermissions();
                getPermissionForStorage();
            }
        });
        created_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(file != null && post_text.getText().toString().length() > 0) {
                    progressDialog = new ProgressDialog(My_Post.this);
                    progressDialog.setMessage("please wait image is uploading...");
                    progressDialog.setTitle("Image Uploading");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
                    RequestBody quantityBody = RequestBody.create(MediaType.parse("text/plain"), post_text.getText().toString());

                        Call<String> call = apiInterface.createPost(CommonFunction.Companion.getToken(getApplicationContext()), quantityBody, reqFile);
                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (progressDialog != null)
                                    progressDialog.dismiss();
                                if (response.body() != null) {
                                    if (response.body().toString().toLowerCase().equalsIgnoreCase("Success")) {
//                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                if (progressDialog != null)
                                    progressDialog.dismiss();
                            }
                        });
                    }


                else
                    Toast.makeText(getApplicationContext(),"please select image",Toast.LENGTH_SHORT).show();


            }
        });

      /*  back_arrow_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });*/

        //


    }

    public boolean getPermissionForStorage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (CommonFunction.Companion.neverAskAgainSelected(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    CommonFunction.Companion.openSetting(getApplicationContext());
                } else {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                }
            }

            return false;
        } else {
            imageChooser();
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    imageChooser();
                } else {
                    /*if (popup != null)
                        popup.dismiss();*/
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void checkAndroidVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();

        } else {
            // write your logic here
        }

    }
    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE) + ContextCompat
                .checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        new String[]{Manifest.permission
                                .READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_MULTIPLE_REQUEST);
            }else
                imageChooser();
        } else {
            // write your logic code if permission already granted
            imageChooser();
        }
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    new ImageAsyncTask().execute(selectedImageUri);
                }
            }
        }
    }
    class ImageAsyncTask extends AsyncTask<Uri, String, Bitmap> {
        String TAG = getClass().getSimpleName();

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(My_Post.this);
            progressDialog.setMessage("please wait image is Loading...");
            progressDialog.setTitle("Image Loading");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        protected Bitmap doInBackground(Uri...arg0) {
            Bitmap bitmap = null;
            String path =null;
            try {
                path = FileUtil.getRealPathFromURI(getApplicationContext(), arg0[0]);
                bitmap = MediaStore.Images.Media.getBitmap(
                        getApplicationContext().getContentResolver(), arg0[0]);
                try {

                    ExifInterface exif = new ExifInterface(path);
                    int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    //Log.d("EXIF", "Exif: " + orientation);
                    Matrix matrix = new Matrix();
                    if (orientation == 6) {
                        matrix.postRotate(90);
                    }
                    else if (orientation == 3) {
                        matrix.postRotate(180);
                    }
                    else if (orientation == 8) {
                        matrix.postRotate(270);
                    }
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true); // rotating bitmap
                }
                catch (Exception e) {
                    e.getMessage();
                }

                //file = new File(saveBitmapToFile(saveToInternalStorage(bitmap)));
                file = new File(CommonFunction.Companion.compressImage(path,getApplicationContext()));
            } catch (Exception e) {
                // Manage exception ...
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            post_pic.setImageBitmap(bitmap);
            if(progressDialog!= null)
                progressDialog.dismiss();
        }
    }
    public String saveBitmapToFile(File file){
        try {

            // BitmapFactory options to downsize the image
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            o.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, o);
            inputStream.close();

            // The new size we want to scale to
            final int REQUIRED_SIZE=75;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while(o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            inputStream = new FileInputStream(file);

            Bitmap selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();

            // here i override the original image file
            file.createNewFile();
            /*File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File mypath=new File(path,"profile.png");*/
            FileOutputStream outputStream = new FileOutputStream(file);

            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100 , outputStream);

            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
    private File saveToInternalStorage(Bitmap bitmapImage){
        // path to /data/data/yourapp/app_data/imageDir
        // Create imageDir
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File mypath=new File(path,"profile.png");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mypath;
        //return mypath.getAbsolutePath();
    }
    private void checkPermissions()
    {
        String[] permissionArrays;

      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
           permissionArrays = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        else*/
        permissionArrays = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};//Manifest.permission.MANAGE_EXTERNAL_STORAGE
        Dexter.withContext(this)
                .withPermissions(
                        permissionArrays)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            imageChooser();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }
    private void checkRunTimePermission() {
        String[] permissionArrays = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, 11111);
        } else {
            // if already permition granted
            // PUT YOUR ACTION (Like Open cemara etc..)
            imageChooser();
        }
    }
    void alertView() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(My_Post.this);

        dialog.setTitle("Permission Denied")
                .setInverseBackgroundForced(true)
                //.setIcon(R.drawable.ic_info_black_24dp)
                .setMessage("Without those permission the app is unable to save your profile. App needs to save profile image in your external storage and also need to get profile image from camera or external storage.Are you sure you want to deny this permission?")

                .setNegativeButton("I'M SURE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.dismiss();
                    }
                })
                .setPositiveButton("RE-TRY", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.dismiss();
                        checkRunTimePermission();

                    }
                }).show();
    }

}