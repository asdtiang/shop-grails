package org.asdtiang

import java.util.regex.Matcher
import java.util.regex.Pattern

import org.asdtiang.site.config.ConfigDomain



/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-1
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 */
class StaticMethod {
    public static Map addToConfigMap(Map configMap, ConfigDomain configDomain) {
        if (configDomain.valueType == ConfigDomain.ValueType.Integer) {
            configMap.put(configDomain.mapName, Integer.parseInt(configDomain.mapValue))
        } else {
            configMap.put(configDomain.mapName, configDomain.mapValue)
        }
        return configMap
    }

	public static String UnicodeToString(String str) {
		Pattern pattern = Pattern.compile("(\\\\u(\\w{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
			str = str.replace(matcher.group(1), ch.toString() + "");
		}
		return str;
	}
	
	
}
