package com.example.demo.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("接口返回")
public class Result<T> {
    
    @ApiModelProperty(value="返回CODE", example="0000")
	private String resultCode;
    @ApiModelProperty(value="返回说明")
	private String resultDesc;
    @ApiModelProperty(value="返回对象")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private T resultData;
	
	@JsonIgnore
	public boolean isSuccess() {
		return ResultCode.RESULT_SUCCESS.equals(resultCode);
	}

	@JsonIgnore
	public boolean isError() {
		return !isSuccess();
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}
	
    public static <E> Result<E> successResult() {
        return result(ResultCode.RESULT_SUCCESS);
    }

    public static <E> Result<E> successResult(E data) {
        Result<E> result = successResult();
        result.setResultData(data);
        return result;
    }

	public static <E> Result<E> result(String resultCode) {
		return result(resultCode, ResultCode.getValueByKey(resultCode));
	}

	public static <E> Result<E> result(String resultCode, String desc) {
		Result<E> result = new Result<E>();
		result.setResultCode(resultCode);
		result.setResultDesc(desc);
		return result;
	}
	
}
