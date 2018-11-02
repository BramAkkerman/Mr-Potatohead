package com.example.brama.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> visibleImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // If there is a saved state, set all images which were visible before visible again.
        if (savedInstanceState != null) {
            visibleImages = savedInstanceState.getStringArrayList("images");
            if (visibleImages.size() > 0) {
                setPartsVisible();
            }
        }
    }

    // Set all the images visible in the list
    public void setPartsVisible() {
        for (String imageText : visibleImages) {
            ImageView image = checkChecked(imageText);
            image.setVisibility(image.VISIBLE);
        }
    }

    // Save the list visibleImages in the state bundle
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        outState.putStringArrayList("images", visibleImages);
    }

    // Show the corresponding image if the checkbox is checked
    public void checkClicked(View v) {
        Log.d("potato","checkClicked: ");
        CheckBox checkbox = (CheckBox) v;
        String checkBoxText = checkbox.getText().toString();
        if(checkbox.isChecked()) {
            ImageView image = checkChecked(checkBoxText);
            image.setVisibility(image.VISIBLE);
            // Add the name to the currently visible images
            visibleImages.add(checkBoxText);
        } else {
            ImageView image = checkChecked(checkBoxText);
            image.setVisibility(image.INVISIBLE);
            // Remove the name from the currently visible images
            visibleImages.remove(checkBoxText);
        }
    }

    // Switch case to handle the different image IDs
    private ImageView checkChecked(String checkBoxText) {
        ImageView image = (ImageView) findViewById(R.id.body);
        switch (checkBoxText) {
            case "Eyes":
                image = (ImageView) findViewById(R.id.eyes);
                break;
            case "Nose":
                image = (ImageView) findViewById(R.id.nose);
                break;
            case "Mouth":
                image = (ImageView) findViewById(R.id.mouth);
                break;
            case "Ears":
                image = (ImageView) findViewById(R.id.ears);
                break;
            case "Arms":
                image = (ImageView) findViewById(R.id.arms);
                break;
            case "Shoes":
                image = (ImageView) findViewById(R.id.shoes);
                break;
            case "Eyebrows":
                image = (ImageView) findViewById(R.id.eyebrows);
                break;
            case "Mustache":
                image = (ImageView) findViewById(R.id.mustache);
                break;
            case "Hat":
                image = (ImageView) findViewById(R.id.hat);
                break;
            case "Glasses":
                image = (ImageView) findViewById(R.id.glasses);
                break;
        }
        return image;
    }
}