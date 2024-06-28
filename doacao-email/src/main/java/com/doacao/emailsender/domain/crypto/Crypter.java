package com.doacao.emailsender.domain.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Crypter {
 
    public final String key;

    public Crypter(@Value("${crypter.key}") final String key) {
        this.key = key;
    }

    public String encode(String message) {
        return Hex.encodeHexString(xorWithKey(message.getBytes(), key.getBytes()));
    }

    public String decode(String message) throws DecoderException {
        return new String(xorWithKey(Hex.decodeHex(message), key.getBytes()));
    }

    private byte[] xorWithKey(byte[] message, byte[] key) {
        byte[] out = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            out[i] = (byte) (message[i] ^ key[i%key.length]);
        }
        return out;
    }

}