package androidsamples.java.whatday;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView timeText = findViewById(R.id.txt_display);
    EditText dateText = findViewById(R.id.editDate);
    EditText monthText = findViewById(R.id.editMonth);
    EditText yearText = findViewById(R.id.editYear);
    Button checkBtn = findViewById(R.id.btn_check);

    checkBtn.setOnClickListener(view -> {
      String dateValue = dateText.getText().toString();
      String monthValue = monthText.getText().toString();
      String yearValue = yearText.getText().toString();

      DateModel.initialize(yearValue, monthValue, dateValue);

      String message = DateModel.getMessage();
      timeText.setText(message);
    });
  }
}