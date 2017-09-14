package com.kxll.base;

public enum Result {
	SUCCESS("成功", "0000"), FAILURE("失败", "1111");
    // 成员变量
    private String msg;
    private String code;

    // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
    private Result(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    // 普通方法
    public static String getMsg(String code) {
        for (Result c : Result .values()) {
            if (c.getCode().equals(code)) {
                return c.msg;
            }
        }
        return null;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    
}
