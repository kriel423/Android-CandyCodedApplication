package com.pluralsight.candycoded;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    Context context;
    TextView maps, phone;
    private Uri mMapLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        maps = findViewById(R.id.text_view_address);
        mMapLocation = Uri.parse(maps.getText().toString());

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.get().
                load(uri).
                into(candyStoreImageView);

    }



    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    //*****************my thoughts************************//
//    public void createMapIntent(){
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
//            context.startActivity(mapIntent);
//        } else {
//            //Show info
//            Log.i("", "could not access the map");
//        }
//
//    }
//    {
//        maps = findViewById(R.id.text_view_address);
//        Intent intent = new Intent(InfoActivity.this, )
//    }
    //*****************my thoughts************************//

    public void createMapIntent(View view)
    {
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if(mapIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(mapIntent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***


    //*****************my thoughts************************//
//    public void createPhoneIntent(){
//        phone = findViewById(R.id.text_view_phone);
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse(phone.getText().toString()));
//        startActivity(callIntent);
//    };

    //*****************my thoughts************************//

    public void createPhoneIntent(View view)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:0123456789"));
        startActivity(phoneIntent);
    }

}
