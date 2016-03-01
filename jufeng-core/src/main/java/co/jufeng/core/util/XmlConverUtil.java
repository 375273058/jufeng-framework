package co.jufeng.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlConverUtil {

	public static String mapToXml(Map<String, Object> map, String xmlBodyName) {
		Document document = DocumentHelper.createDocument();
		if (StringUtils.isEmpty(xmlBodyName)) {
			xmlBodyName = "node";
		}
		Element nodeElement = document.addElement(xmlBodyName);
		for (Object obj : map.keySet()) {
			Element keyElement = nodeElement.addElement(String.valueOf(obj));
			// keyElement.addAttribute("label", String.valueOf(obj));
			keyElement.setText(String.valueOf(map.get(obj)));
		}
		return doc2String(document);
	}

	public static String listToXml(List<?> list, String xmlBodyName)
			throws Exception {
		Document document = DocumentHelper.createDocument();
		if (StringUtils.isEmpty(xmlBodyName)) {
			xmlBodyName = "node";
		}
		Element nodeElement = document.addElement(xmlBodyName);
		int i = 0;
		// Element nodeElement = nodesElement.addElement("node");
		for (Object o : list) {
			if (o instanceof Map) {
				for (Object obj : ((Map<?, ?>) o).keySet()) {
					Element keyElement = nodeElement.addElement(String
							.valueOf(obj));
					// keyElement.addAttribute("label", String.valueOf(obj));
					keyElement
							.setText(String.valueOf(((Map<?, ?>) o).get(obj)));
				}
			} else {
				Element keyElement = nodeElement.addElement("key" + (i + 1));
				// keyElement.addAttribute("label", String.valueOf(i));
				keyElement.setText(String.valueOf(o));
			}
			i++;
		}
		return doc2String(document);
	}

	public static String jsonToXml(String json) {
		try {
			XMLSerializer serializer = new XMLSerializer();
			JSON jsonObject = JSONSerializer.toJSON(json);
			return serializer.write(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static Map xml2map(String xmlString) throws DocumentException {
		Document doc = DocumentHelper.parseText(xmlString);
		Element rootElement = doc.getRootElement();
		Map<String, Object> map = new HashMap<String, Object>();
		ele2map(map, rootElement);
		// 到此xml2map完成，下面的代码是将map转成了json用来观察我们的xml2map转换的是否ok
//		String string = JSONObject.fromObject(map).toString();
//		System.out.println(string);
		return map;
	}

	/***
	 * 核心方法，里面有递归调用
	 * 
	 * @param map
	 * @param ele
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void ele2map(Map map, Element ele) {
		// 获得当前节点的子节点
		List<Element> elements = ele.elements();
		if (elements.size() == 0) {
			// 没有子节点说明当前节点是叶子节点，直接取值即可
			map.put(ele.getName(), ele.getText());
		} else if (elements.size() == 1) {
			// 只有一个子节点说明不用考虑list的情况，直接继续递归即可
			Map<String, Object> tempMap = new HashMap<String, Object>();
			ele2map(tempMap, elements.get(0));
			map.put(ele.getName(), tempMap);
		} else {
			// 多个子节点的话就得考虑list的情况了，比如多个子节点有节点名称相同的
			// 构造一个map用来去重
			Map<String, Object> tempMap = new HashMap<String, Object>();
			for (Element element : elements) {
				tempMap.put(element.getName(), null);
			}
			Set<String> keySet = tempMap.keySet();
			for (String string : keySet) {
				Namespace namespace = elements.get(0).getNamespace();
				List<Element> elements2 = ele.elements(new QName(string,
						namespace));
				// 如果同名的数目大于1则表示要构建list
				if (elements2.size() > 1) {
					List<Map> list = new ArrayList<Map>();
					for (Element element : elements2) {
						Map<String, Object> tempMap1 = new HashMap<String, Object>();
						ele2map(tempMap1, element);
						list.add(tempMap1);
					}
					map.put(string, list);
				} else {
					// 同名的数量不大于1则直接递归去
					Map<String, Object> tempMap1 = new HashMap<String, Object>();
					ele2map(tempMap1, elements2.get(0));
					map.put(string, tempMap1);
				}
			}
		}
	}

	 public static Map<String, Object> xmlToMap(String xml) {
	// try {
	// Map<String, Object> map = new HashMap<String, Object>();
	// Document document = DocumentHelper.parseText(xml);
	//
	// Element nodeElement = document.getRootElement();
	// List<Element> elementList = nodeElement.elements();
	// for(Element e : elementList){
	// System.out.println(e.getStringValue());
	// System.out.println(e.getName());
	// }
	//
	//
	//
	// Element root = document.getRootElement();
	// List attrList = root.attributes();
	// for (int i = 0; i < attrList.size(); i++) {
	// //属性的取得
	// Attribute item = (Attribute)attrList.get(i);
	// System.out.println(item.getName() + "=" + item.getValue());
	// }
	// List childList = root.elements();
	// for (int i = 0; i < childList.size(); i++) {
	// //子节点的操作
	// Element it = (Element) childList.get(i);
	// System.out.println(it.getName() + "=" + it.getStringValue());
	// //对子节点进行其它操作...
	// }
	//
	//
	// // Element nodeElement = document.getRootElement();
	// List<?> node = nodeElement.elements();
	// for (Iterator<?> it = node.iterator(); it.hasNext();) {
	// Element elm = (Element) it.next();
	// System.out.println(elm);
	// map.put(elm.attributeValue("label"), elm.getText());
	// elm = null;
	// }
	// node = null;
	// nodeElement = null;
	// document = null;
	// return map;
	//
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
		 return null;
 	}

	public static List<Map<?, ?>> xmltoList(String xml) {
		try {
			List<Map<?, ?>> list = new ArrayList<Map<?, ?>>();
			Document document = DocumentHelper.parseText(xml);
			Element nodesElement = document.getRootElement();
			List<?> nodes = nodesElement.elements();
			for (Iterator<?> its = nodes.iterator(); its.hasNext();) {
				Element nodeElement = (Element) its.next();
				Map<?, ?> map = xmlToMap(nodeElement.asXML());
				list.add(map);
				map = null;
			}
			nodes = null;
			nodesElement = null;
			document = null;
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJsonString(String xml) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		return xmlSerializer.read(xml).toString();
	}

	public static String toJsonString(File xmlFile) {
		try {
			InputStream is = new FileInputStream(xmlFile);
			InputStreamReader isr = new InputStreamReader(is);
			int defaultCharBufferSize = 1024 * 8;
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(isr, defaultCharBufferSize);
			// BufferedReader br = new BufferedReader(isr);
			String data = null;
			StringBuffer buffer = new StringBuffer();
			while ((data = br.readLine()) != null) {
				buffer.append(data);
			}
			return toJsonString(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getXmlString(File file) {
		try {
			InputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is);
			int defaultCharBufferSize = 1024 * 8;
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(isr, defaultCharBufferSize);
			// BufferedReader br = new BufferedReader(isr);
			String data = null;
			StringBuffer buffer = new StringBuffer();
			while ((data = br.readLine()) != null) {
				buffer.append(data);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String doc2String(Document document) {
		String s = "";
		try {
			// 使用输出流来进行转化
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			// 使用UTF-8编码
			OutputFormat format = new OutputFormat("   ", true, "UTF-8");
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(document);
			s = out.toString("UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
}