package cn.mldn.util.web.validator;
/**
 * 本类专门负责进行各种字符串的数据格式验证
 * @author Administrator
 *
 */
public class ValueRuleValidator {
	private ValueRuleValidator(){}
	/**
	 * 进行上传文件类型的检测
	 * @param rule 所有的验证规则
	 * @param contentType 当前的文件类型
	 * @return 符合规则返回true
	 */
	public static boolean isMIME(String rule,String contentType){
 		if(isString(rule) && isString(contentType)){
			String ruleResult[] = rule.split("\\|");
			for(int x=0;x<ruleResult.length;x++){
				if(contentType.equals(ruleResult[x])){
					return true ;
				}
			}
		}
		return false ;
	}
	public static boolean isBoolean(String str){
		if(isString(str)){
			return "true".equals(str) ||"false".equals(str);
		}
		return false;
	}
	/**
	 * 进行验证码的检测
	 * @param str 要验证的字符串
	 * @param rand 生成的验证码
	 * @return 验证码与输入的字符串相同返回true
	 */
	public static boolean isRand(String str,String rand){
		if(isString(str) && isString(rand)){	//必须保证数据不能为空
			return str.equalsIgnoreCase(rand);
		}
		return false ;
	}
	public static boolean isDateTime(String str){
		if(isString(str)){	//必须保证数据不允许为空
			return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return false ;
	}
	public static boolean isDate(String str){
		if(isString(str)){	//必须保证数据不允许为空
			return str.matches("\\d{4}-\\d{2}-\\d{2}");
		}
		return false ;
	}
	public static boolean isDouble(String str){
		if(isString(str)){ //必须保证数据不允许为空
			return str.matches("\\d+(\\.\\d+)?");
		} 
		return false ;
	}
	public static boolean isLong(String str){
		if(isString(str)){//必须保证数据不允许为空
			return isInt(str);
		}
		return false;
	}
	public static boolean isInt(String str){
		if(isString(str)){//必须保证数据不允许为空
			return str.matches("\\d+");
		} 
		return false;
	}
	/**
	 * 进行字符串是否为空的验证处理
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		if(str==null ||"".equals(str)){
			return false;
		}
		return true ;
	}
}
