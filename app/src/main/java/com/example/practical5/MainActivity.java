package com.example.practical5;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            return insets.inset(insets.getInsets(WindowInsetsCompat.Type.systemBars()));
        });

        EditText etInputMuni = findViewById(R.id.et_input_muni);

        etInputMuni.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO) {
                String input = etInputMuni.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_empty, Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (TextProcessor.isValid(input)) {
                    Intent intent = new Intent(MainActivity.this, Municipality.class);
                    intent.putExtra("city", input);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, R.string.error_invalid, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
            return false;
        });
    }
}
