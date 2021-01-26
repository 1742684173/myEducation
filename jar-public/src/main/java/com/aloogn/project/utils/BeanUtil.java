//package com.aloogn.project.utils;
//
//import org.springframework.context.ApplicationContext;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.lang.reflect.Field;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class BeanUtil {
//	// Spring容器
//	private static ApplicationContext ctx = null;
//	public static volatile boolean beanUtilSystemFinishInit = false;
//
//	//todo
////	public static Object getBean(String beanId) {
////		return SpringUtil.getBean(beanId);
////	}
////
////	public static <T> T getBean(Class<T> clazz) throws Exception {
////		return SpringUtil.getBean(clazz);
////	}
//
//	public static String getProjectAbsRootPath() {
//		URL thisFilePath = BeanUtil.class.getResource("");
//		Package thisPackage = BeanUtil.class.getPackage();
//		String packageUrl = thisPackage.getName();
//		packageUrl = packageUrl.replaceAll("\\.", "/");
//		String absRoot = thisFilePath.getPath().substring(0, thisFilePath.getPath().indexOf(packageUrl));
//		absRoot = absRoot.substring(1);
//		return absRoot;
//	}
//
//	/**
//	 * 将bean逐层转换成map形式
//	 *
//	 * @param bean
//	 * @return
//	 * @throws Exception
//	 */
//	public static Map<String, Object> bean2Map(Object bean) throws Exception {
//		Map<String, Object> mapObjects = new HashMap<String, Object>();
//		Field[] beanFields = ClassRefUtil.getFields(bean.getClass());
//		for (Field field : beanFields) {
//			if ("serialVersionUID".equals(field.getName()) || "__".startsWith(field.getName()))
//				continue;
//			if (field.getType().getName().equals(List.class.getName())) {
//				@SuppressWarnings("unchecked")
//				List<Object> listValues = (List<Object>) ClassRefUtil.getFieldValue(bean, field.getName());
//				List<Map<String, Object>> _list = new ArrayList<Map<String, Object>>();
//				if (listValues != null && listValues.size() > 0) {
//					for (Object object : listValues) {
//						Map<String, Object> _mapListObjects = bean2Map(object);
//						_list.add(_mapListObjects);
//					}
//				}
//				mapObjects.put(field.getName(), _list);
//			} else {
//				Object value = ClassRefUtil.getFieldValue(bean, field.getName());
//				mapObjects.put(field.getName(), value);
//			}
//		}
//		return mapObjects;
//	}
//
//	/**
//	 * 从配置文件中获取配置参数
//	 *
//	 * @param entryKey
//	 * @return
//	 */
//	public static String getAppConfig(String entryKey) {
//		return ApplicationConfigUtil.getMapConfig().get(entryKey);
//	}
//
//	/**
//	 * 获取系统名称
//	 *
//	 * @return
//	 */
//	public static String getApplicationName() {
//		return ApplicationConfigUtil.getMapConfig().get("applicationName");
//	}
//
//	public static String serializableObjectOutBase64(Object object) throws Exception {
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		ObjectOutputStream obs = new ObjectOutputStream(out);
//		obs.writeObject(object);
//		obs.close();
//		String base64str = new String(Base64.encode(out.toByteArray()));
//		return base64str;
//	}
//
//	public static Object unserializableObjectInBase64(String string) throws Exception {
//		byte[] bytes = Base64.decode(string);
//		ByteArrayInputStream ios = new ByteArrayInputStream(bytes);
//		ObjectInputStream ois = new ObjectInputStream(ios);
//		Object object = ois.readObject();
//		ois.close();
//		return object;
//	}
//
//}
