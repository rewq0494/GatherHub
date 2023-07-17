package com.gatherhub.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface EcPayService {
    String ecpayCheckout(String meetingroomId, String tradeNo);
}
