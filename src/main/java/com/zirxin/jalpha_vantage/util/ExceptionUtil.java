package com.zirxin.jalpha_vantage.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.zirxin.jalpha_vantage.exception.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class ExceptionUtil {

    public static void handleExceptions(String value, String function) throws MissingApiKeyException, InvalidApiKeyException, MalFormattedFunctionException, InvalidFunctionOptionException, UltraHighFrequencyRequestException {
        String invalidKey = "\"Please make sure your API key is valid. Alternatively, claim your free API key on (https://www.alphavantage.co/support/#api-key). It should take less than 20 seconds, and is free permanently.\"";
        String missingApiKey = "\"the parameter apikey is invalid or missing. Please claim your free API key on (https://www.alphavantage.co/support/#api-key). It should take less than 20 seconds, and is free permanently.\"";
        String invalidFunction = "\"This API function (" + function + ") does not exist.\"";
        String missingOrInvalidFunctionParam = "\"Invalid API call, please visit documentation (https://www.alphavantage.co/documentation/) for function: " + function + "\"";
        String highUsuage = "\"Please consider optimizing your API call frequency\"";
        if (value.equals(missingApiKey)) {
            throw new MissingApiKeyException();
        } else if (value.equals(invalidKey)) {
            throw new InvalidApiKeyException();
        } else if (value.equals(invalidFunction)) {
            throw new MalFormattedFunctionException(function);
        } else if (value.equals(missingOrInvalidFunctionParam)) {
            throw new InvalidFunctionOptionException(function);
        } else if (value.equals(highUsuage)) {
            throw new UltraHighFrequencyRequestException();
        }

    }

    public static void handleException(Map.Entry<String, JsonNode> mapEntry, String function) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        if (mapEntry.getKey().equals("Error Message")) {
            String value = mapEntry.getValue().toString();
            ExceptionUtil.handleExceptions(value, function);
        }

        if (mapEntry.getKey().equals("Information")) {
            String value = mapEntry.getValue().toString();
            ExceptionUtil.handleExceptions(value, function);
        }
    }
}
