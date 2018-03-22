package com.credits.wallet.desktop;

import com.credits.leveldb.client.*;
import com.credits.wallet.desktop.struct.TransactionTabRow;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * Created by goncharov-eg on 19.01.2018.
 */
public class AppState {
    public static ApiClient apiClient;
    public static String decSep;
    public static String contractExecutorHost;
    public static Integer contractExecutorPort;
    public static String sysTranPublicKeyBASE64;
    public static String sysTranPrivateKeyBASE64;
    public static Double sysTranAmount;
    public static String sysTranCurrency;

    public static boolean newAccount;
    public static String account;

    public static Double amount = 0.0;
    public static Double transactionFeeValue = 0.0;
    public static Double transactionFeePercent = 0.0;
    public static String toAddress;
    public static String coin;

    public static TransactionTabRow selectedTransactionRow;
    public static String transactionId;

    public static List<String> coins=new ArrayList<>();

    public static ExecutorService executor;

    public static PrivateKey privateKey;
    public static PublicKey publicKey;
}
