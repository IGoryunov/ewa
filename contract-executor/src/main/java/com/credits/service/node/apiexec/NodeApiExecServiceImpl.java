package com.credits.service.node.apiexec;

import com.credits.client.executor.thrift.generated.apiexec.GetSeedResult;
import com.credits.client.executor.thrift.generated.apiexec.SendTransactionResult;
import com.credits.client.executor.thrift.generated.apiexec.SmartContractGetResult;
import com.credits.client.node.exception.NodeClientException;
import com.credits.client.node.pojo.TransactionFlowData;
import com.credits.client.node.thrift.generated.Amount;
import com.credits.client.node.thrift.generated.WalletBalanceGetResult;
import com.credits.client.node.thrift.generated.WalletIdGetResult;
import com.credits.client.node.util.Validator;
import com.credits.exception.ApiClientException;
import com.credits.general.util.exception.ConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.apiexec.GetSmartCodeResultData;
import pojo.apiexec.SmartContractGetResultData;

import java.math.BigDecimal;

import static com.credits.client.node.util.NodeClientUtils.processApiResponse;
import static com.credits.client.node.util.NodePojoConverter.amountToBigDecimal;
import static com.credits.client.node.util.NodePojoConverter.transactionFlowDataToTransaction;
import static com.credits.general.util.GeneralConverter.decodeFromBASE58;
import static com.credits.utils.ApiExecClientPojoConverter.createGetSmartCodeResultData;
import static com.credits.utils.ApiExecClientPojoConverter.createSmartContractGetResultData;

public class NodeApiExecServiceImpl implements NodeApiExecService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeApiExecServiceImpl.class);
    private static volatile NodeApiExecServiceImpl instance;
    public NodeThriftApiExecClient nodeClient;

    private NodeApiExecServiceImpl(String host, int port) {
        nodeClient = NodeThriftApiExecClient.getInstance(host, port);
    }

    public static NodeApiExecServiceImpl getInstance(String host, int port) {
        NodeApiExecServiceImpl localInstance = NodeApiExecServiceImpl.instance;
        if (localInstance == null) {
            synchronized (NodeApiExecServiceImpl.class) {
                localInstance = NodeApiExecServiceImpl.instance;
                if (localInstance == null) {
                    NodeApiExecServiceImpl.instance = localInstance = new NodeApiExecServiceImpl(host, port);
                }
            }
        }
        return localInstance;
    }

    @Override
    public byte[] getSeed(long accessId) throws ApiClientException {
        LOGGER.debug(String.format("getSeed: ---> accessId = %s", accessId));
        GetSeedResult seed = nodeClient.getSeed(accessId);
        processApiResponse(seed.getStatus());
        LOGGER.debug(String.format("getSeed: <--- seed = %s", seed.getSeed()));
        return seed.getSeed();
    }

    @Override
    public GetSmartCodeResultData getSmartCode(long accessId, String addressBase58) throws ApiClientException {
        LOGGER.debug(String.format("getSmartCode: ---> accessId = %s; addressBase58 = %s", accessId, addressBase58));
        SmartContractGetResult result = nodeClient.getSmartContractBinary(accessId, decodeFromBASE58(addressBase58));
        processApiResponse(result.getStatus());
        GetSmartCodeResultData data = createGetSmartCodeResultData(result);
        LOGGER.debug(String.format("getSmartCode: <--- result = %s", data));
        return data;
    }

    @Override
    public void sendTransaction(long accessId, TransactionFlowData transactionFlowData) throws ApiClientException {
        Validator.validate(transactionFlowData);
        LOGGER.debug("sendTransaction transactionFlowData -> {}", transactionFlowData);
        SendTransactionResult result = nodeClient.sendTransaction(accessId,
                transactionFlowDataToTransaction(transactionFlowData)
        );
        processApiResponse(result.getStatus());
    }

    @Override
    public SmartContractGetResultData getSmartContractBinary(long accessId, String addressBase58) throws ApiClientException {
        LOGGER.debug(String.format("getSmartCode: ---> accessId = %s; addressBase58 = %s", accessId, addressBase58));
        SmartContractGetResult result = nodeClient.getSmartContractBinary(accessId, decodeFromBASE58(addressBase58));
        processApiResponse(result.getStatus());
        SmartContractGetResultData data = createSmartContractGetResultData(result);
        LOGGER.debug(String.format("getSmartCode: <--- result = %s", data));
        return data;
    }


    @Override
    public int getWalletId(long accessId, String addressBase58) throws ApiClientException {
        LOGGER.debug(String.format("getWalletId: ---> addressBase58 = %s", addressBase58));
        WalletIdGetResult result = nodeClient.getWalletId(accessId, decodeFromBASE58(addressBase58));
        processApiResponse(result.getStatus());
        LOGGER.debug(String.format("getWalletId: <--- walletId = %s", result.getWalletId()));
        return result.getWalletId();
    }

    @Override
    public BigDecimal getBalance(String address) throws NodeClientException, ConverterException {
        LOGGER.info(String.format("getBalance: ---> address = %s", address));
        WalletBalanceGetResult result = nodeClient.getBalance(decodeFromBASE58(address));
        processApiResponse(result.getStatus());
        Amount amount = result.getBalance();
        BigDecimal balance = amountToBigDecimal(amount);
        LOGGER.info(String.format("getBalance: <--- balance = %s", balance));
        return balance;
    }


//    public static <R> void async(Function<R> apiCall, Callback<R> callback) {
//        CompletableFuture.supplyAsync(apiCall::apply, threadPool).whenComplete(handleCallback(callback));
//    }
//
//    public static <R> BiConsumer<R, Throwable> handleCallback(Callback<R> callback) {
//        return (result, error) -> {
//            if (error == null) {
//                callback.onSuccess(result);
//            } else {
//                LOGGER.error(error.getLocalizedMessage());
//                callback.onError(error);
//            }
//        };
//    }

}
