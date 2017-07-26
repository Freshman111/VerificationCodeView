package sgffsg.com.verifycodeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 加入XML设置codeNum
 * Created by sgffsg on 17/7/26.
 */

public class SecondActivity extends AppCompatActivity{
    VerificationCodeView verificationCodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        verificationCodeView= (VerificationCodeView) findViewById(R.id.verifycodeview);
        verificationCodeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificationCodeView.refreshCode();
            }
        });
        verificationCodeView.refreshCode();
    }

}
