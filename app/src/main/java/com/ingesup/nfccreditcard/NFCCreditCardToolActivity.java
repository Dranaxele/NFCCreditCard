package com.ingesup.nfccreditcard;

// /home/rli/installations/pssi/pssi-1.0/pssi

import java.io.IOException;
import java.math.BigInteger;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
//import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.util.Log;
import android.widget.TextView;

import com.ingesup.nfccreditcard.Parser.FCI;

public class NFCCreditCardToolActivity extends Activity {
	private static final int DIALOG_NFC_OFF = 1;
	private NfcAdapter mAdapter;
	private PendingIntent pendingIntent;
	private String[][] mTechLists;
	private IntentFilter[] mFilters;
	
	TextView tv1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("Waiting for card...");

        mAdapter = NfcAdapter.getDefaultAdapter(this);
  	    pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		try {
			ndef.addDataType("*/*");
		} catch (MalformedMimeTypeException e) {
			throw new RuntimeException("fail", e);
		}
		mFilters = new IntentFilter[] { ndef, };
		mTechLists = new String[][] { new String[] { IsoDep.class.getName() } };
    }

    @Override
 	public void onResume() {
         super.onResume();
         NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(this);
         if (mAdapter == null || !mAdapter.isEnabled()) {
             showDialog(DIALOG_NFC_OFF);
         }
         mAdapter.enableForegroundDispatch(this, pendingIntent, mFilters, mTechLists);
     }

    @Override
 	public void onPause() {
         super.onPause();
         mAdapter.disableForegroundDispatch(this);
     }

    public static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

    @Override
    protected void onNewIntent(Intent intent){
    	int i;

    	this.setIntent(intent);
    	tv1.setText("New intent");

        Parcelable nfcTag = intent.getParcelableExtra("android.nfc.extra.TAG");
        Tag t = (Tag) nfcTag;
        IsoDep myTag = IsoDep.get(t);
        if( !myTag.isConnected() ) {
			try {
				myTag.connect();
			} catch (IOException e) {
				Log.d("Erreur!", "Impossible de se connecter au Tag: " + e);
				return;
			}
        }
        tv1.setText("Tag connected");
        //byte selectCommand[] = {0x00,(byte) 0xa4,0x04,0x00,0x07,(byte) 0xa0,0x00,0x00,0x00,0x42,0x10,0x10,0x00};
        //byte selectCommand[] = {0x00, (byte) 0xA4,0x04,0x00,0x0E,0x32,0x50,0x41,0x59,0x2E,0x53,0x59,0x53,0x2E,0x44,0x44,0x46,0x30,0x31,0x00};
        byte selectCommand[] = {(byte)0x80,(byte)0xCA,(byte)0x5F,0x34,0x00};

        byte response[] = new byte[100];

        try {
            myTag.isConnected();
            String mess = "";
			response = myTag.transceive(selectCommand);
            mess += ParseGeneralInfo.toHex(response);
            //new FCI(response);
			tv1.setText(mess);
		} catch (IOException e) {
            Log.d("Test", "Erreur: " + e);
			e.printStackTrace();
			return;
		}
    }
}