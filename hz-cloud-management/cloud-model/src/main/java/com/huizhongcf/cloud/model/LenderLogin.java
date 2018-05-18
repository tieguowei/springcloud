package com.huizhongcf.cloud.model;

import java.util.Date;

public class LenderLogin extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2571209908460385990L;

	/**
	 * 昵称
	 */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 登录密码
     */
    private String loginPwd;
    
    /**
     * 支付密码
     */
    private String tradePwd;

    /**
     * 激活码
     */
    private String activateCode;

    /**
     * 激活过期时间
     */
    private Long activateOvertime;

    /**
     * 绑定状态：0 未绑定 ，1 已绑定
     */
    private String activateState;

    /**
     * 推荐码
     */
    private String referralCode;

    /**
     * 实名认证次数
     */
    private Integer certificationTime;
    
    /**
     * 注册方式
     */
    private String registerWay;
    
    /**
     * 系统编码标示
     */
    private String systemCode;
    
    /**
     * 使用状态
     */
    private String useStatus;

    private Date createTime;

    private Date operateTime;
    
    public LenderLogin() {
		super();
	}

	public LenderLogin(String nickName, String mobile, String loginPwd, String registerWay, String systemCode, Date createTime) {
		super();
		this.nickName = nickName;
		this.mobile = mobile;
		this.loginPwd = loginPwd;
		this.registerWay = registerWay;
		this.systemCode = systemCode;
		this.createTime = createTime;
	}

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getTradePwd() {
		return tradePwd;
	}

	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;
	}

	public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public Long getActivateOvertime() {
        return activateOvertime;
    }

    public void setActivateOvertime(Long activateOvertime) {
        this.activateOvertime = activateOvertime;
    }

    public String getActivateState() {
        return activateState;
    }

    public void setActivateState(String activateState) {
        this.activateState = activateState;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Integer getCertificationTime() {
        return certificationTime;
    }

    public void setCertificationTime(Integer certificationTime) {
        this.certificationTime = certificationTime;
    }
    
    public String getRegisterWay() {
		return registerWay;
	}

	public void setRegisterWay(String registerWay) {
		this.registerWay = registerWay;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
    
    public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

}