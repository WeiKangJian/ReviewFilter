package TrainAndCategorization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Propoess.InputOutput;
import Propoess.PreProcess;
import SVMNecessaryPart.SVMPredict;
import SVMNecessaryPart.SVMScale;
import TermPresentAndLdaExtend.TermRepresent;


public class TextCategorizationMain  {
	private static double unhappy=0;
	private static double happy=0;
	private static double indiffient=0;
	public  boolean predict(String st) throws IOException{
		ArrayList<Integer> list =new ArrayList<Integer>();
	//1读入待分类文本集文件
	String dir="test/";
	String CorpusFile=dir+"test.txt";
	InputOutput rw=new InputOutput();
	String[] inputCorpus=rw.readInput(CorpusFile);
	ArrayList<String> l = new ArrayList<String>(Arrays.asList(inputCorpus));
	l.add("666|"+st);
	  String[] inputCorpus2=new String[l.size()];
      l.toArray(inputCorpus2);
	
	
	
	//2预处理
	PreProcess p=new PreProcess();
	String[] docs=p.preProcessMain(inputCorpus2);
	String trainFileSeg=CorpusFile.substring(0,CorpusFile.lastIndexOf("."))+"Segment.txt";		
	rw.writeOutput(docs, trainFileSeg);
	System.out.println("预处理完毕");
	//3文本表示
	//读入特征词典文件
	String termDicFile="整合原始数据集termDic.txt";
	String[] terms=rw.readInput(termDicFile);
	
	//基于特征词典进行文本表示
	TermRepresent tr=new TermRepresent();		
	String[] trDocs=tr.TermRepresentMain(docs,terms);
	
	//将文本表示写入文件
	String trFile=dir+"testSetTR.txt";
	rw.writeOutput(trDocs, trFile);
	
	
	//4scale处理
	//2使用range文件对训练集进行归一化处理
	String scaleFile=trFile+".scale";
	String rangeFile="整合原始数据集SegmentTR.txt.range";
	String argv[]={"-t",scaleFile,"-r",rangeFile,trFile};
	SVMScale s = new SVMScale();
	s.run(argv);
	
	
	//5 文本分类
	//三个参数分别是经过Scale处理的待分类的数据文件，存放分类器模型的文件，存储分类结果的文件
	//String scaleFile="10crossdatairis_libsvm_scale/3/testSet.txt";
	//String modelFile="10crossdatairis_libsvm_scale/3/InitTrainSet.txt.model";
	
	String modelFile="整合原始数据集SegmentTR.txt.scale.model";
	String predictFile=scaleFile+"predict.txt";
	String argv1[]={scaleFile,modelFile,predictFile};
	
	//String modelFile="Data/InitTrainSetSegmentTR.txt.model";
	//String predictFile=trFile+".pred0ict";
	//String argv1[]={trFile,modelFile,predictFile};
	SVMPredict predict = new SVMPredict();		
	ArrayList<Integer> list1 =new ArrayList<Integer>(predict.run(argv1));
	System.out.println("详细分类结果如下");
	System.out.println(list1);
	if(list1.get(list1.size()-1)==2)
		return false;
	return true;
//	for(Integer index:list1){
//		if(index==0)
//			indiffient++;
//		else if(index==1)
//			happy++;
//		else if(index==2)
//			unhappy++;
//	}
//	System.out.println("各个情绪所占总数百分比");
//	System.out.println("indiffient"+": "+indiffient/list1.size());
//	System.out.println("happy"+": "+happy/list1.size());
//	System.out.println("unhappy"+": "+unhappy/list1.size());
//	System.out.println("result(1-2/1+2):"+(happy-unhappy)/(happy+unhappy)*100+"%");
	
}
	public static void main(String args[]) throws IOException{
		TextCategorizationMain text =new TextCategorizationMain();
		System.out.println(text.predict("感觉还是出了一些问题"));
	}
}
