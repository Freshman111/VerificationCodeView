package sgffsg.com.verifycodeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private VerificationCodeView verificationCodeView;
    private Button btnSubmit;
    private EditText edit_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificationCodeView = (VerificationCodeView) findViewById(R.id.verifycodeview);
        btnSubmit= (Button) findViewById(R.id.btn_submit);
        edit_input= (EditText) findViewById(R.id.edit_input);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=edit_input.getText().toString().trim().toLowerCase();
                String code= verificationCodeView.getvCode().toLowerCase();
                if (!TextUtils.isEmpty(input)&&input.equals(code)){
                    Toast.makeText(MainActivity.this,"Verify Success!Welcome",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Verification code error!Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        verificationCodeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_input.setText("");
                verificationCodeView.refreshCode();
            }
        });
    }




}
