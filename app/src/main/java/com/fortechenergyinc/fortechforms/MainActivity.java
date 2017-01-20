package com.fortechenergyinc.fortechforms;

import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    public EditText mEditText;

    @BindView(R.id.editText2)
    public EditText mEditText2;

    @BindView(R.id.editText3)
    public EditText mEditText3;

    @BindView(R.id.editText4)
    public EditText mEditText4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
