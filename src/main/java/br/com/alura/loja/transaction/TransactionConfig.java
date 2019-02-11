package br.com.alura.loja.transaction;

import org.apache.deltaspike.core.api.config.DeltaSpikeConfig;

public interface TransactionConfig extends DeltaSpikeConfig {
	
	Integer getUserTransactionTimeoutInSeconds();
}
