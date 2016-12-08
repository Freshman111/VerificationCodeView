# VerificationCodeView
VerificationCode View


可用于动态生成验证码，常见于金融类app

## App Preview
![](art/verifycode.gif)

代码原理以及说明请看这一篇博客：
[Android实现动态验证码的技术调研与实现](http://blog.csdn.net/dreamsever/article/details/53467708)

usage

```
<sgffsg.com.verifycodeview.VerificationCodeView
    android:id="@+id/verifycodeview"
    android:layout_alignParentRight="true"
    android:layout_width="100dp"
    android:layout_height="40dp" />

```

```
verificationCodeView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        edit_input.setText("");
        verificationCodeView.refreshCode();
    }
});

```

####请求网络验证码时

```
<sgffsg.com.verifycodeview.VerificationCodeView
    android:id="@+id/net_verifycodeview"
    android:layout_width="100dp"
    android:layout_height="40dp"
    android:visibility="gone"
    app:isNetCode="true"/>
```


Thanks

[CaptchaImageView](https://github.com/jineshfrancs/CaptchaImageView)