package sgffsg.com.verifycodeview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private VerificationCodeView verificationCodeView,net_verificationCodeView;
    private Button btnSubmit,btnNetSubmit;
    private EditText edit_input,net_edit_input;
    private ProgressBar progressBar;
    private FrameLayout netVcViewLayout;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String code= (String) msg.obj;
            progressBar.setVisibility(View.GONE);
            net_verificationCodeView.setVisibility(View.VISIBLE);
            net_verificationCodeView.setvCode(code);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificationCodeView = (VerificationCodeView) findViewById(R.id.verifycodeview);
        net_verificationCodeView = (VerificationCodeView) findViewById(R.id.net_verifycodeview);
        btnSubmit= (Button) findViewById(R.id.btn_submit);
        btnNetSubmit= (Button) findViewById(R.id.net_btn_submit);
        edit_input= (EditText) findViewById(R.id.edit_input);
        net_edit_input= (EditText) findViewById(R.id.net_edit_input);
        progressBar= (ProgressBar) findViewById(R.id.net_pregressbar);
        netVcViewLayout= (FrameLayout) findViewById(R.id.net_verifycodeview_layut);
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

        btnNetSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=net_edit_input.getText().toString().trim().toLowerCase();
                String code= net_verificationCodeView.getvCode().toLowerCase();
                if (!TextUtils.isEmpty(input)&&input.equals(code)){
                    Toast.makeText(MainActivity.this,"Verify Success!Welcome",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Verification code error!Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        netVcViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                net_edit_input.setText("");
                progressBar.setVisibility(View.VISIBLE);
                net_verificationCodeView.setVisibility(View.GONE);
                loadNetCode();
            }
        });
        loadNetCode();
    }


    /**
     * 模拟加载网络验证码
     * load network verification code
     */
    private void loadNetCode(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message=handler.obtainMessage();
                message.obj=getCharAndNumr();
                handler.sendMessage(message);
            }
        },1000);
    }

    /**
     * java生成随机数字和字母组合
     * @return 随机验证码
     */
    public String getCharAndNumr() {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
