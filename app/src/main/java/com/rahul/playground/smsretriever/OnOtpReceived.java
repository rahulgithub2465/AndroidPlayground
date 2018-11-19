package com.rahul.playground.smsretriever;

public interface OnOtpReceived {

    void otpSuccess(String otp);

    String otpFailed();
}
