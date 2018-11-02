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
        if (savedInstanceState != null) {
            visibleImages = savedInstanceState.getStringArrayList("images");
            if (visibleImages.size() > 0) {
                setPartsVisible(savedInstanceState.getStringArrayList("images"));
            }
        }
    }

    public void setPartsVisible(ArrayList<String> images) {
        for (String imageText : images) {
            ImageView image = checkChecked(imageText);
            image.setVisibility(image.VISIBLE);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        outState.putStringArrayList("images", visibleImages);
    }

    public void checkClicked(View v) {
        Log.d("potato","checkClicked: ");
        CheckBox checkbox = (CheckBox) v;
        String checkBoxText = checkbox.getText().toString();
        if(checkbox.isChecked()) {
            ImageView image = checkChecked(checkBoxText);
            image.setVisibility(image.VISIBLE);
            visibleImages.add(checkBoxText);
        } else {
            ImageView image = checkChecked(checkBoxText);
            image.setVisibility(image.INVISIBLE);
            visibleImages.remove(checkBoxText);
        }
    }

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