package com.rahul.playground.smsretriever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

public class SMSBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Receiver : ", "OnReceive()");
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Log.d("SMS IF : ", "IF");
            Bundle extras = intent.getExtras();
            Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);
            switch (status.getStatusCode()) {
                case CommonStatusCodes.SUCCESS:
                    // Get SMS message contents
                    String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                    Log.d("SMS Success : ", message);

                    // Extract one-time code from the message and complete verification
                    // by sending the code back to your server for SMS authenticity.
                    break;
                case CommonStatusCodes.TIMEOUT:
                    Log.d("SMS Timeout : ", "Timeout");
                    // Waiting for SMS timed out (5 minutes)
                    // Handle the error ...
                    break;

            }
        }
    }
}
