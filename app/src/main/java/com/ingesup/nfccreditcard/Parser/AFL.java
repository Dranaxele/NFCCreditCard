package com.ingesup.nfccreditcard.Parser;

import android.util.Log;

import com.ingesup.nfccreditcard.ParseGeneralInfo;

/**
 * Created by alexandre on 22/04/2015.
 */
public class AFL {

    public AFL(byte[] bytes){
        for(int i=0;i<bytes.length;i++) {
            if (bytes[i] == (byte) 0x94) {
                Log.d("Test", "Parse: AFL");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i + 1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x82){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x9F){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x36){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x27){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x10){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x26){
                Log.d("Test", "Parse: AIP");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }

        }
    }
}
