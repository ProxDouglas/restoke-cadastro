package com.estoke.web.config.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author vitor.alves
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EstokeProfiles {

    public static final String TESTE = "teste";

    public static String[] defaultProfiles() {
        return new String[]{TESTE};
    }
}
