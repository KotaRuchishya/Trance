package com.example.admin.ciae;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.FaceServiceRestClient;
import com.microsoft.projectoxford.face.contract.Face;
import com.microsoft.projectoxford.face.contract.FaceRectangle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class EmotionDetect extends Activity {


    private final String apiEndpoint = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/";


    private final String subscriptionKey = " 3ace36ee22ad4ab09259d9ef9c8fbc11";



    private final FaceServiceClient faceServiceClient =

            new FaceServiceRestClient(apiEndpoint, subscriptionKey);

    FaceServiceClient.FaceAttributeType[] expectedFaceAttributes = new FaceServiceClient.FaceAttributeType[]{FaceServiceClient.FaceAttributeType.Emotion};



    private static final int REQUEST_TAKE_PHOTO = 0;
    private final int PICK_IMAGE = 1;

    private ProgressDialog detectionProgressDialog;


    public double max2;
    int pos;
    String emotion;
    Bitmap bmp;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emotion_detect);



        Button button1 = (Button) findViewById(R.id.button1);

        Button button2 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(

                        intent, "Select Picture"), PICK_IMAGE);

            }

        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0); //will provide a result from the camera.



            }

        });



        detectionProgressDialog = new ProgressDialog(this);

    }




    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK &&

                data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(

                        getContentResolver(), uri);


                ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                imageView.setImageBitmap(bitmap);
                detectAndFrame(bitmap);

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
       if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK && data != null) {
           ImageView imageView = (ImageView) findViewById(R.id.imageView1);
            Bundle b = data.getExtras();
            bmp = (Bitmap) b.get("data");
            imageView.setImageBitmap(bmp);
            detectAndFrame(bmp);
        } else {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }

    }



    // Detect faces by uploading a face image.


    private void detectAndFrame(final Bitmap imageBitmap) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

        ByteArrayInputStream inputStream =

                new ByteArrayInputStream(outputStream.toByteArray());



        AsyncTask<InputStream, String, Double[]> detectTask =

                new AsyncTask<InputStream, String, Double[]>() {

                    String exceptionMessage = "";



                    @Override

                    protected Double[] doInBackground(InputStream... params) {

                        Double emos[]=new Double[3];

                        Face[] result = new Face[0];
                        try {

                            publishProgress("Detecting...");



                            result = faceServiceClient.detect(params[0], true, false, expectedFaceAttributes);


                            Log.d("RESULT", "res is:" + result[0].faceAttributes.emotion.happiness);
                            emos[0]=result[0].faceAttributes.emotion.anger;
                            emos[1]=result[0].faceAttributes.emotion.happiness;
                            emos[2]=result[0].faceAttributes.emotion.sadness;

                            max2= emos[0];

                            for (int i = 1; i < emos.length; i++) {
                                if (emos[i] > max2) {
                                    max2 = emos[i];
                                    pos=i;
                                }
                            }
                            if(pos==0)
                            {
                                emotion="Angry";

                            }
                            else if(pos==1)
                            {
                                emotion="Happy";
                            }
                            else
                            {
                                emotion="Sad";
                            }
                            if (result == null) {

                                publishProgress(

                                        "Detection Finished. Nothing detected");

                                return null;

                            }
                            Gson gson = new Gson();
                            String json = gson.toJson(result[0].faceAttributes.emotion);
                            Log.d("result", json);


                            sendto();

                            publishProgress(String.format(

                                    "Detection Finished. %d face(s) detected",

                                    result.length));

                        } catch (Exception e) {

                            exceptionMessage = String.format(

                                    "Detection failed: %s", e.getMessage());

                            return null;

                        }

                        return emos;
                    }



                    @Override

                    protected void onPreExecute() {

                        //Shows Progress bar

                        detectionProgressDialog.show();

                    }

                    @Override

                    protected void onProgressUpdate(String... progress) {

                        //Updates Progress bar

                        detectionProgressDialog.setMessage(progress[0]);

                    }

                    @Override
                    protected void onPostExecute(Double[] emos) {
                        super.onPostExecute(emos);
                        Toast.makeText(EmotionDetect.this, "RESULT FOUND", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(EmotionDetect.this, EmotionResult.class);
                        i.putExtra("emotion",emotion);
                        startActivity(i);
                        finish();

                    }

                };



        detectTask.execute(inputStream);

    }

    private void sendto() {


    }


    private void showError(String message) {

        new AlertDialog.Builder(this)

                .setTitle("Error")

                .setMessage(message)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                    }})

                .create().show();

    }



    private static Bitmap drawFaceRectanglesOnBitmap(

            Bitmap originalBitmap, Face[] faces) {

        Bitmap bitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();

        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(Color.RED);

        paint.setStrokeWidth(10);

        if (faces != null) {

            for (Face face : faces) {

                FaceRectangle faceRectangle = face.faceRectangle;

                canvas.drawRect(

                        faceRectangle.left,

                        faceRectangle.top,

                        faceRectangle.left + faceRectangle.width,

                        faceRectangle.top + faceRectangle.height,

                        paint);

            }



        }

        return bitmap;

    }


}
