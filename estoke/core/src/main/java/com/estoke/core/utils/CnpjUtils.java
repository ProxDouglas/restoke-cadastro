package com.estoke.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author vitor.alves
 */
public interface CnpjUtils {

    static String removeFormatacao(String cnpj) {
        return StringUtils.isNotEmpty(cnpj) ? cnpj.replaceAll("[^0-9]", "") : "";
    }
}
