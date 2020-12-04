package com.mobproj.guessnow.not_used;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.home_group.MainActivity;

public class LocationPicker extends AppCompatActivity {
    Button btn_pick;
    TextView textView;
    int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_picker);

        btn_pick = findViewById(R.id.btn_pick);
        textView = findViewById(R.id.textview);

        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder - new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(MainActivity.this)
                            ,PLACE_PICKER_REQUEST);
                }
                catch (GooglePlayServicesRepairableException e){
                    e.printStackTrace();
                }
                catch (GooglePlayServicesNotAvailableException e){
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(
                requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data, this);
                StringBuilder stringBuilder = new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("LATITUDE: ");
                stringBuilder.append(latitude);
                stringBuilder.append("\n");
                stringBuilder.append("LONGITUDE");
                stringBuilder.append(longitude);
                textView.setText(stringBuilder.toString());
            }
        }
        )
    }
}
