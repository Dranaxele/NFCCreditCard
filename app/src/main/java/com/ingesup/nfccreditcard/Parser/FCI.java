package com.ingesup.nfccreditcard.Parser;

import android.util.Log;

import com.ingesup.nfccreditcard.NFCCreditCardToolActivity;
import com.ingesup.nfccreditcard.ParseGeneralInfo;

/**
 * Created by alexandre on 11/03/2015.
 */
public class FCI {

    public FCI(byte[] bytes) {
        for(int i=0;i<bytes.length;i++){
            if(bytes[i] == (byte) 0x6F){
                Log.d("Test", "Parse: FCI");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x84){
                Log.d("Test", "Parse: DF");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0xA5){
                Log.d("Test", "Parse: FCI Proprietary Template");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes));
            }else if(bytes[i] == (byte) 0x50){
                Log.d("Test", "Parse: Application Label");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.bytesToString(bytes, i+2, ParseGeneralInfo.byteValue(bytes[i+1])));
            }else if(bytes[i] == (byte) 0x87) {
                Log.d("Test", "Parse: Application Priority Indicator");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+1]));
                Log.d("Test", "Message: " + ParseGeneralInfo.toHex(bytes).substring((i*2)+4, ((ParseGeneralInfo.byteValue(bytes[i+1]))*2)+(i*2)+4));
            }else if(bytes[i] == (byte) 0x9F && bytes[i+1] == (byte) 0x11){
                Log.d("Test", "Parse: Issuer Code Table Index");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+2]));
                Log.d("Test", "Message: " + ParseGeneralInfo.bytesToString(bytes, i+3, ParseGeneralInfo.byteValue(bytes[i+2])));
            }else if(bytes[i] == (byte) 0x9F && bytes[i+1] == (byte) 0x12){
                Log.d("Test", "Parse: Application Preferred Name");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+2]));
                Log.d("Test", "Message: " + ParseGeneralInfo.bytesToString(bytes, i+3, ParseGeneralInfo.byteValue(bytes[i+2])));
            }else if(bytes[i] == (byte) 0x9F && bytes[i+1] == (byte) 0x38){
                Log.d("Test", "Parse: PDOL");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+2]));
                Log.d("Test", "Message: ");
                NFCCreditCardToolActivity.CreditCard.setPDOL(ParseGeneralInfo.toHex(bytes).substring((i*2)+4, (i*2)+4+ParseGeneralInfo.byteValue(bytes[i+2])));
                Log.d("Carte", "PDOL: " + NFCCreditCardToolActivity.CreditCard.getPDOL());
            }else if(bytes[i] == (byte) 0x5F && bytes[i+1] == (byte) 0x2D){
                Log.d("Test", "Parse: Language Preference");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+2]));
                Log.d("Test", "Message: " + ParseGeneralInfo.bytesToString(bytes, i+3, ParseGeneralInfo.byteValue(bytes[i+2])));
            }else if(bytes[i] == (byte) 0xBF && bytes[i+1] == (byte) 0x0C){
                Log.d("Test", "Parse: File Control Information (FCI) Proprietary Template");
                Log.d("Test", "Taille: " + ParseGeneralInfo.byteValue(bytes[i+2]));
                Log.d("Test", "Message: ");
            }
        }
    }
}