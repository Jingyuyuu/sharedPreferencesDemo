package tw.mymis.sharedPreferencesDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import tw.mymis.sharedPreferencesDemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences myData;
    SharedPreferences allShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        super.onCreate(savedInstanceState);



        myData=this.getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor=myData.edit();
        //editor.putString("myKey","data for myKey");
        //editor.apply();

        allShare=this.getSharedPreferences("appConfig",MODE_PRIVATE);
        SharedPreferences.Editor shareEditor=allShare.edit();
        shareEditor.putString("shareKey","data for shareKey");
        shareEditor.apply();

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=myData.edit();
                editor.putString("name",binding.textView.getText().toString());
                editor.apply();
            }
        });

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=myData.getString("name","目前無相關內容");
                Toast.makeText(MainActivity.this,data, Toast.LENGTH_LONG).show();
            }
        });
    }
}