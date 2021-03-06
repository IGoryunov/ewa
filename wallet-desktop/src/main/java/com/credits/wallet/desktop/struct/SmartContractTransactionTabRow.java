package com.credits.wallet.desktop.struct;

import com.credits.client.node.pojo.SmartTransInfoData;

/**
 * Created by Rustem Saidaliyev on 25.06.2018.
 */
public class SmartContractTransactionTabRow extends TransactionTabRow {

    private SmartTransInfoData smartInfo;
    private String type;

    public SmartTransInfoData getSmartInfo() {
        return smartInfo;
    }

    public void setSmartInfo(SmartTransInfoData smartInfo) {
        this.smartInfo = smartInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
