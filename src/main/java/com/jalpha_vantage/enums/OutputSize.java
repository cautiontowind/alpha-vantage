package com.jalpha_vantage.enums;

/**
 * compact is used to returns only the latest 100 data points
 * full returns the full-length intraday time series.
 * The "compact" option is recommended if you would like to reduce the data size of each API call.
 */
public enum OutputSize {
    COMPACT("compact"),
    FULL("full");

    private final String value;
    private final static  String KEY="outputsize=";
    private OutputSize(String value){
        this.value = value;
    }

    /**
     * Returns the key=value string to be inserted in any query
     *
     * @return String outputsize='Value'
     * For example COMPACT.uriPath() returns "outputsize=compact"
     */
    public String uriPath(){
        return KEY.concat(value);
    }
}
