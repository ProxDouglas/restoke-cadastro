package com.estoke.core.fornecedor.message;

import com.estoke.core.tec.message.MessageCreator;
import com.estoke.core.tec.message.MessageDelegate;
import com.estoke.core.tec.message.MessageHolder;

/**
 * @author vitor.alves
 */
public enum FornecedorMessage implements MessageCreator {

    FORNECEDOR_CNPJ_NAO_EXISTE(1, "fornecedor.cnpj.nao.encontrado");

    private MessageDelegate messageDelegate;

    private final String bundle = "message.fornecedor-message.properties";

    private final String key;

    private final int numArgs;

    FornecedorMessage(int nArgs, String key) {
        this.key = key;
        this.numArgs = nArgs;
        this.messageDelegate = MessageDelegate.getMessageDelegate();
    }

    @Override
    public MessageHolder create(Object... args) {
        return messageDelegate.createMessageHolder(this, args);
    }

    @Override
    public int getNumArgs() {
        return this.numArgs;
    }

    @Override
    public String getBundle() {
        return this.bundle;
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
