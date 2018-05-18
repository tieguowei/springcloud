package com.huizhongcf.util;

/** 
 *<dl> 
 *<dt>类名：Constants</dt> 
 *<dd>描述: 系统常量</dd>  
 *<dd>创建时间： 2017-8-9 15:19:43</dd> 
 *<dd>创建人： haochunhe</dd> 
 *<dt>版本历史: </dt> 
 * <pre> 
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2017-8-9 15:19:43    haochunhe       2.0        2.0 Version  
 * </pre> 
 *</dl> 
 */ 
public class Constants {
	
	public static final String ACTIVATED_STATE_DISABLE = "0";//员工用户使用状态：0:停用
	
	public static final String ACTIVATED_STATE_ENABLED = "1";//员工用户使用状态：1:启用
	
	public static final String EMPLOYEE_SEX_NAN = "0";//员工性别 0是男， 1是女
	public static final String EMPLOYEE_SEX_NV = "1";
	
	public static final String SYSTEM_CODE = "zhywlc"; /** 理财端的系统标识*/
	
	public static final String Type_Code_QYJL = "01"; //区域经理
	public static final String Type_Code_CSJL = "02"; //城市经理
	public static final String Type_Code_YYBJL = "03"; //营业部经理
	public static final String Type_Code_TDJL = "04"; //团队经理
	public static final String Type_Code_ZXZY = "05"; //咨询专员
	public static final String Type_Code_ZND = "06"; //职能端
	
	
	
	public static final String LIQUIDATION_STATUS_DJS = "1";//结算状态待结算
	public static final String LIQUIDATION_STATUS_YJS = "2";//结算状态已结算
	
	/**投资表中的订单状态*/
	public static final String INVEST_STATUS_1 = "1";//投资状态，1：预约中，2：计息中，3：已结清，4：作废
	public static final String INVEST_STATUS_2 = "2";//投资状态，1：预约中，2：计息中，3：已结清，4：作废
	public static final String INVEST_STATUS_3 = "3";//投资状态，1：预约中，2：计息中，3：已结清，4：作废
	public static final String INVEST_STATUS_4 = "4";//投资状态，1：预约中，2：计息中，3：已结清，4：作废

	/**奖金类型*/
	public static final String BONUS_TYPE_10 = "10";//奖金类型，10：出借奖金，20：差额奖金，30：服务奖金
	public static final String BONUS_TYPE_20 = "20";//奖金类型，10：出借奖金，20：差额奖金，30：服务奖金
	public static final String BONUS_TYPE_30 = "30";//奖金类型，10：出借奖金，20：差额奖金，30：服务奖金

	/**用户角色*/
	public static final String USER_ROLE_10 = "10";//用户角色，10：合伙人，20：客户
	public static final String USER_ROLE_20 = "20";//用户角色，10：合伙人，20：客户
	/**用户身份*/
	public static final String USER_TYPE_10 = "10";//用户身份，10：一般合伙人，20：团队管理者
	public static final String USER_TYPE_20 = "20";//用户身份，10：一般合伙人，20：团队管理者

	/**封存状态*/
	public static final String SEAL_STATUS_0 = "0";//封存状态，0：未封存，1：已封存
	public static final String SEAL_STATUS_1 = "1";//封存状态，0：未封存，1：已封存

	/**结算状态*/
	public static final String LIQUIDATION_STATUS_10 = "10";//结算状态，10：已结算，20：已支付
	public static final String LIQUIDATION_STATUS_20 = "20";//结算状态，10：已结算，20：已支付

	/**系统标识*/
	public static final String SYSTEM_CODE_01 = "01";//系统标识，01：汇中网，20：合伙人
	public static final String SYSTEM_CODE_02 = "02";//系统标识，02：汇中网，20：合伙人

	/**用户状态*/
	public static final String USER_STATUS_1 = "1";//用户状态，1：启用，2：停用
	public static final String USER_STATUS_2 = "2";//用户状态，1：启用，2：停用
	public static final int PAGE_SIZE = 10;

	/**注册来源*/
	public static final String REGIST_SOURCE_01 = "01";//注册来源，01：汇中网，02：APP，03：H5
	public static final String REGIST_SOURCE_02 = "02";//注册来源，01：汇中网，02：APP，03：H5
	public static final String REGIST_SOURCE_03 = "03";//注册来源，01：汇中网，02：APP，03：H5
	/**邀请码类型*/
	public static final String INVITE_CODE_TYPE_10 = "10";//邀请码类型，10：平台邀请码，20：团队管理者邀请码
	public static final String INVITE_CODE_TYPE_20 = "20";//邀请码类型，10：平台邀请码，20：团队管理者邀请码
	/**是否平台邀请*/
	public static final String IS_PLATFORM_INVITE_1 = "1";//是否平台邀请，1：是，0：否
	public static final String IS_PLATFORM_INVITE_0 = "0";//是否平台邀请，1：是，0：否
	/**邀请分享类型*/
	public static final String INVITE_SHARE_TYPE_1 = "1";//邀请分享类型，1：全部邀请，2：邀请合伙人，3：邀请客户
	public static final String INVITE_SHARE_TYPE_2 = "2";//邀请分享类型，1：全部邀请，2：邀请合伙人，3：邀请客户
	public static final String INVITE_SHARE_TYPE_3 = "3";//邀请分享类型，1：全部邀请，2：邀请合伙人，3：邀请客户
	/**同步状态*/
	public static final String SYNC_STATUS_01 = "01";//同步状态，01：未同步，02：已同步
	public static final String SYNC_STATUS_02 = "02";//同步状态，01：未同步，02：已同步
	/**接口类型，01：汇中网注册同步，02：汇中网实名同步，03：汇中网订单同步，04：汇中网订单状态同步，05：合伙人注册同步
	 * */
	public static final String TRADE_TYPE_01 = "01";
	public static final String TRADE_TYPE_02 = "02";
	public static final String TRADE_TYPE_03 = "03";
	public static final String TRADE_TYPE_04 = "04";
	public static final String TRADE_TYPE_05 = "05";
	/**默认的客户推荐码*/
	public static final String customerRecommendCode="60112345678";//合伙人向汇中网同步注册用户信息，默认的客户邀请码





}