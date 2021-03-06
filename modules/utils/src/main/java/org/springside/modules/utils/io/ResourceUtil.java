package org.springside.modules.utils.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

import org.springside.modules.utils.text.Charsets;

import com.google.common.io.Resources;

/**
 * 针对Jar包内的文件的工具类
 */
public class ResourceUtil {
	public File asFile(Class<?> contextClass, String resourceName) throws IOException {
		try {
			return new File(Resources.getResource(contextClass, resourceName).toURI());
		} catch (URISyntaxException e) {
			return null;
		}
	}

	public File asFile(String resourceName) throws IOException {
		try {
			return new File(Resources.getResource(resourceName).toURI());
		} catch (URISyntaxException e) {
			return null;
		}
	}

	public InputStream asStream(String resourceName) throws IOException {
		return Resources.getResource(resourceName).openStream();
	}

	public InputStream asStream(Class<?> contextClass, String resourceName) throws IOException {
		return Resources.getResource(contextClass, resourceName).openStream();
	}

	public String toString(String resourceName) throws IOException {
		return Resources.toString(Resources.getResource(resourceName), Charsets.UTF_8);
	}

	public String toString(Class<?> contextClass, String resourceName) throws IOException {
		return Resources.toString(Resources.getResource(contextClass, resourceName), Charsets.UTF_8);
	}

	public List<String> toLines(String resourceName) throws IOException {
		return Resources.readLines(Resources.getResource(resourceName), Charsets.UTF_8);
	}

	public List<String> toLines(Class<?> contextClass, String resourceName) throws IOException {
		return Resources.readLines(Resources.getResource(contextClass, resourceName), Charsets.UTF_8);
	}
}
