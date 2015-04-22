package com.ingesup.nfccreditcard.metier;

import java.util.Date;

/**
 * Created by alexandre on 01/04/2015.
 */
public class EmvCard {
    private String CardHolderLastName;
    private String CardHolderFirstName;
    private String PDOL;
    private Date ExperyDate;
    private int PINTry;
    private String ApplicationLabel;
    private String CardNumber;

    public EmvCard() {

    }

    public String getCardHolderLastName() {
        return CardHolderLastName;
    }

    public void setCardHolderLastName(String cardHolderLastName) {
        CardHolderLastName = cardHolderLastName;
    }

    public String getCardHolderFirstName() {
        return CardHolderFirstName;
    }

    public void setCardHolderFirstName(String cardHolderFirstName) {
        CardHolderFirstName = cardHolderFirstName;
    }

    public Date getExperyDate() {
        return ExperyDate;
    }

    public void setExperyDate(Date experyDate) {
        ExperyDate = experyDate;
    }

    public int getPINTry() {
        return PINTry;
    }

    public void setPINTry(int PINTry) {
        this.PINTry = PINTry;
    }

    public String getApplicationLabel() {
        return ApplicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        ApplicationLabel = applicationLabel;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getPDOL() {
        return PDOL;
    }

    public void setPDOL(String PDOL) {
        this.PDOL = PDOL;
    }
}
