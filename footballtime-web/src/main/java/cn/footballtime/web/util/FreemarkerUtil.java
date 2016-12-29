package cn.footballtime.web.util;

import java.io.*;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	/**
	 * 获取模板
	 * 
	 * @param name
	 * @return
	 */
	public Template getTemplate(String name) {
		try {
			//创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
			//指定版本号
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);//这里是对应的你使用jar包的版本号：<version>2.3.23</version>
			//设置模板目录
			//configuration.setDirectoryForTemplateLoading(new File("src/main/java/templates"));
			configuration.setDirectoryForTemplateLoading(new File("src/main/webapp/WEB-INF/views/ftl/test"));
			//设置默认编码格式
			configuration.setDefaultEncoding("UTF-8");
			// 在模板文件目录中找到名称为name的文件
			Template template = configuration.getTemplate(name);
			
			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 输出到控制台
	 * 
	 * @param name
	 *            模板文件名
	 * @param root
	 */
	public void print(String name, Map<String, Object> root) {
		try {
			// 通过Template可以将模板文件输出到相应的流
			Template temp = this.getTemplate(name);

			//合并模板和数据模型
			Writer out = new OutputStreamWriter(System.out);
			temp.process(root, out);

			//关闭
			out.flush();
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出到文件
	 * 
	 * @param name
	 * @param root
	 * @param outFile
	 */
	public void exportHtml(String name, Map<String, Object> root, String outFile) {
		Writer out = null;
		try {
			Template temp = this.getTemplate(name);

			out = new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8");
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
