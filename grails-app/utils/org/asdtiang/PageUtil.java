package org.asdtiang;

public class PageUtil {
	
	/**
	 * 根据包名和类名获取类的实例
	 * @name 包名+类名
	 * @return类的实例
	 */
	public static Object getInstanceByName(String name){
		try {
			return Class.forName(name).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
