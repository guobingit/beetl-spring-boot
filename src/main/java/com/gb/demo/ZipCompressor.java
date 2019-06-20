package com.gb.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;


public class ZipCompressor {
	
	static final int BUFFER = 8192;
	
	/**
	 * 压缩文件
	 * @param srcPathName
	 */
	public void compress(String zipFile, String srcPathName) {
		File file = new File(srcPathName);
		if (!file.exists())
			throw new RuntimeException(srcPathName + "不存在！");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
			CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,new CRC32());  //不加CRC32，一样可以生成文件。关于数据如何校验，请高手指点
			ZipOutputStream out = new ZipOutputStream(cos);
			out.setEncoding("gbk");  //如果不加此句，压缩文件依然可以生成，只是在打开和解压的时候，会显示乱码，但是还是会解压出来
			String basedir = "";
			compress(file, out, basedir);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void compress(File file, ZipOutputStream out, String basedir) {
		if (file.isDirectory()) {
			if (!file.exists())
				return;
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				/* 递归 */
				compress(files[i], out, basedir + file.getName() + "/");
			}
		} else {
			if (!file.exists()) {
				return;
			}
			try {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				ZipEntry entry = new ZipEntry(basedir + file.getName());
				out.putNextEntry(entry);
				int count;
				byte data[] = new byte[BUFFER];
				while ((count = bis.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				bis.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
		ZipCompressor zc = new ZipCompressor();
		zc.compress("D:\\html.zip","D:\\workspace\\daya_dsa\\similarity-analysis_local_test\\target\\similarity_analysis_local_tes\\pages\\html");  //压缩一个文件夹
		
	}
}
