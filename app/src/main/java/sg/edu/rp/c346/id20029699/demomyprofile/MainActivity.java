package sg.edu.rp.c346.id20029699.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.editTextName);
        etgpa = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etname.getText().toString();
        float floatGPA = Float.parseFloat(etgpa.getText().toString());
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putString("name", strName) ;
        prefEdit.putFloat("gpa", floatGPA);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String nameData = prefs.getString("name", "No name");
        float gpaData = prefs.getFloat("gpa", 0);
        etname.setText(nameData);
        etgpa.setText(gpaData + "");

    }
}