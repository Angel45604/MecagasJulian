package julian.mecagas.julian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_view_2);
    }

    public void isometric(View v) {
        Log.d("OLA", "--------------------------------------------------");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
