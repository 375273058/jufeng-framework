package co.jufeng.model.exception;
public final class BusinessExConstants {

	public static final class sendRegisterCodeFaild {
		public static final int code = 1000;
		public static final String desc = "短信发送失败，请稍后再试";
	}

	public static final class WrongCaptcha {
		public static final int code = 1001;
		public static final String desc = "短信验证码错误，请重新输入";
	}

	public static final class LoginError {
		public static final int code = 1002;
		public static final String desc = "用户名或密码错误";
	}

	public static final class OldPwdError {
		public static final int code = 1003;
		public static final String desc = "原始密码不正确";
	}

	public static final class UserRegisted {
		public static final int code = 1004;
		public static final String desc = "此手机号已注册，请直接登录";
	}

	public static final class WrongMobileFormat {
		public static final int code = 1005;
		public static final String desc = "手机号格式不对，请重新输入";
	}

	public static final class WrongPassWordFormat {
		public static final int code = 1006;
		public static final String desc = "此密码格式不对，请重新输入";
	}

	public static final class NeverRegisterUser {
		public static final int code = 1007;
		public static final String desc = "此手机号未注册，请先注册";
	}

	public static final class WrongPassWord {
		public static final int code = 1008;
		public static final String desc = "密码错误，建议使用找回密码功能";
	}

	public static final class LockedByWrongPassWord {
		public static final int code = 1009;
		public static final String desc = "密码连续错误超过了5次，此账号已经被锁定，请30分钟后再登录或联系客服400-888-8888";
	}

	public static final class CargoOwnerLoginError {
		public static final int code = 1010;
		public static final String desc = "货主用户不能登录司机版，请登录货主版";
	}

	public static final class DriverLoginError {
		public static final int code = 1011;
		public static final String desc = "司机用户不能登录货主版，请登录司机版";
	}

	public static final class NotExistsUser {
		public static final int code = 1012;
		public static final String desc = "此用户不存在";
	}

	public static final class NameFormatError {
		public static final int code = 1013;
		public static final String desc = "姓名格式不对，请重新输入";
	}

	public static final class LicenseFormatError {
		public static final int code = 1014;
		public static final String desc = "车牌格式不对，请重新输入";
	}

	public static final class WrongCarMobileFormat {
		public static final int code = 1015;
		public static final String desc = "跟车电话格式不对，请重新输入";
	}

	public static final class CompanyNameFormatError {
		public static final int code = 1016;
		public static final String desc = "公司名称格式不对，请重新输入";
	}

	public static final class OldPassWordFormatError {
		public static final int code = 1017;
		public static final String desc = "旧密码格式不对，请重新输入";
	}

	public static final class NewPassWordFormatError {
		public static final int code = 1018;
		public static final String desc = "新密码格式不对，请重新输入";
	}

	public static final class OldPassWordError {
		public static final int code = 1019;
		public static final String desc = "旧密码错误，请重新输入";
	}

	public static final class ContentCannotBeNull {
		public static final int code = 1020;
		public static final String desc = "反馈内容不能为空，请输入";
	}

	public static final class ContentLengthOver {
		public static final int code = 1021;
		public static final String desc = "反馈内容不能超过1千个字，请精简内容";
	}

	public static final class ErrorFormatOfDate {
		public static final int code = 1022;
		public static final String desc = "发货日期格式不对，请重新选择";
	}

	public static final class TooEarlyDate {
		public static final int code = 1023;
		public static final String desc = "发货日期不能早于当前日期，请重新选择";
	}

	public static final class TransportCostFormatError {
		public static final int code = 1024;
		public static final String desc = "运费格式不对，请重新输入";
	}

	public static final class TransportCostTooBig {
		public static final int code = 1025;
		public static final String desc = "运费不能超过1个亿，请重新输入";
	}

	public static final class PaymentTermWordstooLong {
		public static final int code = 1026;
		public static final String desc = "付款条件不能超过500个字，请重新输入";
	}

	public static final class WeightFormatError {
		public static final int code = 1027;
		public static final String desc = "重量格式不对，请重新输入";
	}

	public static final class WeightTooBig {
		public static final int code = 1028;
		public static final String desc = "重量不能超过1亿吨，请重新输入";
	}

	public static final class VolumeFormatError {
		public static final int code = 1029;
		public static final String desc = "体积格式不对，请重新输入";
	}

	public static final class VolumeTooBig {
		public static final int code = 1030;
		public static final String desc = "体积不能超过1亿方，请重新输入";
	}

	public static final class RemarkWordstooLong {
		public static final int code = 1031;
		public static final String desc = "备注不能超过1000个字，请重新输入";
	}

	public static final class DriverNameFormatError {
		public static final int code = 1032;
		public static final String desc = "司机姓名格式不对，请重新输入";
	}

	public static final class UserNameNotExists {
		public static final int code = 1033;
		public static final String desc = "用户名不存在，请联系客服400-888-8888";
	}

	public static final class ErrorPassword {
		public static final int code = 1034;
		public static final String desc = "密码错误，请联系客服400-888-8888";
	}

	public static final class UserNameFormatError {
		public static final int code = 1035;
		public static final String desc = "用户名格式不对，请重新输入";
	}

	public static final class UserNameAlreadyExists {
		public static final int code = 1036;
		public static final String desc = "用户名已经存在，请重新输入";
	}

	public static final class ParkShortNameTooLong {
		public static final int code = 1037;
		public static final String desc = "园区简称不能超过20个字，请重新输入";
	}

	public static final class ParkFullNameTooLong {
		public static final int code = 1038;
		public static final String desc = "园区全称不能超过50个字，请重新输入";
	}

	public static final class ContactPersonNameFormatError {
		public static final int code = 1039;
		public static final String desc = "联系人格式不对，要求2到5个汉字，请重新输入";
	}

	public static final class TelephoneFormatError {
		public static final int code = 1040;
		public static final String desc = "电话号码格式不对，请重新输入";
	}

	public static final class AddressTooLong {
		public static final int code = 1041;
		public static final String desc = "详细地址不能超过50个字，请重新输入";
	}

	public static final class IntorductionTooLong {
		public static final int code = 1042;
		public static final String desc = "简介不能超过500个字，请重新输入";
	}

	public static final class FaxFormatError {
		public static final int code = 1043;
		public static final String desc = "传真号码格式不对，请重新输入";
	}

	public static final class EmailFormatError {
		public static final int code = 1044;
		public static final String desc = "电子邮箱格式不对，请重新输入";
	}

	public static final class Telephone400FormatError {
		public static final int code = 1045;
		public static final String desc = "400电话格式不对，请重新输入";
	}

	public static final class TopLevelDomainFormatError {
		public static final int code = 1046;
		public static final String desc = "一级域名格式不对，请重新输入";
	}

	public static final class ServiceQQFormatError {
		public static final int code = 1047;
		public static final String desc = "客服QQ格式不对，请重新输入";
	}

	public static final class AdNameTooLong {
		public static final int code = 1048;
		public static final String desc = "广告名称不能超过50个字，请重新输入";
	}

	public static final class AdContentTooLong {
		public static final int code = 1049;
		public static final String desc = "广告内容不能超过1000个字，请重新输入";
	}

	public static final class ClickAfterUrlFormatError {
		public static final int code = 1050;
		public static final String desc = "跳转URL格式不对，请重新输入";
	}

	public static final class TitleTooLong {
		public static final int code = 1051;
		public static final String desc = "标题不能超过20个字，请重新输入";
	}

	public static final class MerchantsContentTooLong {
		public static final int code = 1052;
		public static final String desc = "招商详情不能超过1000个字，请重新输入";
	}

	public static final class NewsContentTooLong {
		public static final int code = 1053;
		public static final String desc = "新闻内容不能超过2000个字，请重新输入";
	}

	public static final class SummaryTooLong {
		public static final int code = 1054;
		public static final String desc = "简介不能超过200个字，请重新输入";
	}

	public static final class SourceTooLong {
		public static final int code = 1055;
		public static final String desc = "来源不能超过20个字，请重新输入";
	}
	public static final class ContentTooLong {
		public static final int code = 1056;
		public static final String desc = "内容不能超过2000个字，请重新输入";
	}
}
