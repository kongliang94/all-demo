package com.example.whatspidemo;

import java.util.Base64;

public interface CodecFactory {
    Base64.Encoder getEncoder(String encodingName);
    Base64.Decoder getDecoder(String encodingName);
}
