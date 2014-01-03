package com.adj.dataInsert;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author null H20121012.java 2012-10-12����11:40:21
 */
public class TxtParser {
	/**
	 * ���ܣ�Java��ȡtxt�ļ������� ���裺1���Ȼ���ļ���� 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ��� 4��һ��һ�е������readline()�� ��ע����Ҫ���ǵ����쳣���
	 * 
	 * @param filePath
	 */
	public static void readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
//				BufferedReader bufferedReader = new BufferedReader(read);
//				String lineTxt = null;
//				while ((lineTxt = bufferedReader.readLine()) != null) {
//					
//					System.out.println(lineTxt);
//				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

	}

	public static void parseTxtFile(String filePath) {
		int excutNum = 0;
		
		try {
			String encoding = "utf8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				JDBCTool tl = new JDBCTool();
				tl.initialize();
				while ((lineTxt = bufferedReader.readLine()) != null) { //�ַ�������ͬʱ�������ݿ�
					StringProcesser sp = new StringProcesser();
					excutNum += sp.processString(lineTxt, tl);
					//System.out.println(lineTxt);
				}
				read.close();
				tl.destroy();
				System.out.println("�ܹ�����"+excutNum+"����");
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

	}

//	public static void main(String argv[]) {
//		String filePath = "F:\\data.sql";
//		// "res/";
//		readTxtFile(filePath);
//	}

}