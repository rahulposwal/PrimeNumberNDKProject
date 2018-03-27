package com.metroinfrasys.nativeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.isPrimeNumber)
    Button isPrimeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isPrimeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!number.getText().toString().isEmpty())
                {
                    int no = Integer.parseInt(number.getText().toString());
                    if(isPrime(no))
                    {
                        Toast.makeText(getApplicationContext(),"Prime Number",Toast.LENGTH_LONG).show();
                    }
                    else
                        {
                            Toast.makeText(getApplicationContext(),"Not Prime Number",Toast.LENGTH_LONG).show();
                        }
                }
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native boolean isPrime(int number);
}
