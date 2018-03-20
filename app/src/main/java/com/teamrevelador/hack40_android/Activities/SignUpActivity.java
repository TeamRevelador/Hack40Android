package com.teamrevelador.hack40_android.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.teamrevelador.hack40_android.Constants.SharedPreferencesConstants;
import com.teamrevelador.hack40_android.R;
import com.teamrevelador.hack40_android.Retrofit.ApiClient;
import com.teamrevelador.hack40_android.Retrofit.Responses.SignUpResponse;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private static int RC_PHOTO_PICKER = 123;
    private static String PATH = "";
    EditText signUpNameEditText;
    EditText signUpAgeEditText;
    EditText signUpEmailEditText;
    EditText signUpPasswordEditText;
    RadioButton maleRadioButton, femaleRadioButton;
    File imageFile;
    CircleImageView userCircleImageView;
    String gender;
    SharedPreferences sharedPreferences;
    Button signUpButton;


    /**The device should be connected to the internet on the same host as the hosting machine(server). and base URL would change accordingly*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Logging in");
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(true);

        sharedPreferences = getSharedPreferences(SharedPreferencesConstants.prefsName, MODE_PRIVATE);

        signUpNameEditText = findViewById(R.id.sign_up_name_edit_text);

        signUpAgeEditText = findViewById(R.id.sign_up_age_edit_text);

        signUpPasswordEditText = findViewById(R.id.sign_up_password_edit_text);

        signUpEmailEditText = findViewById(R.id.sign_up_email_edit_text);

        userCircleImageView = findViewById(R.id.sign_up_profile_image);

        userCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImageFromGallery(); // opens gallery for choosing image.

            }
        });

        maleRadioButton = findViewById(R.id.sign_up_male_radio_button);
        maleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "male";
            }
        });

        femaleRadioButton = findViewById(R.id.sign_up_female_radio_button);
        femaleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "female";
            }
        });

        signUpButton = findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAGGER", "called");
                if (userCircleImageView.getDrawable() == null || signUpAgeEditText.getText().toString().isEmpty() || signUpEmailEditText.getText().toString().isEmpty() || signUpNameEditText.getText().toString().isEmpty() || signUpPasswordEditText.getText().toString().isEmpty())
                    Toast.makeText(SignUpActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                progressDialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sharedPreferences.edit()
                                .putBoolean(SharedPreferencesConstants.prefsLoggedInStatus, true)
                                .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                .putString(SharedPreferencesConstants.prefsUserAge,signUpAgeEditText.getText().toString())
                                .putString(SharedPreferencesConstants.prefsUserGender,gender)
                                .putString(SharedPreferencesConstants.prefsUserImage,userCircleImageView.toString())
                                .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                .apply();

                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                        finish();

                    }
                },5500);
                signUpUser();
                // calls the networking function and tried to pass image as request,
                // make sure evey field has either empty string or a value (NOT NULL)
            }
        });

    }

    public void signUpUser() {

        try {

            RequestBody namePart = RequestBody.create(MultipartBody.FORM, signUpNameEditText.getText().toString());

            RequestBody emailPart = RequestBody.create(MultipartBody.FORM, signUpEmailEditText.getText().toString());

            RequestBody passwordPart = RequestBody.create(MultipartBody.FORM, signUpPasswordEditText.getText().toString());

            final RequestBody agePart = RequestBody.create(MultipartBody.FORM, signUpAgeEditText.getText().toString());

            RequestBody imagePart = RequestBody.create(MultipartBody.FORM, imageFile);

            RequestBody registrationPart = RequestBody.create(MultipartBody.FORM, 1 + "");

            MultipartBody.Part myImage = MultipartBody.Part.createFormData("image", imageFile.getName(), imagePart);

            RequestBody genderPart = RequestBody.create(MultipartBody.FORM, gender);

            ApiClient apiClient = new ApiClient();

            apiClient.getApiInterface()
                    .signUpRequest(namePart, emailPart, agePart, genderPart, passwordPart, myImage, registrationPart)
                    .enqueue(new Callback<SignUpResponse>() {
                        @Override
                        public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                            Log.d("TAGGER", "response : " + response.body());

                            sharedPreferences.edit()
                                    .putBoolean(SharedPreferencesConstants.prefsLoggedInStatus, true)
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserAge,signUpAgeEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserGender,gender)
                                    .putString(SharedPreferencesConstants.prefsUserImage,userCircleImageView.toString())
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .apply();

                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                            finish();

                        }

                        @Override
                        public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            t.getMessage();

//                            Toast.makeText(SignUpActivity.this, "Failed to sign up", Toast.LENGTH_SHORT).show();
                            sharedPreferences.edit()
                                    .putBoolean(SharedPreferencesConstants.prefsLoggedInStatus, true)
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserAge,signUpAgeEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserGender,gender)
                                    .putString(SharedPreferencesConstants.prefsUserImage,userCircleImageView.toString())
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .putString(SharedPreferencesConstants.prefsUserName,signUpNameEditText.getText().toString())
                                    .apply();

                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                            finish();

                        }
                    });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_PHOTO_PICKER) {
            if (resultCode == RESULT_OK) {

                Uri selectedImageUri = data.getData();
                userCircleImageView.setImageURI(selectedImageUri);
                PATH = getRealPathFromURI(selectedImageUri);
                imageFile = new File(PATH);
                Log.d("TAG", imageFile.getAbsolutePath());

//                Log.d("IMAGEPATH", PATH);


            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {

        // can post image
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(contentUri,
                proj, // Which columns to return
                null,       // WHERE clause; which rows to return (all rows)
                null,       // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    private void getImageFromGallery() {

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(pickIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

        startActivityForResult(chooserIntent, RC_PHOTO_PICKER);
    }
}