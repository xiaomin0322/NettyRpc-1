package com.nettyrpc.protocol;

/**
 * RPC Response
 * @author huangyong
 */
public class RpcResponse {
    private String requestId;
    private String error;
    private Object result;
    private Throwable throwable;
    

    public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public boolean isError() {
        return error != null;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
    	if(throwable!=null){
    		try {
				throw getThrowable();
			} catch (Throwable e) {
				e.printStackTrace();
			}
    	}
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
