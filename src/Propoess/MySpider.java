package Propoess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MySpider {
	private static final String url1 = "http://guba.eastmoney.com/list,300059_";
	private static final String url2 = ".html";

	public static void preprocess(String dir) {
		// 预处理部分
		InputOutput rw = new InputOutput();
		String its[] = rw.readInput(dir+".txt");
		PreProcess p = new PreProcess();
		try {
			String docus[] = p.preProcessMain(its);
			new File(dir+"Segment.txt");
			PrintStream pr2 = new PrintStream(
					new FileOutputStream(new File(dir+"Segment.txt")));
			for (int i = 0; i < docus.length; i++) {
				pr2.println(docus[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeOutput2(String[] outputContent,String outputFileName)
    {
       //将outputContent中的内容写入文件outputFileName中
		File f = new File(outputFileName);
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for(int i=0;i<outputContent.length;i++)
			{
				bw.write("2"+"|"+outputContent[i]);
				bw.newLine();				
			}
			bw.close();
		}
		catch (Exception ex)
	    {
	            ex.printStackTrace();
	    }		
    }
//	public void writeOutput3(String[] outputContent,String outputFileName)
//    {
//       //将outputContent中的内容写入文件outputFileName中
//		File f = new File(outputFileName);
//		try{
//			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//			for(int i=0;i<outputContent.length;i++)
//			{
//				bw.write(outputContent[i]);
//				if(i%10==0)
//				bw.newLine();				
//			}
//			bw.close();
//		}
//		catch (Exception ex)
//	    {
//	            ex.printStackTrace();
//	    }		
//    }
	public static void main(String[] args) throws FileNotFoundException {
//		InputOutput rw = new InputOutput();
//		String strs[] = rw.readInput("整理.txt");
//		MySpider a =new MySpider();
//		a.writeOutput2(strs, "Sample.txt");
//		a.preprocess("Sample");
/////////////////////////////////////////////////////////////////////////////////////////
		MySpider b =new MySpider();
		InputOutput rw =new InputOutput();
		String strs2[] =rw.readInput("敏感词库处理.txt");
		b.writeOutput2(strs2, "敏感词库处理2.txt");
		b.preprocess("敏感词库处理2");
		

	}
}
