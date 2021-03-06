package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Modify_dialog extends Dialog implements View.OnClickListener{
    private static final int LAYOUT = R.layout.modify_dialog;
    private Context context;
    private String name;
    private String pn;
    private ListViewItem result;
    private Drawable icon;
    private EditText edit_name;
    private EditText ph;
    private int PICK_IMAGE_REQUEST=1;
    Button submit;
    Button get_user_img;

    public Modify_dialog(Context context,Drawable icon, String name, String pn) {
        super(context);
        this.result = new ListViewItem();
        this.context = context;
        this.icon = icon;
        this.name = name;
        this.pn = pn;
    }

    public ListViewItem getResult() {
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        edit_name = (EditText)findViewById(R.id.edit_name);
        ph = (EditText)findViewById(R.id.edit_ph);
        Button submit = (Button) findViewById(R.id.submit);
        Button quit = (Button) findViewById(R.id.quit);
        submit.setOnClickListener(this);
        quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submit :
                String name_str = edit_name.getText().toString();
                String ph_str = ph.getText().toString();
                result.setIconDrawable(icon);
                result.setName(name_str);
                result.setPh_num(ph_str);
                dismiss();
                break;
            case R.id.quit:
                result.setIconDrawable(icon);
                result.setName(name);
                result.setPh_num(pn);
                dismiss();
                break;
        }
    }

}