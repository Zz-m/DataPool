package com.adj.dataInsert;

import java.util.regex.*;

public class StringProcesser {

	public int processString(String lineTxt, JDBCTool tl) {
		int excutNum = 0;
		int noExucutNum = 0;
		String result1 = null;
		String[] result2 = new String[7];
		// String tvSign = null;
		String matchString = lineTxt;
		Pattern pattern1 = Pattern.compile("\\([^)]*\\)");
		Matcher matcher1 = pattern1.matcher(matchString);
//		JDBCTool tl = new JDBCTool();
//		tl.initialize();
		while (matcher1.find()) {
			result1 = matcher1.group();
			result1 = result1.trim();
			// System.out.println(result1);
			result2 = getResult2(result1);
			if (result2 != null)
				try {
					// for (int i = 0; i < 7; i++){
					// System.out.println(result2[i]);
					// }
					tl.execute(result2);
					excutNum++;
				} catch (Exception e) {
					noExucutNum++;
					// System.out.println("错误数据，处理跳过");
					// e.printStackTrace();
				}
			// matchString.replace(device, "");
			// System.out.println(matchString);

		}
		
		System.out.println("存入" + excutNum + "条，" + "错误" + noExucutNum + "条。");
		return excutNum;
	}

	private String[] getResult2(String result1) {
		int index = 0;
		String resulta;
		String[] resultb = new String[7];
		Pattern pattern1 = Pattern.compile("(^|,)[^,]*(,|&)");
		Matcher matcher1 = pattern1.matcher(result1);

		try {
			while (matcher1.find()) { // 重写try catch 防止数组溢出

				resulta = matcher1.group();
				result1 = result1.replace(resulta, "");
				matcher1 = pattern1.matcher(result1);
				// System.out.println(resulta);
				boolean flag1 = true;
				boolean flag2 = true;
				while (flag1) {
					// String s = new Character('a').toString();
					if (resulta.charAt(0) == new Character(',')
							|| resulta.charAt(0) == new Character('\'')
							|| resulta.charAt(0) == new Character('(')
							|| resulta.charAt(0) == new Character(')')) {
						resulta = resulta.substring(1, resulta.length());
					} else {
						flag1 = false;
					}
				}
				while (flag2) {
					// String s = new Character('a').toString();
					if (resulta.charAt(resulta.length() - 1) == new Character(
							',')
							|| resulta.charAt(resulta.length() - 1) == new Character(
									'\'')
							|| resulta.charAt(resulta.length() - 1) == new Character(
									'(')
							|| resulta.charAt(resulta.length() - 1) == new Character(
									')')) {
						resulta = resulta.substring(0, resulta.length() - 1);
					} else {
						flag2 = false;
					}
				}
				resultb[index] = resulta;
				index++;

				// result2 = getResult2(result1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据错误，跳过插入操作");
			return null;
		}
		return resultb;
	}

}
